package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class FilterExampleEx1 {

    public static List<Integer> filter(List<Integer> list, MyPredicate predicate){
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
        List<Integer> negatives = filter(numbers, new MyPredicate(){
            @Override
            public boolean test(int value) {
                return value < 0;
            }
        });
        System.out.println(negatives);

        // 2. 짝수(even)만 뽑아내기
        List<Integer> evens = filter(numbers, new MyPredicate(){
            @Override
            public boolean test(int val) {
                return val % 2 == 0;
            }
        });
        System.out.println(evens);
    }
}
