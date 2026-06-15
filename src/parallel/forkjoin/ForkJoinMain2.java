package parallel.forkjoin;


import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ForkJoinMain2 {
    public static void main(String[] args) {
        //int processorCount = Runtime.getRuntime().availableProcessors();
        //ForkJoinPool commonPool = ForkJoinPool.commonPool();
        //log("ProcessorCount = " + processorCount);
        //log("commonPool = " + commonPool.getParallelism());


        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();

        log("[생성] " + data);

        // ForkJoinPool  생성 및 작업 수행
        long startTime = System.currentTimeMillis();
        SumTask task = new SumTask(data); // 1 ~ 8
        //공용풀 사용
        Integer result = task.invoke();

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " +result);

        //log("pool: " + commonPool );
    }
}
