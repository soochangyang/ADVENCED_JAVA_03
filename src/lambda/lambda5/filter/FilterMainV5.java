package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterMainV5 {
    public static void main(String[] args) {
        //숫자 사용 필터
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numberResult = GenericFilter.filter(numbers, i -> i % 2 == 0);
        System.out.println("even numbers = " + numberResult);

        //문자 사용 필터
        List<String> strings = List.of("apple", "banana", "lion", "dog", "cat");
        //List<String> strResult = GenericFilter.filter(strings, s -> s.contains("a") );
        List<String> strResult = GenericFilter.filter(strings, s -> s.startsWith("ba") );
        System.out.println("strings = " + strResult);

    }

}
