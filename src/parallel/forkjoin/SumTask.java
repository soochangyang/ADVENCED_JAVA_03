package parallel.forkjoin;

import parallel.HeavyJob;

import java.util.List;
import java.util.concurrent.RecursiveTask;

import static util.MyLogger.log;

public class SumTask extends RecursiveTask<Integer> {
    //private static final int THRESHOLD = 4;
    private static final int THRESHOLD = 2;

    private final List<Integer> list;

    public SumTask(List<Integer> list) {
        this.list = list;
    }



    @Override
    protected Integer compute() {

        if (list.size() <= THRESHOLD) {
            //작은 작업 범위의 경우 직접 처리
            log("[처리 시작] " + list);
            int sum = list.stream()
                    .mapToInt(HeavyJob::heavyTask)
                    .sum();
            log("[처리 완료] " + list + " -> sum: " + sum);
            return sum;
        } else {
            //작업 범위가 크면 작업을 나누어 병렬처리
            log("");
            int mid = list.size() / 2;
            List<Integer> leftList = list.subList(0, mid);
            List<Integer> rightList = list.subList(mid, list.size());
            log("[분할] " + list + " -> leftList: " + leftList + ", rightList: " + rightList);

            SumTask leftTask = new SumTask(leftList);
            SumTask rightTask = new SumTask(rightList);

            //  왼쪽 작업은 다른쓰레드
            // 별도의 ForkJoinPool을 생성하지 않았다면 공용 pool을 [ForkJoinPool.commonPool();]
            // leftTask.fork() 를 호출 할때 사용한다.
            leftTask.fork();
            //  오른쪽 작업은 현재 스레드에서 처리
            Integer rightResult = rightTask.compute();

            // 왼쪽 작업 결과를 기다림
            Integer leftResult = leftTask.join();
            int joinSum = leftResult + rightResult;
            log("LEFT[ + " + leftResult + "] + RIGHT[" + rightResult + "]: " + joinSum );
            return joinSum;
        }
    }
}
