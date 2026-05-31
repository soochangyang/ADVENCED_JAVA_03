package lambda.start;


import lambda.Procedure;

import java.util.Random;

//익명클래스 사용 , 변수 제거 , 익명 클래스의 참조값을 매개변수 (파라메터)에 직접 전달
public class Ex1RefMainV4 {
    // Behavior Parameterization
    public static void hello(Procedure procedure){
        long startNs = System.nanoTime();
        //
        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("Runtime = " + (endNs - startNs) + "ns");
    }


    public static void main(String[] args) {
        hello(() -> {
                int randomValue = new Random().nextInt(6)+1;
                System.out.println("Dice = " +randomValue);
        });

        hello(() -> {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("i = " + i);
                }
        });
    }
}
