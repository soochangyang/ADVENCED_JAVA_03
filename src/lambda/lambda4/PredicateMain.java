package lambda.lambda4;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateMain {
    static void main(String[] args) {

        //Anonymous
        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i % 2 == 0;
            }
        };
        System.out.println(predicate1.test(4));

        //Lambda
        Predicate<Integer> predicate2 = i -> i % 2 == 0;
        System.out.println(predicate2.test(10));


        Function<Integer, Boolean> func = i -> i % 2 == 0;
        System.out.println(func.apply(5));

    }
}
