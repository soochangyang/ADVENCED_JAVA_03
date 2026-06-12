# Java Stream API Master Guide

---

## 🇰🇷 [Korean] Part 1: 스트림의 본질과 다양한 생성 방법

### 1. 스트림의 본질 (The Essence of Streams)
스트림은 데이터를 저장하는 자료구조(Data Structure)가 아닙니다. 데이터를 목적지까지 운반하며 가공하는 **'컨베이어 벨트(Pipeline)'**입니다.
* **라이프사이클 3단계:** `생성 (Source)` ➔ `중간 연산 (Intermediate)` ➔ `최종 연산 (Terminal)`

### 2. 스트림의 3대 원칙
1. **원본 불변 (Read-only):** 스트림 연산은 원본 컬렉션의 데이터를 절대 변경하지 않음.
2. **일회용 (One-time use):** 최종 연산이 끝나면 스트림은 닫히며 재사용할 수 없음.
3. **지연 연산 (Lazy Evaluation):** 최종 연산이 호출되기 전까지, 중간 연산은 실행되지 않고 대기.

### 3. 주요 생성 방법 (Creation Methods)

**① 컬렉션 및 배열 (Collections & Arrays)**
가장 기본적인 생성 방식.
```java
List<String> list = List.of("A", "B", "C");
Stream<String> listStream = list.stream();

String[] arr = {"A", "B", "C"};
Stream<String> arrayStream = Arrays.stream(arr);
```

**② 원시 타입 스트림 (Primitive Streams)**

불필요한 오토박싱(Auto-boxing) 오버헤드를 막기 위해, 숫자 연산 시 반드시 사용해야 하는 성능 최적화 기법.
```java
IntStream intStream = IntStream.rangeClosed(1, 100); // 1~100까지의 숫자 스트림
```

**③ 무한 스트림 (Infinite Streams)**
크기가 무한하므로 메모리 누수를 막기 위해 반드시 limit()으로 개수를 제한해야 함.
```java
// iterate: 이전 값을 기반으로 다음 값 생성
Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2).limit(5); // 0, 2, 4, 6, 8

// generate: 이전 값과 무관하게 새로운 값 공급
Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
```

## 🇰🇷 [Korean] Part 2: 중간 연산의 마법과 파이프라인 설계

### 1. 중간 연산의 핵심 특징
* **지연 연산 (Lazy Evaluation):** 최종 연산이 호출되기 전까지는 실제로 실행되지 않고 작업 지시서만 쌓음.
* **체이닝 (Chaining):** 연산 결과로 항상 새로운 `Stream`을 반환하므로, 여러 연산을 파이프라인처럼 계속 연결할 수 있음.

### 2. 필터링과 자르기 (Filtering & Slicing)
불필요한 데이터를 걷어내는 가장 기본적인 가공 작업임.
* `filter(Predicate)`: 조건이 `true`인 요소만 통과시킴.
* `distinct()`: 중복된 요소를 제거함 (내부적으로 `equals()`, `hashCode()` 사용).
* `limit(n)`: 스트림의 크기를 앞에서부터 `n`개로 제한함.
* `skip(n)`: 스트림의 처음 `n`개 요소를 버리고 그 이후부터 통과시킴.

```java
List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 6);

List<Integer> result = numbers.stream()
        .distinct()          // 중복 제거: 1, 2, 3, 4, 5, 6
        .filter(n -> n % 2 == 0) // 짝수만: 2, 4, 6
        .skip(1)             // 첫 번째 건너뜀: 4, 6
        .limit(1)            // 1개만 제한: 4
        .collect(Collectors.toList());
```
### 3. 변환 (Mapping)
데이터의 형태를 원하는 모양으로 가공함.
* map(Function): 요소를 1:1로 변환함 (예: 객체에서 특정 필드만 추출).
* flatMap(Function): 중첩된 구조(예: 리스트 안의 리스트)를 한 단계 평탄화(Flatten)하여 단일 스트림으로 만듦 (1:N 매핑).
```Java
List<String> words = List.of("Hello", "Java");

// map: 단어의 길이로 변환
List<Integer> lengths = words.stream()
    .map(String::length) // [5, 4]
    .collect(Collectors.toList());

// flatMap: 단어를 쪼개서 개별 알파벳 스트림으로 평탄화
List<String> letters = words.stream()
    .map(w -> w.split("")) // Stream<String[]>
    .flatMap(Arrays::stream); // Stream<String> 으로 평탄화
```

### 4. 정렬과 확인 (Sorting & Peeking)
* sorted(): 요소를 정렬함. (기본은 오름차순, 괄호 안에 **`Comparator`**를 넣어 커스텀 정렬 가능).
* peek(Consumer): 스트림의 요소를 소모하지 않고 중간에 꺼내봄. 주로 데이터의 흐름을 파악하기 위한 디버깅 용도로만 사용함.
```Java
List<String> names = List.of("Banana", "Apple", "Cherry");

List<String> sortedNames = names.stream()
    .peek(n -> System.out.println("원본: " + n))
    .sorted(Comparator.reverseOrder()) // 역순 정렬
    .peek(n -> System.out.println("정렬됨: " + n))
    .collect(Collectors.toList());
```


## 🇰🇷 [Korean] Part 3: 최종 연산과 복잡한 데이터 그룹화 (고급)
### 1. 최종 연산 (Terminal Operations) 개요
스트림 파이프라인의 끝을 맺는 연산임. 이 연산이 호출되어야 비로소 중간 연산들이 실행(Lazy Evaluation)됨.

* **소비:** `forEach(Consumer)` - 요소를 순회하며 부수 효과(출력 등)를 발생시킴.
* **검색:** `findFirst()`, `findAny()` - 조건에 맞는 요소를 찾아 `Optional`로 반환함.
* **매칭:** `anyMatch()`, `allMatch()`, `noneMatch()` - 조건 만족 여부를 `boolean`으로 반환함 (조건을 만족하면 끝까지 검사하지 않고 즉시 종료하는 Short-circuiting 지원).

### 2. 단일 값으로 축소 (Reduction)
여러 개의 데이터를 뭉쳐서 단 하나의 결과물로 만듦.
* `reduce(초기값, 누적기)`: 원소를 하나씩 소모하며 누적 계산을 수행함.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

// 1부터 5까지의 총합 계산
int sum = numbers.stream()
        .reduce(0, (total, n) -> total + n); // 또는 Integer::sum
```
### 3. 데이터 포장과 그룹화 (Collectors)
단순한 리스트 변환을 넘어, SQL의 GROUP BY처럼 복잡한 데이터 묶음과 통계를 가능하게 함.

**① 기본 분할과 그룹화**
* partitioningBy(Predicate): 조건을 기준으로 참/거짓(true/false) 두 그룹의 Map으로 나눔.
* groupingBy(Function): 특정 기준(Key)에 따라 여러 그룹의 Map으로 나눔.

```Java
// 1. 80점 이상 합격자와 불합격자로 분할 (true/false)
Map<Boolean, List<Student>> passOrFail = students.stream()
.collect(Collectors.partitioningBy(s -> s.getScore() >= 80));

// 2. 학년(Grade)을 기준으로 학생들을 그룹화
Map<Integer, List<Student>> byGrade = students.stream()
.collect(Collectors.groupingBy(Student::getGrade));
```
**② 고급 다중 그룹화 (Downstream Collectors)**
groupingBy 내부의 두 번째 인자로 또 다른 Collector를 전달하여, 묶여진 그룹 내부에서 2차 가공(통계, 매핑 등)을 수행함.

```Java
// 학년별 그룹화 후 -> 그룹 내 학생들의 "평균 점수" 계산
Map<Integer, Double> avgScoreByGrade = students.stream()
.collect(Collectors.groupingBy(
Student::getGrade,
Collectors.averagingInt(Student::getScore) // 2차 가공
));

// 학년별 그룹화 후 -> 그룹 내 학생들의 "이름만" 쉼표로 연결
Map<Integer, String> namesByGrade = students.stream()
.collect(Collectors.groupingBy(
Student::getGrade,
Collectors.mapping(Student::getName, Collectors.joining(", ")) // 2차 가공
));
```
## 🇰🇷 [Korean] Part 4: 스트림의 한계, 예외 처리, 그리고 병렬 최적화 (심화)
### 1. 스트림의 한계와 단점 (Limitations)
무조건 스트림이 정답은 아님. 상황에 따라 전통적인 방식이 더 유리할 수 있음.
* **디버깅의 어려움:** 내부적으로 익명 객체와 지연 연산을 사용하기 때문에 에러 발생 시 스택 트레이스(Stack Trace)가 매우 복잡하게 출력되어 추적이 어려움.
* **단순 반복문의 성능 저하:** 단순히 원시 타입 배열을 순회하는 가벼운 작업에서는 스트림 생성 및 호출 오버헤드 때문에 일반 `for`문이 더 빠름.
* **상태 변경 불가:** 람다식 외부의 지역 변수를 변경할 수 없으므로, 외부 상태를 지속적으로 업데이트해야 하는 로직에는 부적합함.

### 2. 람다 내부의 예외 처리 (Exception Handling)
자바의 `Stream` API는 내부 람다식에서 발생하는 **Checked Exception**을 밖으로 던질(throws) 수 없도록 설계됨.

* **해결책:** 반드시 람다 내부에서 `try-catch` 블록으로 잡은 뒤, `RuntimeException`(Unchecked)으로 감싸서 던져야 함.

```java
List<String> filePaths = List.of("file1.txt", "file2.txt");

// Checked Exception(IOException) 처리를 위한 try-catch 강제
List<String> lines = filePaths.stream()
        .map(path -> {
            try {
                return Files.readString(Paths.get(path));
            } catch (IOException e) {
                throw new RuntimeException("파일 읽기 실패: " + path, e);
            }
        })
        .collect(Collectors.toList());
```

### 3. 병렬 스트림 (Parallel Streams) 최적화
단 한 단어(parallel())로 멀티코어를 활용한 병렬 처리를 구현할 수 있는 강력한 무기임. 하지만 잘못 쓰면 오히려 성능이 심각하게 저하됨.
* 사용 방법: .stream() 대신 .parallelStream()을 사용하거나 파이프라인 중간에 .parallel()을 추가함.
* 적합한 경우: 데이터의 개수가 수백만 개 이상으로 매우 많고, 각 요소를 독립적으로 처리할 수 있을 때 (예: CPU 집약적인 복잡한 수학 계산).
* 부적합한 경우 (사용 금지):
   1. 데이터가 적을 때 (스레드 생성 비용이 더 큼).
   2. 순서가 중요한 연산(limit, findFirst)을 사용할 때.
   3. 컬렉션이 LinkedList일 때 (데이터를 반으로 쪼개기 어려워 병렬화 효율이 극악임. ArrayList 권장).
   4. 외부 API 호출이나 DB 조회 등 I/O 작업이 포함될 때 (스레드 풀이 고갈되어 시스템 전체가 마비될 수 있음).
```Java
List<Integer> largeNumbers = // ... 수백만 개의 데이터

// 병렬 스트림을 이용한 고속 합계 계산
long sum = largeNumbers.parallelStream()
    .filter(n -> n % 2 == 0)
    .mapToLong(n -> heavyComputation(n)) // 무거운 계산 메서드 가정
    .sum();
```


##  Part 1: The Essence of Streams and Various Creation Methods
### 1. The Essence of Streams
   A Stream is not a data structure that stores elements. It is a 'conveyor belt (Pipeline)' that transports and processes data.

* **3-Stage Lifecycle:** `Source (Creation)` ➔ `Intermediate Operations` ➔ `Terminal Operation`

### 2. Three Absolute Rules
   1. **Read-only**: Stream operations never modify the original data source.
   2. **One-time use**: Once a terminal operation is invoked, the stream is consumed and cannot be reused.
   3. **Lazy Evaluation**: Intermediate operations are not executed until the terminal operation is called.

### 3. Key Creation Methods
   **① Collections & Arrays**
   The most standard way to create streams.

```Java
List<String> list = List.of("A", "B", "C");
Stream<String> listStream = list.stream();

String[] arr = {"A", "B", "C"};
Stream<String> arrayStream = Arrays.stream(arr);
```
**② Primitive Streams (Performance Optimization)**
Crucial for performance optimization. Used to prevent auto-boxing/unboxing overhead when dealing with numbers.
```Java
IntStream intStream = IntStream.rangeClosed(1, 100); // Stream of numbers from 1 to 100
```

**③ Infinite Streams**
Since they are infinite, they must always be truncated using limit() to prevent memory overflow.
```Java
// iterate: Generates the next value based on the previous one
Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2).limit(5); // 0, 2, 4, 6, 8

// generate: Generates new values independently of the previous one
Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
```

## Part 2: The Magic of Intermediate Operations and Pipeline Design
### 1. Core Features of Intermediate Operations
* **Lazy Evaluation**: Operations are not executed immediately; they wait until a terminal operation is invoked.
* **Chaining**: Always returns a new Stream, allowing multiple operations to be connected like a pipeline.

### 2. Filtering & Slicing
   Essential steps to remove unnecessary data.

* filter(Predicate): Passes only elements that match the given condition.
* distinct(): Removes duplicate elements (uses equals() and hashCode()).
* limit(n): Truncates the stream to a maximum of n elements.
* skip(n): Discards the first n elements of the stream.
```Java
List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 6);

List<Integer> result = numbers.stream()
    .distinct()              // Remove duplicates: 1, 2, 3, 4, 5, 6
    .filter(n -> n % 2 == 0) // Keep evens: 2, 4, 6
    .skip(1)                 // Skip first: 4, 6
    .limit(1)                // Limit to 1: 4
    .collect(Collectors.toList());
```

### 3. Mapping (Transformation)
   Transforms data into a desired shape.
* map(Function): Transforms elements 1:1 (e.g., extracting a specific field from an object).
* flatMap(Function): Flattens nested structures (e.g., lists of lists) into a single-level stream (1:N mapping).
```Java
List<String> words = List.of("Hello", "Java");

// map: Transform to string lengths
List<Integer> lengths = words.stream()
    .map(String::length) // [5, 4]
    .collect(Collectors.toList());

// flatMap: Split words and flatten into a single stream of characters
List<String> letters = words.stream()
    .map(w -> w.split(""))     // Returns Stream<String[]>
    .flatMap(Arrays::stream)       // Flattens to Stream<String>
    .collect(Collectors.toList()); // [H, e, l, l, o, J, a, v, a]
```

### 4. Sorting & Peeking
* **sorted()**: Sorts elements (defaults to ascending order; a **Comparator** can be passed for custom sorting).
* **peek(Consumer)**: Observes elements without consuming the stream. Used strictly for debugging purposes.
```Java
List<String> names = List.of("Banana", "Apple", "Cherry");

List<String> sortedNames = names.stream()
    .peek(n -> System.out.println("Original: " + n))
    .sorted(Comparator.reverseOrder()) // Descending order
    .peek(n -> System.out.println("Sorted: " + n))
    .collect(Collectors.toList());
```

## Part 3: Terminal Operations and Complex Data Grouping
### 1. Overview of Terminal Operations
Operations that end the stream pipeline. Intermediate operations are only executed **(Lazy Evaluation)** when a **terminal operation is invoked**.
* **Consuming**: `forEach(Consumer)` - Iterates through elements to produce side-effects (e.g., printing).
* **Searching**: `findFirst()`, `findAny()` - Finds elements matching a condition and returns an Optional.
* **Matching**: `anyMatch()`, `allMatch()`, `noneMatch()` - Returns a boolean based on conditions (Supports Short-circuiting: stops immediately when the condition is met).

### 2. Reduction
Combines multiple elements into a single result.
* **reduce(identity, accumulator)**: Consumes elements one by one to perform an accumulative calculation.

```Java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

// Calculate the sum from 1 to 5
int sum = numbers.stream()
    .reduce(0, (total, n) -> total + n); // or Integer::sum
```
### 3. Collecting and Grouping Data (Collectors)
Goes beyond simple list conversion, enabling complex data grouping and statistics similar to SQL's GROUP BY.

**① Basic Partitioning & Grouping**
* partitioningBy(Predicate): Divides data into two groups (true/false) in a Map based on a condition.
* groupingBy(Function): Groups data into a Map based on a specific criterion (Key).

```Java
// 1. Partition into Pass/Fail (>= 80 points)
Map<Boolean, List<Student>> passOrFail = students.stream()
    .collect(Collectors.partitioningBy(s -> s.getScore() >= 80));

// 2. Group students by their Grade
Map<Integer, List<Student>> byGrade = students.stream()
    .collect(Collectors.groupingBy(Student::getGrade));
```
**② Advanced Multi-level Grouping (Downstream Collectors)**
Passes another Collector as the second argument to groupingBy to perform secondary processing (statistics, mapping, etc.) within the formed groups.
```Java
// Group by Grade -> Calculate "Average Score" within the group
Map<Integer, Double> avgScoreByGrade = students.stream()
    .collect(Collectors.groupingBy(
        Student::getGrade,
        Collectors.averagingInt(Student::getScore) // Secondary processing
    ));

// Group by Grade -> Extract "Names" and join them with a comma
Map<Integer, String> namesByGrade = students.stream()
    .collect(Collectors.groupingBy(
        Student::getGrade,
        Collectors.mapping(Student::getName, Collectors.joining(", ")) // Secondary processing
    ));
```

## Part 4: Limitations of Streams, Exception Handling, and Parallel Optimization
### 1. Limitations & Drawbacks
Streams are not always the silver bullet. Traditional methods can sometimes be more advantageous.
* Debugging Difficulty: Due to lazy evaluation and anonymous internal objects, stack traces become extremely complex, making it hard to track down the exact source of an error.
* Performance Overhead in Simple Loops: For simple iterations over primitive arrays, traditional for-loops are often faster because streams introduce object creation and invocation overhead.
* Immutability of External State: Lambdas cannot modify local variables defined outside their scope, making streams unsuitable for logic that heavily relies on mutating external states.

### 2. Exception Handling inside Lambdas
The Java Stream API is designed so that lambdas cannot throw Checked Exceptions to the outside pipeline.
* Solution: You must catch the Checked Exception inside the lambda using a try-catch block and wrap it in an Unchecked RuntimeException.
``` Java
List<String> filePaths = List.of("file1.txt", "file2.txt");

// Forcing try-catch to handle Checked Exception (IOException)
List<String> lines = filePaths.stream()
    .map(path -> {
        try {
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + path, e);
        }
    })
    .collect(Collectors.toList());
```

### 3. Parallel Streams Optimization
A powerful feature that allows multi-core parallel processing with just a single keyword. However, misuse can severely degrade performance.
* **How to use**: Use .parallelStream() instead of .stream(), or append .parallel() to an existing pipeline.
* **When to use (Good)**: When handling millions of elements and the tasks are independent (e.g., CPU-intensive heavy mathematical computations).
* **When NOT to use (Bad)**:
  1. Small datasets (thread creation overhead outweighs the benefits).
  2. Operations where order matters (e.g., limit(), findFirst()).
  3. When the source is a LinkedList (poor performance because it's hard to split in half; use ArrayList instead).
  4. When tasks involve I/O operations like external API calls or DB queries (can exhaust the common thread pool and freeze the entire system).
```Java
List<Integer> largeNumbers = // ... millions of data points

// Fast sum calculation using parallel stream
long sum = largeNumbers.parallelStream()
    .filter(n -> n % 2 == 0)
    .mapToLong(n -> heavyComputation(n)) // Assuming a CPU-heavy method
    .sum();
```
