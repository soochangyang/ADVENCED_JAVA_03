package generic.ex4;

public class MethodMain1 {
    public static void main(String[] args) {
        Integer i = 10;
        Object object = GenericMethod.objectMethod(i);

        // 타입 인자 (Type Argument) 명시적 전달
        System.out.println("명시적 타입 인자 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i);
        String str = GenericMethod.genericMethod("hello");

        // 타입 추론
        Integer integerValue = GenericMethod.numbersMethod(10);
        GenericMethod.numbersMethod(10.0);
        GenericMethod.numbersMethod(20.0F);
    }
}
