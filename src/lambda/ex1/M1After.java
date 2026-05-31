package lambda.ex1;

public class M1After {

    public static void greet(String message){
        System.out.println("=== Start ===");
        System.out.println(message);
        System.out.println("=== Start ===");
    }

    public static void main(String[] args) {
        greet("Kiaora");
        greet("Good Morning");
        greet("Good Afternoon");
        greet("Good Evening");
    }
}
