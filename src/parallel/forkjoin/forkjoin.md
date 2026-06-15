# Java Fork/Join Framework & Database Batch Operations

---

## 🇰🇷 [Korean] Part 1: RecursiveTask를 활용한 병렬 처리

### 1. RecursiveTask 개념
`RecursiveTask<V>`는 Java의 Fork/Join 프레임워크에서 **결과값을 반환하는 작업**을 병렬로 처리할 때 사용하는 추상 클래스임.
* **작동 원리 (분할 정복):** 작업 단위가 충분히 작아질 때까지 반으로 쪼개고(Fork), 각 스레드가 병렬 연산을 수행한 뒤, 결과를 다시 합침(Join).

### 2. 구현 예제: 대규모 배열 합계 계산
```java
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ArraySumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10_000; // 분할 임계값
    private final long[] array;
    private final int start, end;

    public ArraySumTask(long[] array, int start, int end) {
        this.array = array; 
        this.start = start; 
        this.end = end;
    }

    @Override
    protected Long compute() {
        // 1. 작업이 충분히 작으면 직접 순차 계산 (Conquer)
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) sum += array[i];
            return sum;
        } 
        // 2. 작업이 크면 반으로 분할 (Fork)
        int mid = start + (end - start) / 2;
        ArraySumTask left = new ArraySumTask(array, start, mid);
        ArraySumTask right = new ArraySumTask(array, mid, end);

        left.fork(); // 왼쪽 하위 작업은 다른 스레드로 비동기 실행
        long rightResult = right.compute(); // 오른쪽은 현재 스레드에서 즉시 실행
        long leftResult = left.join(); // 왼쪽 작업 완료 대기 및 결과 반환

        // 3. 결과 병합 (Join)
        return leftResult + rightResult;
    }

    // 실행 방법: 
    // ForkJoinPool pool = new ForkJoinPool();
    // long totalSum = pool.invoke(new ArraySumTask(myArray, 0, myArray.length));
}
```
## DB Batch 작업을 RecursiveTask로 대체할 수 있는가?
* 결론: 절대 대체할 수 없으며, 실무에서 시도해서는 안 됨.
* Fork/Join(RecursiveTask)은 메모리 내부의 CPU 집약적 연산(Math, Array Sorting 등)을 위해 설계된 도구임. DB 접근과 같은 I/O 집약적 작업에 사용하면 시스템 전체가 마비될 수 있음.

### 🚫 불가 이유 상세 분석
1. I/O 블로킹으로 인한 스레드 풀 고갈
   Fork/Join 풀은 CPU 코어 수만큼의 적은 스레드만 생성함. 여러 스레드가 DB 응답을 기다리며(I/O Blocking) 멈춰버리면, 워커 스레드가 고갈되어 애플리케이션의 다른 연산까지 모두 중단됨.

2. 데이터베이스 커넥션 풀(DB Connection Pool) 고갈
   RecursiveTask가 병렬로 수백 개의 작업을 fork()하면, 순간적으로 엄청난 수의 DB 커넥션을 요구함. HikariCP 등의 커넥션 풀이 즉시 동나고(Connection Timeout), 장애로 직결됨.

3. 트랜잭션(Transaction) 관리의 불가능
   Spring Batch 등의 전용 프레임워크는 수만 건의 데이터를 묶음(Chunk) 단위로 묶어 커밋하고 예외 시 롤백함. 하지만 Fork/Join의 각 스레드는 독립적으로 동작하므로, 글로벌 트랜잭션을 묶거나 중간에 에러가 났을 때 부분 롤백을 통제할 방법이 없음 (데이터 정합성 붕괴 및 데드락 발생 확률 극상).

4. 재시작 및 상태 추적 부재
   배치 작업 중 에러가 발생하면 "어디까지 처리되었는지" 기록하고 실패 지점부터 재시작해야 함. Fork/Join은 상태 저장 메커니즘이 아예 없으므로 실패 시 처음부터 다시 돌려야 함.

## Parallel Processing with RecursiveTask
1. Concept of RecursiveTask
   RecursiveTask<V> is an abstract class in Java's Fork/Join framework used to perform parallel tasks that return a result.

Mechanism (Divide and Conquer): It recursively splits tasks in half (Fork) until they are small enough, processes them in parallel across multiple threads, and then combines the results (Join).

2. Code Example: Summing a Large Array
   (See the Java code block above. The structure and logic remain the same.)

# Can it Replace Database Batch Operations?
* Conclusion: Absolutely not. It should never be used as a replacement.
* Fork/Join (RecursiveTask) is strictly designed for CPU-bound, in-memory computations. Using it for I/O-bound tasks like Database operations will lead to catastrophic system failures.

### 🚫 Detailed Reasons Why It Fails
1. Thread Pool Exhaustion due to I/O Blocking
   The Fork/Join pool creates a limited number of threads (usually equal to CPU cores). If threads wait for DB responses (I/O Blocking), the entire pool dries up, freezing other parallel processes in the application.

2. Database Connection Pool Starvation
   As RecursiveTask rapidly forks hundreds of tasks in parallel, it will instantly demand massive amounts of DB connections. This will immediately exhaust connection pools (like HikariCP), resulting in Connection Timeouts and system crashes.

3. Impossible Transaction Management
   Dedicated batch frameworks manage Chunk-based transactions (Commit/Rollback safely). In Fork/Join, each thread operates independently. Tying a global transaction across parallel threads is practically impossible, leading to broken data integrity, partial updates, and severe database deadlocks.

4. Lack of Resumability and State Tracking
   True batch jobs require the ability to track progress and resume from the point of failure. Fork/Join is entirely stateless in this regard; if a task fails halfway through, you cannot resume it, forcing you to restart the massive job from scratch.
