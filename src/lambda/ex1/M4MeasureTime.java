package lambda.ex1;

import lambda.Procedure;

import java.util.Arrays;

public class M4MeasureTime {

    //콛통로직
    public static void measure(Procedure p) {
        long startNs = System.nanoTime();
        p.run();
        long endNs = System.nanoTime();
        System.out.println("measure time: " + (endNs - startNs) + "Ns");
    }

    public static void main(String[] args) {
        measure(() -> {
            int n = 100;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += i;
            }
            System.out.println("[Sum of 1 to " + n + "]  " + sum);
        });

        measure(() -> {
            int[] arr = {4, 3, 2, 1};
            System.out.println("원본 배열: " + Arrays.toString(arr));
            Arrays.sort(arr);
            System.out.println("배열 정렬: " + Arrays.toString(arr));
        });

    }
}
