package lambda.lambda4;

public class TriMain {

    static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> triFunction  = (a, b, c) -> {
            System.out.print(a + " + " + b + " + " + c + " = " );
            return a + b + c;
        };
        System.out.println(triFunction.apply(3, 6, 9));
    }


    @FunctionalInterface
    interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }

}
