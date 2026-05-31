package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain1 {
    public static void main(String[] args) {
        MyFunction add = (int a, int b) -> a + b;
        MyFunction sub = (int a, int b) -> a - b;

        System.out.println("add.apply(1,2) = " + add.apply(1,2));
        System.out.println("sub.apply(1,2) = " + sub.apply(1,2));

        MyFunction cal1 = add;
        System.out.println("cal(add).apply(1,2) = " + cal1.apply(1,2));

        MyFunction cal2 = sub;
        System.out.println("cal(add).apply(1,2) = " + cal2.apply(1,2));

    }
}
