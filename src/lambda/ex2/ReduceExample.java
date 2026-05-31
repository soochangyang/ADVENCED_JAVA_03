package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class ReduceExample {

    public static int reduce(List<Integer> list, int initial, MyReducer reducer) {
        int result = initial;

        for (int val : list) {
            result = reducer.reduce(result, val);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println(numbers);
        int add = reduce(numbers, 0, (a, b) -> a + b);
        System.out.println(add);

        int mul = reduce(numbers, 1, (a, b) -> a * b);
        System.out.println(mul);
    }
}
