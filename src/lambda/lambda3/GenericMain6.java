package lambda.lambda3;

public class GenericMain6 {
    public static void main(String[] args) {
        GenericFunction <String, String> toUpperCase = str -> str.toUpperCase();
        GenericFunction <String, Integer> stringLength = str -> str.length();
        GenericFunction <Integer, Integer> square = x -> x *x;
        GenericFunction <Integer, Boolean> isEven = x -> x % 2 == 0;

        System.out.println(toUpperCase.apply("heello"));
        System.out.println(stringLength.apply("lambda"));
        System.out.println(square.apply(9));
        System.out.println(isEven.apply(9));

    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T s);
    }
}
