# 자바 알고리즘 인터뷰 with 코틀린

102가지 알고리즘 문제 풀이로 완성하는 코딩 테스트

<img src="/assets/book-cover.png" width="40%">

《자바 알고리즘 인터뷰 with 코틀린》은 다음 판매처에서 구매하실 수 있습니다.
- [교보문고](https://product.kyobobook.co.kr/detail/S000209071463)
- [YES24](https://www.yes24.com/Product/Goods/122445610)
- [알라딘](http://aladin.kr/p/F4rm0)
- [인터파크](https://book.interpark.com/product/BookDisplay.do?_method=detail&sc.shopNo=0000400000&sc.prdNo=356798872)

및 전국 교보문고 매장

★ 정오표: (아직 등록된 정오사항이 없습니다)  
★ 도서정보: https://www.onlybook.co.kr/entry/java-algorithm-interview

★ 참고: 《파이썬 알고리즘 인터뷰》 https://github.com/onlybooks/python-algorithm-interview

![마인드맵](/assets/mindmap.png)

## 빌드 / 코드 품질

Java 25 + Kotlin 2.3 + Gradle 9.4.1 기반의 Gradle 프로젝트입니다.
**Spotless** 하나로 Java와 Kotlin 포맷팅을 통합하고, **Checkstyle**로 Java 정적 분석을, **JaCoCo**로 테스트 커버리지를 측정합니다.

### 도구 구성

| 도구 | 역할 | 대상 |
|------|------|------|
| [Spotless](https://github.com/diffplug/spotless) + [google-java-format](https://github.com/google/google-java-format) | 자동 포맷팅 | `src/**/*.java`, `test/**/*.java` |
| [Spotless](https://github.com/diffplug/spotless) + [ktlint](https://pinterest.github.io/ktlint/) | 자동 포맷팅 | `src/**/*.kt` |
| [Checkstyle](https://checkstyle.org) | 정적 분석 (네이밍·import·코드 품질) | `src/**/*.java`, `test/**/*.java` |
| [JaCoCo](https://www.jacoco.org/jacoco/) | 테스트 커버리지 리포트 | 전체 소스 |

> **ktlint 플러그인을 별도로 쓰지 않는 이유**
> Spotless가 ktlint 엔진을 내장하고 있어 기능이 동일합니다. `./gradlew spotlessApply` 하나로 Java와 Kotlin을 동시에 처리할 수 있어 설정을 단순하게 유지합니다.

---

### Spotless — 자동 포맷팅

**Java**: google-java-format AOSP 모드 (4-space 들여쓰기)
**Kotlin**: ktlint (4-space 들여쓰기)

```bash
# 파일을 직접 수정해 포맷을 맞춤 (커밋 전 실행)
./gradlew spotlessApply

# 포맷이 올바른지 검사만 수행 (파일 수정 없음, CI 용)
./gradlew spotlessCheck
```

`spotlessApply`가 자동으로 처리하는 항목:

- 들여쓰기·공백 정규화
- 미사용 `import` 제거
- 줄 끝 공백 제거
- 파일 끝 개행 보장
- Kotlin 코드 ktlint 스타일 정렬

#### 이 프로젝트에서 비활성화한 ktlint 규칙

알고리즘 문제 풀이 특성상 아래 규칙은 비활성화되어 있습니다 (`build.gradle.kts` → `editorConfigOverride`).

| 규칙 | 비활성화 이유 |
|------|--------------|
| `class-naming` | 파일명이 문제 번호 기반 (`P1_3`, `P96_2`) |
| `function-naming` | 문제 인터페이스 메서드명 그대로 사용 (`Front()`, `Push()`) |
| `property-naming` | 알고리즘 관례 변수 허용 (`N`, `M`, `INF`) |
| `no-wildcard-imports` | 알고리즘 코드에서 `java.util.*` 관행적 사용 |

---

### Checkstyle — 정적 분석

Spotless가 포맷을 담당하므로 Checkstyle은 **포맷 규칙을 포함하지 않습니다**.
검사 항목: 미사용·중복 import / 네이밍 컨벤션 / `equals`·`hashCode` 누락 / switch fall-through / 문자열 `==` 비교 / 접근 제어자 순서·중복 / `@Override` 누락 등.

```bash
# src/ 검사
./gradlew checkstyleMain

# test/ 검사
./gradlew checkstyleTest
```

#### 리포트 읽는 법

Checkstyle 검사 후 아래 경로에 HTML 리포트가 생성됩니다.

```
build/reports/checkstyle/
├── main.html    # src/ 결과
└── test.html    # test/ 결과
```

브라우저에서 열면 위반 파일·줄 번호·규칙명을 한눈에 확인할 수 있습니다.

```bash
# macOS에서 바로 열기
open build/reports/checkstyle/main.html
```

리포트 항목 예시:

| 항목 | 설명 |
|------|------|
| **File** | 위반이 발생한 소스 파일 경로 |
| **Line** | 해당 줄 번호 (클릭하면 소스 확인 가능) |
| **Message** | 위반 내용 (`Variable 'x' must match pattern` 등) |
| **Rule** | Checkstyle 규칙 이름 (`RedundantModifier`, `UnusedImports` 등) |

자주 나오는 규칙 설명:

| 규칙 | 의미 | 수정 방법 |
|------|------|----------|
| `RedundantModifier` | 비공개 중첩 클래스 생성자의 불필요한 `public` | 해당 `public` 제거 |
| `ModifierOrder` | `static public` 등 JLS 권장 순서 위반 | `public static`으로 변경 |
| `UnusedImports` | 사용하지 않는 `import` | 해당 import 제거 |
| `StringLiteralEquality` | 문자열을 `==`로 비교 | `.equals()`로 변경 |
| `FallThrough` | `switch` case에 `break` 누락 | `break` 추가 또는 `// falls through` 주석 |
| `MissingOverride` | 오버라이드 메서드에 `@Override` 없음 | `@Override` 추가 |

#### 특정 줄 억제

부득이하게 규칙을 무시해야 할 경우, 어노테이션으로 억제할 수 있습니다.

```java
// 단일 규칙 억제
@SuppressWarnings("checkstyle:RedundantModifier")
public MyConstructor() { ... }

// 여러 규칙 동시 억제
@SuppressWarnings({"checkstyle:ModifierOrder", "checkstyle:UnusedImports"})
```

---

### 전체 검사 (Spotless + Checkstyle + 테스트 + 커버리지)

```bash
./gradlew check
```

`check` 한 번으로 아래 단계가 순서대로 실행됩니다.

```
spotlessApply → compile → checkstyle → test → jacocoTestReport
```

| 단계 | 내용 |
|------|------|
| `spotlessApply` | Java·Kotlin 파일 자동 포맷 (파일 직접 수정) |
| `compile` | `src/` + `test/` 컴파일 |
| `checkstyleMain / checkstyleTest` | 정적 분석 |
| `test` | JUnit 5 테스트 실행 |
| `jacocoTestReport` | 커버리지 리포트 생성 |

### 빌드

```bash
./gradlew build
```

`check` 완료 후 JAR 패키징(`assemble`)을 수행합니다.

### 테스트 실행

```bash
./gradlew test
```

소스나 테스트 파일이 변경되지 않으면 Gradle이 `UP-TO-DATE`로 건너뜁니다.
강제로 재실행하려면 아래 명령을 사용합니다.

```bash
# test 태스크만 강제 재실행 (Gradle 7.6+)
./gradlew test --rerun

# 또는 테스트 결과물을 삭제하고 재실행
./gradlew cleanTest test
```

테스트가 끝나면 JaCoCo 커버리지 리포트도 자동으로 생성됩니다.

#### 테스트 리포트

```
build/reports/tests/test/index.html        # JUnit 결과 (통과·실패·시간)
build/reports/jacoco/test/html/index.html  # JaCoCo 커버리지 (라인·브랜치)
build/reports/jacoco/test/jacocoTestReport.xml  # XML (CI 연동용)
```

```bash
# macOS에서 바로 열기
open build/reports/tests/test/index.html
open build/reports/jacoco/test/html/index.html
```

JaCoCo 리포트 항목:

| 항목 | 설명 |
|------|------|
| **Element** | 패키지 → 클래스 → 메서드 단위로 드릴다운 가능 |
| **Missed Instructions** | 실행되지 않은 바이트코드 명령 수 |
| **Cov.** | 커버리지 비율 (녹색 = 커버됨, 빨간색 = 미커버) |
| **Missed Branches** | 실행되지 않은 분기 수 (if/switch) |
| **Missed/Total Lines** | 미실행 줄 수 / 전체 실행 가능 줄 수 |

---

## 문제 풀이
| 번호 | 제목 | 난이도 | 장 | 풀이 코드 |
| --- | --- | ---- | - | --- |
| 1 | [유효한 팰린드롬](https://leetcode.com/problems/valid-palindrome/) | ★ | 6장. 문자열 조작 | [P1_1.java](src/ch06/P1_1.java)<br>[P1_2.java](src/ch06/P1_2.java)<br>[P1_3.kt](src/ch06/P1_3.kt) |
| 2 | [문자열 뒤집기](https://leetcode.com/problems/reverse-string/) | ★ | 6장. 문자열 조작 | [P2_1.java](src/ch06/P2_1.java)<br>[P2_2.kt](src/ch06/P2_2.kt) |
| 3 | [로그 파일 재정렬](https://leetcode.com/problems/reorder-data-in-log-files/) | ★ | 6장. 문자열 조작 | [P3_1.java](src/ch06/P3_1.java)<br>[P3_2.kt](src/ch06/P3_2.kt) |
| 4 | [가장 흔한 단어](https://leetcode.com/problems/most-common-word/) | ★ | 6장. 문자열 조작 | [P4_1.java](src/ch06/P4_1.java)<br>[P4_2.kt](src/ch06/P4_2.kt) |
| 5 | [그룹 애너그램](https://leetcode.com/problems/group-anagrams/) | ★★ | 6장. 문자열 조작 | [P5_1.java](src/ch06/P5_1.java)<br>[P5_2.kt](src/ch06/P5_2.kt) |
| 6 | [가장 긴 팰린드롬 부분 문자열](https://leetcode.com/problems/longest-palindromic-substring/) | ★★ | 6장. 문자열 조작 | [P6_1.java](src/ch06/P6_1.java)<br>[P6_2.kt](src/ch06/P6_2.kt) |
| 7 | [두 수의 합](https://leetcode.com/problems/two-sum/) | ★ | 7장. 배열 | [P7_1.java](src/ch07/P7_1.java)<br>[P7_2.java](src/ch07/P7_2.java)<br>[P7_3.java](src/ch07/P7_3.java)<br>[P7_4.java](src/ch07/P7_4.java)<br>[P7_5.kt](src/ch07/P7_5.kt) |
| 8 | [빗물 트래핑](https://leetcode.com/problems/trapping-rain-water/) | ★★★ | 7장. 배열 | [P8_1.java](src/ch07/P8_1.java)<br>[P8_2.java](src/ch07/P8_2.java)<br>[P8_3.kt](src/ch07/P8_3.kt) |
| 9 | [세 수의 합](https://leetcode.com/problems/3sum/) | ★★ | 7장. 배열 | [P9_1.java](src/ch07/P9_1.java)<br>[P9_2.java](src/ch07/P9_2.java)<br>[P9_3.kt](src/ch07/P9_3.kt) |
| 10 | [배열 파티션 I](https://leetcode.com/problems/array-partition/) | ★ | 7장. 배열 | [P10_1.java](src/ch07/P10_1.java)<br>[P10_2.java](src/ch07/P10_2.java)<br>[P10_3.kt](src/ch07/P10_3.kt) |
| 11 | [자신을 제외한 배열의 곱](https://leetcode.com/problems/product-of-array-except-self/) | ★★ | 7장. 배열 | [P11_1.java](src/ch07/P11_1.java)<br>[P11_2.kt](src/ch07/P11_2.kt) |
| 12 | [주식을 사고팔기 가장 좋은 시점](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | ★ | 7장. 배열 | [P12_1.java](src/ch07/P12_1.java)<br>[P12_2.java](src/ch07/P12_2.java)<br>[P12_3.kt](src/ch07/P12_3.kt) |
| 13 | [팰린드롬 연결 리스트](https://leetcode.com/problems/palindrome-linked-list/) | ★ | 8장. 연결 리스트 | [P13_1.java](src/ch08/P13_1.java)<br>[P13_2.java](src/ch08/P13_2.java)<br>[P13_3.java](src/ch08/P13_3.java)<br>[P13_4.kt](src/ch08/P13_4.kt) |
| 14 | [두 정렬 리스트의 병합](https://leetcode.com/problems/merge-two-sorted-lists/) | ★ | 8장. 연결 리스트 | [P14_1.java](src/ch08/P14_1.java)<br>[P14_2.kt](src/ch08/P14_2.kt) |
| 15 | [역순 연결 리스트](https://leetcode.com/problems/reverse-linked-list/) | ★ | 8장. 연결 리스트 | [P15_1.java](src/ch08/P15_1.java)<br>[P15_2.java](src/ch08/P15_2.java)<br>[P15_3.kt](src/ch08/P15_3.kt) |
| 16 | [두 수의 덧셈](https://leetcode.com/problems/add-two-numbers/) | ★★ | 8장. 연결 리스트 | [P16_1.java](src/ch08/P16_1.java)<br>[P16_2.java](src/ch08/P16_2.java)<br>[P16_3.kt](src/ch08/P16_3.kt) |
| 17 | [페어의 노드 스왑](https://leetcode.com/problems/swap-nodes-in-pairs/) | ★★ | 8장. 연결 리스트 | [P17_1.java](src/ch08/P17_1.java)<br>[P17_2.java](src/ch08/P17_2.java)<br>[P17_3.java](src/ch08/P17_3.java)<br>[P17_4.kt](src/ch08/P17_4.kt) |
| 18 | [홀짝 연결 리스트](https://leetcode.com/problems/odd-even-linked-list/) | ★★ | 8장. 연결 리스트 | [P18_1.java](src/ch08/P18_1.java)<br>[P18_2.kt](src/ch08/P18_2.kt) |
| 19 | [역순 연결 리스트 II](https://leetcode.com/problems/reverse-linked-list-ii/) | ★★ | 8장. 연결 리스트 | [P19_1.java](src/ch08/P19_1.java)<br>[P19_2.kt](src/ch08/P19_2.kt) |
| 20 | [유효한 괄호](https://leetcode.com/problems/valid-parentheses/) | ★ | 9장. 스택, 큐 | [P20_1.java](src/ch09/P20_1.java)<br>[P20_2.kt](src/ch09/P20_2.kt) |
| 21 | [중복 문자 제거](https://leetcode.com/problems/remove-duplicate-letters/) | ★★★ | 9장. 스택, 큐 | [P21_1.java](src/ch09/P21_1.java)<br>[P21_2.java](src/ch09/P21_2.java)<br>[P21_3.kt](src/ch09/P21_3.kt) |
| 22 | [일일 온도](https://leetcode.com/problems/daily-temperatures/) | ★★ | 9장. 스택, 큐 | [P22_1.java](src/ch09/P22_1.java)<br>[P22_2.kt](src/ch09/P22_2.kt) |
| 23 | [큐를 이용한 스택 구현](https://leetcode.com/problems/implement-stack-using-queues/) | ★ | 9장. 스택, 큐 | [P23_1.java](src/ch09/P23_1.java)<br>[P23_2.kt](src/ch09/P23_2.kt) |
| 24 | [스택을 이용한 큐 구현](https://leetcode.com/problems/implement-queue-using-stacks/) | ★ | 9장. 스택, 큐 | [P24_1.java](src/ch09/P24_1.java)<br>[P24_2.kt](src/ch09/P24_2.kt) |
| 25 | [원형 큐 디자인](https://leetcode.com/problems/design-circular-queue/) | ★★ | 9장. 스택, 큐 | [P25_1.java](src/ch09/P25_1.java)<br>[P25_2.kt](src/ch09/P25_2.kt) |
| 26 | [원형 데크 디자인](https://leetcode.com/problems/design-circular-deque/) | ★★ | 10장. 데크, 우선순위 큐 | [P26_1.java](src/ch10/P26_1.java)<br>[P26_2.kt](src/ch10/P26_2.kt) |
| 27 | [k개 정렬 리스트 병합](https://leetcode.com/problems/merge-k-sorted-lists/) | ★ | 10장. 데크, 우선순위 큐 | [P27_1.java](src/ch10/P27_1.java)<br>[P27_2.kt](src/ch10/P27_2.kt) |
| 28 | [원점에 가장 가까운 k개의 점](https://leetcode.com/problems/k-closest-points-to-origin/) | ★★ | 10장. 데크, 우선순위 큐 | [P28_1.java](src/ch10/P28_1.java)<br>[P28_2.java](src/ch10/P28_2.java)<br>[P28_3.kt](src/ch10/P28_3.kt) |
| 29 | [더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626) | ★ | 10장. 데크, 우선순위 큐 | [P29_1.java](src/ch10/P29_1.java) |
| 30 | [해시맵 디자인](https://leetcode.com/problems/design-hashmap/) | ★ | 11장. 해시 테이블 | [P30_1.java](src/ch11/P30_1.java)<br>[P30_2.kt](src/ch11/P30_2.kt) |
| 31 | [보석과 돌](https://leetcode.com/problems/jewels-and-stones/) | ★ | 11장. 해시 테이블 | [P31_1.java](src/ch11/P31_1.java)<br>[P31_2.java](src/ch11/P31_2.java)<br>[P31_3.kt](src/ch11/P31_3.kt) |
| 32 | [중복 문자 없는 가장 긴 부분 문자열](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | ★★ | 11장. 해시 테이블 | [P32_1.java](src/ch11/P32_1.java)<br>[P32_2.kt](src/ch11/P32_2.kt) |
| 33 | [상위 k 빈도 엘리먼트](https://leetcode.com/problems/top-k-frequent-elements/) | ★★ | 11장. 해시 테이블 | [P33_1.java](src/ch11/P33_1.java)<br>[P33_2.java](src/ch11/P33_2.java)<br>[P33_3.kt](src/ch11/P33_3.kt) |
| 34 | [완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576) | ★ | 11장. 해시 테이블 | [P34_1.java](src/ch11/P34_1.java)<br>[P34_2.kt](src/ch11/P34_2.kt) |
| 35 | [섬의 개수](https://leetcode.com/problems/number-of-islands/) | ★★ | 12장. 그래프 | [P35_1.java](src/ch12/P35_1.java)<br>[P35_2.kt](src/ch12/P35_2.kt) |
| 36 | [전화번호 문자 조합](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | ★★ | 12장. 그래프 | [P36_1.java](src/ch12/P36_1.java)<br>[P36_2.kt](src/ch12/P36_2.kt) |
| 37 | [순열](https://leetcode.com/problems/permutations/) | ★★ | 12장. 그래프 | [P37_1.java](src/ch12/P37_1.java)<br>[P37_2.kt](src/ch12/P37_2.kt) |
| 38 | [조합](https://leetcode.com/problems/combinations/) | ★★ | 12장. 그래프 | [P38_1.java](src/ch12/P38_1.java)<br>[P38_2.kt](src/ch12/P38_2.kt) |
| 39 | [조합의 합](https://leetcode.com/problems/combination-sum/) | ★★ | 12장. 그래프 | [P39_1.java](src/ch12/P39_1.java)<br>[P39_2.kt](src/ch12/P39_2.kt) |
| 40 | [부분집합](https://leetcode.com/problems/subsets/) | ★★ | 12장. 그래프 | [P40_1.java](src/ch12/P40_1.java)<br>[P40_2.kt](src/ch12/P40_2.kt) |
| 41 | [일정 재구성](https://leetcode.com/problems/reconstruct-itinerary/) | ★★ | 12장. 그래프 | [P41_1.java](src/ch12/P41_1.java)<br>[P41_2.java](src/ch12/P41_2.java)<br>[P41_3.kt](src/ch12/P41_3.kt) |
| 42 | [여행 경로](https://school.programmers.co.kr/learn/courses/30/lessons/43164) | ★★ | 12장. 그래프 | [P42_1.java](src/ch12/P42_1.java)<br>[P42_2.kt](src/ch12/P42_2.kt) |
| 43 | [코스 일정](https://leetcode.com/problems/course-schedule/) | ★★ | 12장. 그래프 | [P43_1.java](src/ch12/P43_1.java)<br>[P43_2.java](src/ch12/P43_2.java)<br>[P43_3.kt](src/ch12/P43_3.kt) |
| 44 | [네트워크 딜레이 타임](https://leetcode.com/problems/network-delay-time/) | ★★ | 13장. 최단 경로 문제 | [P44_1.java](src/ch13/P44_1.java)<br>[P44_2.kt](src/ch13/P44_2.kt) |
| 45 | [k 경유지 내 가장 저렴한 항공권](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | ★★ | 13장. 최단 경로 문제 | [P45_1.java](src/ch13/P45_1.java)<br>[P45_2.java](src/ch13/P45_2.java)<br>[P45_3.kt](src/ch13/P45_3.kt) |
| 46 | [게임 맵 최단 거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844) | ★★ | 13장. 최단 경로 문제 | [P46_1.java](src/ch13/P46_1.java) |
| 47 | [이진 트리의 최대 깊이](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | ★ | 14장. 트리 | [P47_1.java](src/ch14/P47_1.java)<br>[P47_2.java](src/ch14/P47_2.java)<br>[P47_3.kt](src/ch14/P47_3.kt) |
| 48 | [이진 트리의 직경](https://leetcode.com/problems/diameter-of-binary-tree/) | ★ | 14장. 트리 | [P48_1.java](src/ch14/P48_1.java)<br>[P48_2.kt](src/ch14/P48_2.kt) |
| 49 | [가장 긴 동일 값의 경로](https://leetcode.com/problems/longest-univalue-path/) | ★ | 14장. 트리 | [P49_1.java](src/ch14/P49_1.java)<br>[P49_2.kt](src/ch14/P49_2.kt) |
| 50 | [이진 트리 반전](https://leetcode.com/problems/invert-binary-tree/) | ★ | 14장. 트리 | [P50_1.java](src/ch14/P50_1.java)<br>[P50_2.java](src/ch14/P50_2.java)<br>[P50_3.java](src/ch14/P50_3.java)<br>[P50_4.java](src/ch14/P50_4.java)<br>[P50_5.java](src/ch14/P50_5.java)<br>[P50_6.kt](src/ch14/P50_6.kt) |
| 51 | [두 이진 트리 병합](https://leetcode.com/problems/merge-two-binary-trees/) | ★ | 14장. 트리 | [P51_1.java](src/ch14/P51_1.java)<br>[P51_2.kt](src/ch14/P51_2.kt) |
| 52 | [이진 트리 직렬화 & 역직렬화](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | ★★★ | 14장. 트리 | [P52_1.java](src/ch14/P52_1.java)<br>[P52_2.kt](src/ch14/P52_2.kt) |
| 53 | [균형 이진 트리](https://leetcode.com/problems/balanced-binary-tree/) | ★ | 14장. 트리 | [P53_1.java](src/ch14/P53_1.java)<br>[P53_2.kt](src/ch14/P53_2.kt) |
| 54 | [최소 높이 트리](https://leetcode.com/problems/minimum-height-trees/) | ★★ | 14장. 트리 | [P54_1.java](src/ch14/P54_1.java)<br>[P54_2.kt](src/ch14/P54_2.kt) |
| 55 | [정렬된 배열의 이진 탐색 트리 변환](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) | ★ | 14장. 트리 | [P55_1.java](src/ch14/P55_1.java)<br>[P55_2.kt](src/ch14/P55_2.kt) |
| 56 | [이진 탐색 트리(BST)를 더 큰 수 합계 트리로](https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/) | ★★ | 14장. 트리 | [P56_1.java](src/ch14/P56_1.java)<br>[P56_2.kt](src/ch14/P56_2.kt) |
| 57 | [이진 탐색 트리(BST) 합의 범위](https://leetcode.com/problems/range-sum-of-bst/) | ★ | 14장. 트리 | [P57_1.java](src/ch14/P57_1.java)<br>[P57_2.java](src/ch14/P57_2.java)<br>[P57_3.java](src/ch14/P57_3.java)<br>[P57_4.java](src/ch14/P57_4.java)<br>[P57_5.kt](src/ch14/P57_5.kt) |
| 58 | [이진 탐색 트리(BST) 노드 간 최솟값](https://leetcode.com/problems/minimum-distance-between-bst-nodes/) | ★ | 14장. 트리 | [P58_1.java](src/ch14/P58_1.java)<br>[P58_2.java](src/ch14/P58_2.java)<br>[P58_3.kt](src/ch14/P58_3.kt) |
| 59 | [전위, 중위 순회 결과로 이진 트리 구축](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | ★★ | 14장. 트리 | [P59_1.java](src/ch14/P59_1.java)<br>[P59_2.java](src/ch14/P59_2.java)<br>[P59_3.kt](src/ch14/P59_3.kt) |
| 60 | [배열의 k번째 큰 엘리먼트](https://leetcode.com/problems/kth-largest-element-in-an-array/) | ★★ | 15장. 힙 | [P60_1.java](src/ch15/P60_1.java)<br>[P60_2.java](src/ch15/P60_2.java)<br>[P60_3.kt](src/ch15/P60_3.kt) |
| 61 | [이중 우선순위 큐](https://school.programmers.co.kr/learn/courses/30/lessons/42628) | ★★★ | 15장. 힙 | [P61_1.java](src/ch15/P61_1.java)<br>[P61_2.java (예정)](src/ch15/P61_2.java)<br>[P61_3.kt](src/ch15/P61_3.kt) |
| 62 | [트라이 구현](https://leetcode.com/problems/implement-trie-prefix-tree/) | ★★ | 16장. 트라이 | [P62_1.java](src/ch16/P62_1.java)<br>[P62_2.kt](src/ch16/P62_2.kt) |
| 63 | [팰린드롬 페어](https://leetcode.com/problems/palindrome-pairs/) | ★★★ | 16장. 트라이 | [P63_1.java](src/ch16/P63_1.java)<br>[P63_2.java](src/ch16/P63_2.java)<br>[P63_3.kt](src/ch16/P63_3.kt) |
| 64 | [리스트 정렬](https://leetcode.com/problems/sort-list/) | ★★ | 17장. 정렬 | [P64_1.java](src/ch17/P64_1.java)<br>[P64_2.java](src/ch17/P64_2.java)<br>[P64_3.kt](src/ch17/P64_3.kt) |
| 65 | [구간 병합](https://leetcode.com/problems/merge-intervals/) | ★★ | 17장. 정렬 | [P65_1.java](src/ch17/P65_1.java)<br>[P65_2.kt](src/ch17/P65_2.kt) |
| 66 | [삽입 정렬 리스트](https://leetcode.com/problems/insertion-sort-list/) | ★★ | 17장. 정렬 | [P66_1.java](src/ch17/P66_1.java)<br>[P66_2.java](src/ch17/P66_2.java)<br>[P66_3.kt](src/ch17/P66_3.kt) |
| 67 | [가장 큰 수](https://leetcode.com/problems/largest-number/) | ★★ | 17장. 정렬 | [P67_1.java](src/ch17/P67_1.java)<br>[P67_2.kt](src/ch17/P67_2.kt) |
| 68 | [유효한 애너그램](https://leetcode.com/problems/valid-anagram/) | ★ | 17장. 정렬 | [P68_1.java](src/ch17/P68_1.java)<br>[P68_2.kt](src/ch17/P68_2.kt)<br>[P68_3.kt](src/ch17/P68_3.kt) |
| 69 | [색 정렬](https://leetcode.com/problems/sort-colors/) | ★★ | 17장. 정렬 | [P69_1.java](src/ch17/P69_1.java)<br>[P69_2.kt](src/ch17/P69_2.kt) |
| 70 | [이진 검색](https://leetcode.com/problems/binary-search/) | ★ | 18장. 이진 검색 | [P70_1.java](src/ch18/P70_1.java)<br>[P70_2.java](src/ch18/P70_2.java)<br>[P70_3.java](src/ch18/P70_3.java)<br>[P70_4.java](src/ch18/P70_4.java)<br>[P70_5.kt](src/ch18/P70_5.kt) |
| 71 | [회전 정렬된 배열 검색](https://leetcode.com/problems/search-in-rotated-sorted-array/) | ★★ | 18장. 이진 검색 | [P71_1.java](src/ch18/P71_1.java)<br>[P71_2.kt](src/ch18/P71_2.kt) |
| 72 | [두 배열의 교집합](https://leetcode.com/problems/intersection-of-two-arrays/) | ★ | 18장. 이진 검색 | [P72_1.java](src/ch18/P72_1.java)<br>[P72_2.java](src/ch18/P72_2.java)<br>[P72_3.java](src/ch18/P72_3.java)<br>[P72_4.kt](src/ch18/P72_4.kt) |
| 73 | [두 수의 합 II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | ★ | 18장. 이진 검색 | [P73_1.java](src/ch18/P73_1.java)<br>[P73_2.java](src/ch18/P73_2.java)<br>[P73_3.java](src/ch18/P73_3.java)<br>[P73_4.kt](src/ch18/P73_4.kt) |
| 74 | [2D 행렬 검색 II](https://leetcode.com/problems/search-a-2d-matrix-ii/) | ★★ | 18장. 이진 검색 | [P74_1.java](src/ch18/P74_1.java)<br>[P74_2.kt](src/ch18/P74_2.kt) |
| 75 | [입국심사](https://school.programmers.co.kr/learn/courses/30/lessons/43238) | ★★★ | 18장. 이진 검색 | [P75_1.java](src/ch18/P75_1.java)<br>[P75_2.kt](src/ch18/P75_2.kt) |
| 76 | [싱글 넘버](https://leetcode.com/problems/single-number/) | ★ | 19장. 비트 조작 | [P76_1.java](src/ch19/P76_1.java)<br>[P76_2.kt](src/ch19/P76_2.kt) |
| 77 | [해밍 거리](https://leetcode.com/problems/hamming-distance/) | ★ | 19장. 비트 조작 | [P77_1.java](src/ch19/P77_1.java)<br>[P77_2.kt](src/ch19/P77_2.kt) |
| 78 | [두 정수의 합](https://leetcode.com/problems/sum-of-two-integers/) | ★★★ | 19장. 비트 조작 | [P78_1.java](src/ch19/P78_1.java)<br>[P78_2.java](src/ch19/P78_2.java)<br>[P78_3.kt](src/ch19/P78_3.kt) |
| 79 | [UTF-8 검증](https://leetcode.com/problems/utf-8-validation/) | ★★ | 19장. 비트 조작 | [P79_1.java](src/ch19/P79_1.java)<br>[P79_2.kt](src/ch19/P79_2.kt) |
| 80 | [1비트의 개수](https://leetcode.com/problems/number-of-1-bits/) | ★ | 19장. 비트 조작 | [P80_1.java](src/ch19/P80_1.java)<br>[P80_2.java](src/ch19/P80_2.java)<br>[P80_3.kt](src/ch19/P80_3.kt) |
| 81 | [최대 슬라이딩 윈도우](https://leetcode.com/problems/sliding-window-maximum/) | ★★★ | 20장. 슬라이딩 윈도우 | [P81_1.java](src/ch20/P81_1.java)<br>[P81_2.java](src/ch20/P81_2.java)<br>[P81_3.java](src/ch20/P81_3.java)<br>[P81_4.kt](src/ch20/P81_4.kt) |
| 82 | [부분 문자열이 포함된 최소 윈도우](https://leetcode.com/problems/minimum-window-substring/) | ★★★ | 20장. 슬라이딩 윈도우 | [P82_1.java](src/ch20/P82_1.java)<br>[P82_2.java](src/ch20/P82_2.java)<br>[P82_3.kt](src/ch20/P82_3.kt) |
| 83 | [가장 긴 반복 문자 대체](https://leetcode.com/problems/longest-repeating-character-replacement/) | ★★ | 20장. 슬라이딩 윈도우 | [P83_1.java](src/ch20/P83_1.java)<br>[P83_2.kt](src/ch20/P83_2.kt) |
| 84 | [주식을 사고팔기 가장 좋은 시점 II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | ★ | 21장. 그리디 알고리즘 | [P84_1.java](src/ch21/P84_1.java)<br>[P84_2.kt](src/ch21/P84_2.kt) |
| 85 | [키에 따른 대기열 재구성](https://leetcode.com/problems/queue-reconstruction-by-height/) | ★★ | 21장. 그리디 알고리즘 | [P85_1.java](src/ch21/P85_1.java)<br>[P85_2.kt](src/ch21/P85_2.kt) |
| 86 | [태스크 스케줄러](https://leetcode.com/problems/task-scheduler/) | ★★ | 21장. 그리디 알고리즘 | [P86_1.java](src/ch21/P86_1.java)<br>[P86_2.kt](src/ch21/P86_2.kt) |
| 87 | [주유소](https://leetcode.com/problems/gas-station/) | ★★ | 21장. 그리디 알고리즘 | [P87_1.java](src/ch21/P87_1.java)<br>[P87_2.java](src/ch21/P87_2.java)<br>[P87_3.kt](src/ch21/P87_3.kt) |
| 88 | [쿠키 부여](https://leetcode.com/problems/assign-cookies/) | ★ | 21장. 그리디 알고리즘 | [P88_1.java](src/ch21/P88_1.java)<br>[P88_2.kt](src/ch21/P88_2.kt) |
| 89 | [과반수 엘리먼트](https://leetcode.com/problems/majority-element/) | ★ | 22장. 분할 정복 | [P89_1.java](src/ch22/P89_1.java)<br>[P89_2.java](src/ch22/P89_2.java)<br>[P89_3.java](src/ch22/P89_3.java)<br>[P89_4.kt](src/ch22/P89_4.kt) |
| 90 | [괄호를 삽입하는 여러가지 방법](https://leetcode.com/problems/different-ways-to-add-parentheses/) | ★★ | 22장. 분할 정복 | [P90_1.java](src/ch22/P90_1.java)<br>[P90_2.java](src/ch22/P90_2.java)<br>[P90_3.kt](src/ch22/P90_3.kt) |
| 91 | [피보나치 수](https://leetcode.com/problems/fibonacci-number/) | ★ | 23장. 다이나믹 프로그래밍 | [P91_1.java](src/ch23/P91_1.java)<br>[P91_2.java](src/ch23/P91_2.java)<br>[P91_3.java](src/ch23/P91_3.java)<br>[P91_4.java](src/ch23/P91_4.java)<br>[P91_5.kt](src/ch23/P91_5.kt) |
| 92 | [최대 서브 배열](https://leetcode.com/problems/maximum-subarray/) | ★ | 23장. 다이나믹 프로그래밍 | [P92_1.java](src/ch23/P92_1.java)<br>[P92_2.java](src/ch23/P92_2.java)<br>[P92_3.java](src/ch23/P92_3.java)<br>[P92_4.kt](src/ch23/P92_4.kt) |
| 93 | [계단 오르기](https://leetcode.com/problems/climbing-stairs/) | ★ | 23장. 다이나믹 프로그래밍 | [P93_1.java](src/ch23/P93_1.java)<br>[P93_2.java](src/ch23/P93_2.java)<br>[P93_3.kt](src/ch23/P93_3.kt) |
| 94 | [집 도둑](https://leetcode.com/problems/house-robber/) | ★ | 23장. 다이나믹 프로그래밍 | [P94_1.java](src/ch23/P94_1.java)<br>[P94_2.java](src/ch23/P94_2.java)<br>[P94_3.kt](src/ch23/P94_3.kt) |
| 95 | [도둑질](https://school.programmers.co.kr/learn/courses/30/lessons/42897) | ★★★ | 23장. 다이나믹 프로그래밍 | [P95_1.java](src/ch23/P95_1.java) |
| 96(문제 1) | [신고 결과 받기](https://school.programmers.co.kr/learn/courses/30/lessons/92334) | ★ | 부록. 2022년 카카오 공채 만점 가이드 | [P96_1.java](src/ch24/P96_1.java)<br>[P96_2.kt](src/ch24/P96_2.kt) |
| 97(문제 2) | [k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335) | ★★ | 부록. 2022년 카카오 공채 만점 가이드 | [P97_1.java](src/ch24/P97_1.java)<br>[P97_2.java](src/ch24/P97_2.java)<br>[P97_3.java](src/ch24/P97_3.java)<br>[P97_4.java](src/ch24/P97_4.java)<br>[P97_5.kt](src/ch24/P97_5.kt) |
| 98(문제 3) | [주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341) | ★★ | 부록. 2022년 카카오 공채 만점 가이드 | [P98_1.java](src/ch24/P98_1.java)<br>[P98_2.kt](src/ch24/P98_2.kt) |
| 99(문제 4) | [양궁대회](https://school.programmers.co.kr/learn/courses/30/lessons/92342) | ★★ | 부록. 2022년 카카오 공채 만점 가이드 | [P99_1.java](src/ch24/P99_1.java)<br>[P99_2.kt](src/ch24/P99_2.kt) |
| 100(문제 5) | [양과 늑대](https://school.programmers.co.kr/learn/courses/30/lessons/92343) | ★★★ | 부록. 2022년 카카오 공채 만점 가이드 | [P100_1.java](src/ch24/P100_1.java)<br>[P100_2.kt](src/ch24/P100_2.kt) |
| 101(문제 6) | [파괴되지 않은 건물](https://school.programmers.co.kr/learn/courses/30/lessons/92344) | ★★★ | 부록. 2022년 카카오 공채 만점 가이드 | [P101_2.java](src/ch24/P101_2.java)<br>[P101_3.kt](src/ch24/P101_3.kt) |
| 102(문제 7) | [사라지는 발판](https://school.programmers.co.kr/learn/courses/30/lessons/92345) | ★★★ | 부록. 2022년 카카오 공채 만점 가이드 | [P102_1.java](src/ch24/P102_1.java)<br>[P102_2.kt](src/ch24/P102_2.kt) |

## 기타 코드
- 2장
  - [제네릭 예제](src/ch02/GenericExample.java)
  - [람다 표현식 예졔](src/ch02/LambdaExpressionExample.java)
  - [람다 표현식 정렬 예제](src/ch02/LambdaExpressionSortExample.java)
  - [스트림 API 예제](src/ch02/SteamAPIExample.java)
- 3장
  - [자바 조건문 예제](src/ch03/JavaConditionExample.java)
  - [코틀린 조건문 예제](src/ch03/KotlinConditionExample.kt)
  - [코틀린 함수형 예제](src/ch03/KotlinFunctionalExample.kt)
  - [코틀린 컴파일 예제](src/ch03/Array.kt)
- 4장
  - [자바 참조 자료형 예제](src/ch04/JavaDataType.java)
  - [자바 원시 자료형과 참조 자료형의 속도 비교](src/ch04/JavaPerf.java)
  - [맵 예제](src/ch04/MapExample.java)
  - [코틀린 자료형 속도 측정](src/ch04/KotlinPerf.kt)
  - [코틀린 자료형의 제공 기능](src/ch04/KotlinDataType.kt)
  - [자바 컬렉션 프레임워크 속도 측정 1](src/ch04/CollectionsFrameworkPerf1.java)
  - [자바 컬렉션 프레임워크 속도 측정 2](src/ch04/CollectionsFrameworkPerf2.java)
- 5장
  - [빅오 예제](src/ch05/BigOExample.java)
  - [자바 컬렉션 프레임워크 속도 측정](src/ch05/CollectionsFrameworkPerf.java)
- 6장
  - [값에 의한 호출 예제](src/ch06/CallByValueExample.java)
- 7장
  - [엘비스 연산자 예제](src/ch07/ElvisExample.kt)
- 9장
  - [스택 구현 예제](src/ch09/StackExample.java)
  - [오토박싱 속도 측정](src/ch09/AutoBoxingPerf.java)
- 10장
  - [자바 중첩 클래스 예제](src/ch10/JavaNestedClassExample.java)
  - [코틀린 중첩 클래스 예제](src/ch10/KotlinNestedClassExample.kt)
  - [자바 클래스 생성자 예제](src/ch10/JavaCarExample.java)
  - [코틀린 클래스 생성자 예제](src/ch10/KotlinCarExample.kt)
- 11장
  - [생일 문제 예제](src/ch11/BirthdayProblemExample.java)
- 12장
  - [그래프 순회 예제](src/ch12/GraphTraversalsExample.java)
- 14장
  - [트리 순회 예제](src/ch14/TreeTraversalsExample.java)
- 15장
  - [이진 힙 구현 예제](src/ch15/BinaryHeapExample.java)
- 17장
  - [버블 정렬 예제](src/ch17/BubbleSortExample.java)
  - [삽입 정렬 예제](src/ch17/InsertionSortExample.java)
  - [퀵 정렬 예제](src/ch17/QuickSortExample.java)
- 21장
  - [분할 가능 배낭 문제 예제](src/ch21/FractionalKnapsackExample.java)
- 23장
  - [피보나치 수열 상향식 예제](src/ch23/FibonacciBottomUpExample.java)
  - [피보나치 수열 하향식 예제](src/ch23/FibonacciTopDownExample.java)
  - [0-1 배낭 문제 예제](src/ch23/ZeroOneKnapsackExample.java)
