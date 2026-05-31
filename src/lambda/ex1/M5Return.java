package lambda.ex1;

import lambda.MyFunction;

public class M5Return {

    public static MyFunction getOperator(String operator){
        switch (operator){
            case "add" : return (a, b) -> a + b;
            case "sub": return (a, b) -> a - b;
            default: return (a, b) -> 0;
        }
    }

    public static void main(String[] args) {
        MyFunction add = getOperator("add");
        MyFunction sub = getOperator("sub");
        MyFunction mul = getOperator("mul");

        System.out.println(add.apply(1, 2));
        System.out.println(sub.apply(1, 2));
        System.out.println(mul.apply(1, 2));
    }

}
