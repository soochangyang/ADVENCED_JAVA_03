package lambda.lambda4;

import java.util.function.Function;

public class FunctionMain {
    static void main(String[] args) {
        //익명Class
        Function<String, Integer> function1 = new Function<String, Integer>(){

            @Override
            public Integer apply(String s){
                return s.length();
            }
        };

        System.out.println("function1 : " + function1.apply("lambda"));

        //lambda
        Function<String, Integer> function2 = s ->  s.length();
        System.out.println("function2 : " + function2.apply("hello"));

    }
}