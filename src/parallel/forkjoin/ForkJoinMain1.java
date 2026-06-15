package parallel.forkjoin;


import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ForkJoinMain1 {
    public static void main(String[] args) {
        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();

        log("[생성] " + data);

        // ForjoinPool  생성 및 작업 수행
        long startTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(10);
        SumTask task = new SumTask(data); // 1 ~ 8

        // 병렬로 합을 구한 결과 출력
        Integer result = pool.invoke(task);
        pool.close();
        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " +result);
        //fork join pool 정보 표시
        //[     main] pool: java.util.concurrent.ForkJoinPool@31cefde0
        // [Terminated, parallelism = 10, size = 0, active = 0, running = 0, steals = 4, tasks = 0, submissions = 0]
        log("pool: " + pool );
    }
}
