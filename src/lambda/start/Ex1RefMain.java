package lambda.start;


import lambda.Procedure;

import java.util.Random;

public class Ex1RefMain {
    // Behavior Parameterization
    public static void hello(Procedure procedure){
        long startNs = System.nanoTime();
        //
        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("Runtime = " + (endNs - startNs) + "ns");
    }

    public static class Dice implements Procedure {
        @Override
        public void run() {
            int randomValue = new Random().nextInt(6)+1;
            System.out.println("Dice = " +randomValue);
        }
    }

    public static class Sum implements Procedure {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("i = " + i);
            }
        }
    }

    public static void main(String[] args) {
        Procedure dice = new Dice();
        Procedure sum = new Sum();

        hello(dice);
        hello(sum);
    }
}
