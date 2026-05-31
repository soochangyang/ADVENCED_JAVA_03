package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple3 {
    public static void main(String[] args) {
        //타입생략
        MyFunction myFunction1 = (int a, int b) -> a + b;
        myFunction1.apply(1, 2);

        // 타입 추론
        MyFunction myFunction2 = (a, b) -> a + b;
        int result = myFunction2.apply(1, 2);
        System.out.println(result);
    }
}
