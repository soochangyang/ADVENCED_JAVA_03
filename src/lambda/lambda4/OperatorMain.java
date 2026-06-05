package lambda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain {

    static void main(String[] args) {

        //UnaryOperator 단항 연산자.
        // UnaryOperator의 부모는 Function이다. > interface UnaryOperator<T> extends Function<T, T>
        UnaryOperator<Integer> unaryOperator1 = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i * i;
            }
        };

        System.out.println(unaryOperator1.apply(5));

        UnaryOperator<Integer> unaryOperator2 = i -> i * i;
        System.out.println("UnaryOperator : " + unaryOperator2.apply(7));

        Function<Integer, Integer> f1 = i -> i * i;
        System.out.println("Function : "+f1.apply(5));


        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        //BinayOperator 이항 연산자
        // BinaryOperator의 부모는 BiFunction<T,T,T>이다. > interface BinayOperator<T> extends BiFunction<T, T, T>
        BinaryOperator<Integer> binaryOperator1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i1, Integer i2) {
                return i1 * i2;
            }
        };

        System.out.println("BinaryOperator : " + binaryOperator1.apply(3, 6));

        //Lambda
        BinaryOperator<Integer> binaryOperator2 = (i1, i2) -> i1 * i2;
        System.out.println(binaryOperator2.apply(3, 8));

        BiFunction<Integer, Integer, Integer> f2 = (a, b) -> a * b;
        System.out.println("biFunction : " + f2.apply(2, 6));


    }
}
