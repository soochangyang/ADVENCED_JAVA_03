package lambda.ex1;

import lambda.Procedure;

import java.util.Arrays;

public class M3Before {


    public static void main(String[] args) {
        Procedure procedure1 = new Procedure() {

            @Override
            public void run() {
                long sn = System.nanoTime();

                int result = 0;
                for (int i = 1; i <= 10; i++) {
                    result = +i;
                }
                System.out.println("SUM: " + result);
                long en =  System.nanoTime();
                System.out.println("Take : " + (en-sn) +"ns");
            }
        };

        Procedure procedure2 = new Procedure() {
            @Override
            public void run() {
                long sn = System.nanoTime();
                int[] myArray = {1, 2, 5, 7, 3, 4, 6, 8, 9, 0};
                System.out.println("원본배열: "+Arrays.toString(myArray));
                Arrays.sort(myArray);
                System.out.println("배열정렬: "+Arrays.toString(myArray));
                long en =  System.nanoTime();
                System.out.println("Take : " + (en-sn) +"ns");
            }
        };

        procedure1.run();
        procedure2.run();
    }
}
