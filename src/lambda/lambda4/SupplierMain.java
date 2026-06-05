package lambda.lambda4;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierMain {

    static void main(String[] args) {
        //Anonymous Class
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return "Welcome to supplier Anonymous class";
            }
        };

        System.out.println(supplier1.get());

        //Lambda.
        Supplier<String> supplier2 = () -> "Welcome to lambda supplier";
        System.out.println(supplier2.get());

        Supplier<Integer> supplier3 =() -> new Random().nextInt(10);
        System.out.println(supplier3.get());

    }
}
