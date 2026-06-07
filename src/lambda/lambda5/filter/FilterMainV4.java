package lambda.lambda5.filter;

import java.util.List;

import static lambda.lambda5.filter.IntegerFilter.filter;

public class FilterMainV4 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //even 짝수만 거르기
        List<Integer> evenPredicate = filter(numbers, i -> i % 2 == 0);
        System.out.println("even numbers = " + evenPredicate);

        //odd 홀수만 거르기
        List<Integer> oddPredicate = filter(numbers, i -> i % 2 == 1);
        System.out.println("odd numbers = " + oddPredicate);

    }

}
