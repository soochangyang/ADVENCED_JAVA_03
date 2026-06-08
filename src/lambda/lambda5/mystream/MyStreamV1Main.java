package lambda.lambda5.mystream;

import java.sql.SQLOutput;
import java.util.List;

public class MyStreamV1Main {
    public static void main(String[] args) {
        // Even & multi
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        returnValue(numbers);
        methodChain(numbers);
    }

    private static void methodChain(List<Integer> numbers) {
        MyStreamV1 stream = new MyStreamV1(numbers);
        List<Integer> result = stream.filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .toList();

        System.out.println("stream = " + result);
    }

    private static List<Integer> returnValue(List<Integer> numbers) {
        MyStreamV1 stream = new MyStreamV1(numbers);
        MyStreamV1 filteredStream = stream.filter(x -> x % 2 == 0);
        MyStreamV1 mappedStream = filteredStream.map(x -> x * 2);
        System.out.println("mappedStream = " + mappedStream.toList());

        return mappedStream.toList();
    }
}
