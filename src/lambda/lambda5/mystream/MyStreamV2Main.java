package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamV2Main {
    public static void main(String[] args) {
        // Even & multi
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = MyStreamV2.of(numbers)
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .toList();
        System.out.println(result);
    }
}
