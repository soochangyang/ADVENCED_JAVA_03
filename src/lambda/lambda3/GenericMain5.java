package lambda.lambda3;

public class GenericMain5 {
    public static void main(String[] args) {
        GenericFunction<String, String> upperCase = s -> s.toUpperCase();
        String result1 = (String) upperCase.apply("hello");
        System.out.println("result = " + result1);

        GenericFunction<Integer, Integer> square =  i -> i * i;
        Integer result2 = (Integer) square.apply(3);
        System.out.println("result2 = " + result2);
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T s);
    }
}

