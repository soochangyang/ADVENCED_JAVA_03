package lambda.ex3;

import lambda.ex2.MyPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterExampleEx2 {
    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> result = new ArrayList<>();
        for(int val: list){
            if (predicate.test(val)){
                result.add(val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, -2, 2, 0, 5, -10, 7);
        System.out.println(" 원본 리스트 : " +  numbers);

        // 1. 음수 (negative) 만 뽑아내기
        List<Integer> negatives = filter(numbers, val ->  val < 0);
        System.out.println(" 음수만 : " + negatives);

        // 2. 짝수(even)만 뽑아내기
        List<Integer> evens = filter(numbers, val -> val % 2 == 0);
        System.out.println(" 짝수만 : " +evens);
    }
}
