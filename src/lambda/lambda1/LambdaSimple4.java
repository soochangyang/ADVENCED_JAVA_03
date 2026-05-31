package lambda.lambda1;

public class LambdaSimple4 {
    public static void main(String[] args) {
        MyCall myCall1 = (int value) -> value * 2;
        MyCall myCall2 = ( value) -> value * 3;
        MyCall myCall3 = value -> value * 4;

        System.out.println("call = " + myCall1.call(5));
    }

    interface MyCall {
        int call(int value);
    }
}
