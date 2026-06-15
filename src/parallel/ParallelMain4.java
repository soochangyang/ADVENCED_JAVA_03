package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain4 {

    public static void main(String[] args) {

        //int processorCount = Runtime.getRuntime().availableProcessors();
        //ForkJoinPool commonPool = ForkJoinPool.commonPool();
        //log("processorCount = " + processorCount);
        //log("commonPool = " + commonPool.getParallelism());

        long startTime = System.currentTimeMillis();

        //Stream. 에  parallel 을 선언하여 ForkJoinPool을 사용함.
        int sum = IntStream.rangeClosed(1, 8)
                .parallel()
                .map(HeavyJob::heavyTask)
                .reduce(0, (a, b) -> a + b);

        long endTime = System.currentTimeMillis();

        log("time : "+ (endTime - startTime) + "ms, sum: " + sum);
    }
}
