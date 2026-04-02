plugins {
    java
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.spotless)
    checkstyle
    jacoco
}

group = "com.algorithminterview"
version = "1.0.0"

// ─── Toolchain ───────────────────────────────────────────────────────────────
val javaVersion =
    libs.versions.java
        .get()
        .toInt()

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion)
    }
}

kotlin {
    jvmToolchain(javaVersion)
}

// ─── Source Sets ─────────────────────────────────────────────────────────────
// 프로젝트 구조: src/ (메인), test/ (테스트)
sourceSets {
    main {
        java.setSrcDirs(listOf("src"))
        kotlin.setSrcDirs(listOf("src"))
    }
    test {
        java.setSrcDirs(listOf("test"))
        kotlin.setSrcDirs(listOf("test"))
    }
}

// ─── Repositories ────────────────────────────────────────────────────────────
repositories {
    mavenCentral()
}

// ─── Dependencies ────────────────────────────────────────────────────────────
dependencies {
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

// ─── JaCoCo (커버리지 리포트) ─────────────────────────────────────────────────
//
//  ./gradlew jacocoTestReport   → build/reports/jacoco/test/html/index.html
//
jacoco {
    toolVersion = libs.versions.jacoco.get()
}

tasks.jacocoTestReport {
    dependsOn(tasks.withType<Test>())
    reports {
        xml.required = true
        html.required = true
    }
}

// ─── check / build 연결 ──────────────────────────────────────────────────────
//
//  ./gradlew check  → spotlessApply + checkstyle + test + jacocoTestReport
//  ./gradlew build  → check (mustRunAfter) + assemble
//
//  check 실행 순서:
//    1. spotlessApply  (Java·Kotlin 자동 포맷)
//    2. compileJava / compileTestJava
//    3. checkstyleMain / checkstyleTest
//    4. test  →  jacocoTestReport (커버리지)
//
tasks.named("check") {
    dependsOn("spotlessApply")
}

// spotlessApply 가 파일을 수정한 뒤 컴파일·검사가 실행되도록 순서 보장
tasks.withType<JavaCompile>().configureEach {
    mustRunAfter("spotlessApply")
}
tasks.named("checkstyleMain") { mustRunAfter("spotlessApply") }
tasks.named("checkstyleTest") { mustRunAfter("spotlessApply") }

tasks.named("build") {
    mustRunAfter("check")
}

// ─── Spotless (자동 포맷팅) ───────────────────────────────────────────────────
//
//  ./gradlew spotlessApply   → 파일 자동 수정
//  ./gradlew spotlessCheck   → 포맷 검사만 (CI에서 사용)
//
//  Java  : google-java-format AOSP 모드 (4-space 들여쓰기, 기존 코드와 일치)
//  Kotlin: ktlint 엔진 (별도 ktlint 플러그인 불필요 — Spotless가 통합)
//
spotless {
    java {
        // AOSP 모드 = 4-space indent (기본 Google 스타일은 2-space)
        googleJavaFormat(
            libs.versions.google.java.format
                .get(),
        ).aosp()
        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
        target("src/**/*.java", "test/**/*.java")
    }
    kotlin {
        ktlint(libs.versions.ktlint.get())
            .editorConfigOverride(
                mapOf(
                    // 이 프로젝트 네이밍 규칙 허용
                    //   · 클래스명: P1_3, P96_2 (문제번호_풀이번호)
                    //   · 메서드명: Front(), Push() (문제 인터페이스 그대로 사용)
                    //   · 변수명:   N, M, INF (알고리즘 상수 관례)
                    "ktlint_standard_class-naming" to "disabled",
                    "ktlint_standard_function-naming" to "disabled",
                    "ktlint_standard_property-naming" to "disabled",
                    // 알고리즘 코드에서 java.util.* 등 wildcard import 허용
                    "ktlint_standard_no-wildcard-imports" to "disabled",
                    // 알고리즘 코드에서 긴 조건식·체이닝은 불가피하게 발생
                    "ktlint_standard_max-line-length" to "disabled",
                ),
            )
        trimTrailingWhitespace()
        endWithNewline()
        target("src/**/*.kt")
    }
    kotlinGradle {
        ktlint(libs.versions.ktlint.get())
        target("*.gradle.kts")
    }
}

// ─── Checkstyle (정적 분석) ───────────────────────────────────────────────────
//
//  Spotless가 포맷을 담당하므로 Checkstyle은 포맷 규칙을 제외하고
//  네이밍, import, 코드 품질(버그 가능성)만 검사.
//
//  ./gradlew checkstyleMain   → src/ 검사
//  ./gradlew checkstyleTest   → test/ 검사
//  ./gradlew check            → spotlessCheck + checkstyle + test 전체 실행
//
checkstyle {
    toolVersion = libs.versions.checkstyle.get()
    configFile = file("config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false
    maxWarnings = 0
}

// Checkstyle은 소스 파일을 직접 분석하므로 컴파일(compileKotlin) 에 의존할 필요 없음.
// classpath를 비워 컴파일 에러가 있어도 독립적으로 실행 가능하게 설정.
tasks.checkstyleMain {
    classpath = files()
}
tasks.checkstyleTest {
    classpath = files()
}
