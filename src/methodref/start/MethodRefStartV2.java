package methodref.start;

import java.util.function.BinaryOperator;

public class MethodRefStartV2 {
    static void main(String[] args) {
        BinaryOperator<Integer> add1 = (x, y) -> add(x, y);
        BinaryOperator<Integer> add2 = (x, y) -> add(x, y);

        System.out.println(add1.apply(1, 2));
        System.out.println(add2.apply(1, 2));
    }

    static int add (int x, int y){
        return x + y;
    }
}
