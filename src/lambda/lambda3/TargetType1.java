package lambda.lambda3;

public class TargetType1 {

    public static void main(String[] args) {
        FunctionA functionA = i -> "value = " + i;
        System.out.println(functionA.apply(10));
        FunctionB functionB = i -> "value = " + i;
        System.out.println(functionB.apply(10));

        // 이미 만들어진 FunctionA instance를 FunctioonB에 대입 가능?
        //FunctionB functionB = functionA; //타입오류
    }

    @FunctionalInterface
    interface FunctionA {
        String apply(Integer i);
    }

    @FunctionalInterface
    interface FunctionB {
        String apply(Integer i);
    }
}
