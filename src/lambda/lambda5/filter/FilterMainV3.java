package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMainV3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //even 짝수만 거르기
        List<Integer> evenPredicate = filter(numbers, i -> i % 2 == 0);
        System.out.println("even numbers = " + evenPredicate);

        //odd 홀수만 거르기
        List<Integer> oddPredicate = filter(numbers, i -> i % 2 == 1);
        System.out.println("odd numbers = " + oddPredicate);

    }

    public static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (predicate.test(numbers.get(i))) {
                filtered.add(numbers.get(i));
            }
        }
        return filtered;
    }

}
