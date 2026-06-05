package lambda.ex3;


import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceExample {

    public static int reduce(List<Integer> list, int initial, BinaryOperator<Integer> reducer) {
        Integer result = initial;

        for (int val : list) {
            result = reducer.apply(result, val);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println(numbers);
        int add = reduce(numbers, 0, (a, b) -> a + b);
        System.out.println("합누적 : " + add);

        int mul = reduce(numbers, 1, (a, b) -> a * b);
        System.out.println("곱누적 : " +mul);
    }

}
