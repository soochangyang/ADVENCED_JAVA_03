package lambda.lambda3;

public class GenericMain1 {
    public static void main(String[] args) {
        StringFunction upperCase = s -> (String)s.toUpperCase();
        System.out.println(upperCase.apply("hello"));

        NumberFunction square = i -> i * i;
        System.out.println(square.apply(100));
    }

    @FunctionalInterface
    interface StringFunction{
        String apply(String s);
    }

    @FunctionalInterface
    interface NumberFunction{
        Integer apply(Integer i);
    }
}
