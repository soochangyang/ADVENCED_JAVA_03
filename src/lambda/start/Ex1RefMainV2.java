package lambda.start;


import lambda.Procedure;

import java.util.Random;

//익명클래스 사용
public class Ex1RefMainV2 {
    // Behavior Parameterization
    public static void hello(Procedure procedure){
        long startNs = System.nanoTime();
        //
        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("Runtime = " + (endNs - startNs) + "ns");
    }


    public static void main(String[] args) {
        Procedure dice = new Procedure() {
            @Override
            public void run() {
                int randomValue = new Random().nextInt(6)+1;
                System.out.println("Dice = " +randomValue);
            }
        };

        Procedure sum = new Procedure(){
            @Override
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        };

        hello(dice);
        hello(sum);
    }
}
