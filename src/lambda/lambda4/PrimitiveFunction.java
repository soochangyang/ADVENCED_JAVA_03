package lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {

    static void main(String[] args) {
        // primitive type parameter>>> IntFunction, LongFunction, DoubleFunction
        IntFunction<String> intFunction = x -> "숫자 : " + x;
        System.out.println("function.apply(100) = "+intFunction.apply(100));

        // primitive type return >>> ToIntFunction, ToLongFunction, ToDoubleFunction
        ToIntFunction<String> toIntFunction1 = s -> s.length();
        System.out.println(toIntFunction1.applyAsInt("Hello lambda world!"));
        ToIntFunction<Integer> toIntFunction2 = i -> i * i;
        System.out.println(toIntFunction2.applyAsInt(12));


        // primitive type parameter & return
        IntToLongFunction intToLongFunction = i -> i * 100L;
        System.out.println(intToLongFunction.applyAsLong(100));

        //etc IntConsumer, IntSupplier, IntPredicate
    }
}
