rootProject.name = "java-algorithm-interview"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // ── JVM ──────────────────────────────────────────────────────────
            version("java", "25")
            version("kotlin", "2.3.20")

            // ── 플러그인 ──────────────────────────────────────────────────────
            version("spotless", "8.4.0")
            plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("spotless", "com.diffplug.spotless").versionRef("spotless")

            // ── 포맷터 / 린터 ─────────────────────────────────────────────────
            version("google-java-format", "1.35.0")
            version("ktlint", "1.8.0")
            version("checkstyle", "13.4.0")

            // ── 테스트 / 커버리지 ─────────────────────────────────────────────
            version("jacoco", "0.8.14")
            version("junit", "6.0.3")
            library("junit-bom", "org.junit", "junit-bom").versionRef("junit")
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").withoutVersion()
            library(
                "junit-platform-launcher",
                "org.junit.platform",
                "junit-platform-launcher",
            ).withoutVersion()
        }
    }
}
