# 자바 람다(Lambda) 핵심 정리 노트 / Java Lambda Core Study Notes

---

## 🇰🇷 [Korean Version] 자바 람다 핵심 정리

### I. 자바에 람다가 도입된 진짜 이유 (도입 배경과 장점)

**1. 도입 배경**
* **멀티코어 시대의 도래:** CPU 코어가 많아지면서 방대한 데이터를 병렬로 빠르게 처리해야 할 필요성이 커졌다. 기존 `for`문 중심의 방식은 병렬 처리 구현이 복잡하고 위험했다.
* **기존 자바 문법의 비효율성:** 자바는 순수 객체지향 언어였기 때문에, 단순한 동작(메서드) 하나를 넘기기 위해서도 무거운 '익명 내부 클래스'를 만들어야 하는 문법적 피로도가 높았다.

**2. 3가지 핵심 장점**
* **코드의 압도적 간결성:** 의미 없는 껍데기 코드(Boilerplate)를 걷어내고, 실제 실행할 **핵심 로직만** 짧고 직관적으로 작성할 수 있다.
* **동작 파라미터화 (Behavior Parameterization):** 값(Data)뿐만 아니라 **'로직(행동)' 자체를 변수처럼 메서드의 인자로 전달**할 수 있어 요구사항 변경에 유연하게 대처할 수 있다.
* **Stream API의 완성:** 람다의 도입으로 컬렉션 데이터를 마치 SQL 쿼리처럼 선언적으로 가공(`filter`, `map` 등)하고 손쉽게 병렬 처리할 수 있게 되었다.

### II. 람다식만의 특별한 성질과 동작 원리 (특이점)

**1. 이름과 타입이 없는 '익명 함수'**
* 메서드의 이름과 반환 타입을 생략하고 `(파라미터) -> { 실행문 }` 형태만 남긴다.
* 람다 자체는 고유한 클래스 타입이 없으며, 대입되는 변수나 매개변수의 위치를 보고 스스로의 정체를 결정한다.

**2. 타겟 타입 추론 (Target Typing)**
* 자바 컴파일러는 람다가 놓인 문맥(Context)을 분석하여 타입을 자동으로 추론한다.

**3. 외부 변수 캡처 (Variable Capture)**
* 람다는 중괄호 `{}` 밖의 지역 변수를 가져다 쓸 수 있다.
* **제약 조건:** 단, 동시성 문제와 메모리 생명주기 차이를 막기 위해, 가져다 쓰는 외부 지역 변수는 반드시 값이 변경되지 않는 `final` 또는 `effectively final` 상태여야만 한다.

**4. 실행의 지연 (Lazy Evaluation)**
* 람다식은 작성되는 즉시 실행되지 않는다. "나중에 이렇게 동작해"라는 행동 지시서일 뿐이며, 최종적으로 메서드가 호출할 때 비로소 실행된다.

**5. 메서드 참조 (Method Reference, `::`)**
* 람다가 단순히 기존에 존재하는 단 하나의 메서드만 호출할 경우 `클래스::메서드` 형태로 더욱 축약해서 가독성을 높일 수 있다.

### III. 실무에서 람다를 100% 활용하기 위한 핵심 기능 (주요 기능)

**1. 자바 표준 함수형 인터페이스 활용**
* `Predicate<T>`: 데이터를 받아 조건 검사 (boolean 반환)
* `Consumer<T>`: 데이터를 받아 소비하고 끝 (void 반환)
* `Function<T, R>`: 데이터를 받아 다른 타입으로 변환 (R 반환)
* `Supplier<T>`: 파라미터 없이 새로운 데이터를 제공 (T 반환)

**2. 컬렉션 프레임워크와의 결합**
* `List.forEach()`: 요소를 순회하며 람다 실행
* `List.removeIf()`: 람다 조건에 맞는 요소만 삭제

**3. Stream API 파이프라인 가공**
* 데이터 필터링(`filter`), 변환(`map`), 집계(`reduce`, `collect`) 등 데이터를 흐름에 따라 제어하는 핵심 도구.

**4. Optional 연계 (NPE 방지)**
* `orElseGet(Supplier)`: 값이 진짜 없을 때만 연산을 지연 실행하여 기본값을 가져옴
* `ifPresent(Consumer)`: 값이 존재할 때만 특정 로직을 실행하도록 분기 처리

### IV. 람다 사용 시 반드시 알아야 할 주의사항 (한계와 트레이드오프)

**1. 디버깅의 어려움:** 익명 객체 기반이므로 에러 발생 시 스택 트레이스(Stack Trace) 추적이 까다롭다.

**2. 가독성 저하:** 로직이 3줄 이상 길어지면 일반 메서드로 분리하고 '메서드 참조(`::`)'를 쓰는 것이 좋다.

**3. `this`의 의미:** 익명 내부 클래스와 달리, 람다 내부의 `this`는 **람다를 감싸고 있는 외부 클래스**를 가리킨다.

**4. 단순 반복문 성능 오버헤드:** 매우 단순한 배열 순회 연산의 경우 전통적인 `for`문이 속도 면에서 더 빠를 수 있다.

<br>

---

## 🇺🇸 [English Version] Java Lambda Core Study Notes

### I. Why Lambda Was Introduced to Java (Background & Advantages)

**1. Background**
* **The Multi-core Era:** As CPUs gained more cores, the need to process large amounts of data in parallel grew rapidly. The traditional `for`-loop approach was complex and risky for parallel processing.
* **Inefficiency of Legacy Syntax:** Because Java was strictly object-oriented, passing a single behavior (method) required creating a heavy and verbose "Anonymous Inner Class".

**2. 3 Core Advantages**
* **Extreme Conciseness:** Removes meaningless boilerplate code, leaving only the **core logic** to be executed in a short and intuitive manner.
* **Behavior Parameterization:** Allows passing not just data, but **"logic (behavior)" itself as a variable** to methods, making the code highly flexible to changing requirements.
* **Completion of the Stream API:** Lambdas enabled the collection data to be processed declaratively (like SQL queries via `filter`, `map`, etc.) and easily parallelized.

### II. Unique Characteristics and Working Principles of Lambda (Peculiarities)

**1. Anonymous Function**
* Omits the method name and return type, leaving only the `(parameters) -> { body }` format.
* A lambda itself does not have a unique class type; it determines its own identity based on the context (the variable or parameter it is assigned to).

**2. Target Type Inference**
* The Java compiler automatically infers the type of the lambda by analyzing the context in which it is placed.

**3. Variable Capture**
* Lambdas can use local variables defined outside their `{}` block.
* **Constraint:** To prevent concurrency issues and memory lifecycle mismatches, captured local variables must be `final` or `effectively final` (their value never changes).

**4. Lazy Evaluation**
* A lambda expression is not executed immediately upon creation. It acts as an instruction manual ("do this later") and is only executed when explicitly called by a method.

**5. Method Reference (`::`)**
* When a lambda simply calls a single existing method, it can be further abbreviated using the `Class::method` syntax to maximize readability.

### III. Key Features for 100% Practical Utilization (Core Functions)

**1. Standard Functional Interfaces**
* `Predicate<T>`: Evaluates a condition (returns boolean).
* `Consumer<T>`: Consumes data without returning anything (returns void).
* `Function<T, R>`: Transforms data from type T to type R.
* `Supplier<T>`: Provides new data without taking any parameters (returns T).

**2. Collection Framework Integration**
* `List.forEach()`: Iterates through elements and executes the lambda.
* `List.removeIf()`: Neatly removes elements that match the lambda condition.

**3. Stream API Pipeline**
* Acts as the core tool for controlling data flow through filtering (`filter`), transformation (`map`), and aggregation (`reduce`, `collect`).

**4. Optional Integration (Preventing NPE)**
* `orElseGet(Supplier)`: Lazily executes a heavy operation to get a default value *only* if the value is truly missing.
* `ifPresent(Consumer)`: Executes specific logic cleanly *only* if the value is present.

### IV. Crucial Precautions When Using Lambda (Limitations & Trade-offs)

**1. Debugging Difficulty:** Because lambdas are based on anonymous objects, stack traces contain meaningless names, making it hard to track down errors.
**2. Drop in Readability:** If the internal logic exceeds 3 lines, it becomes hard to read. It's better to extract it to a regular method and use a Method Reference (`::`).
**3. Meaning of `this`:** Unlike anonymous inner classes, `this` inside a lambda refers to the **enclosing outer class**.
**4. Performance Overhead in Simple Loops:** For very simple array iterations, the overhead of streams and lambdas might make traditional `for`-loops faster.