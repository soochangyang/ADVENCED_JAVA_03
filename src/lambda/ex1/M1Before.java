package lambda.ex1;

public class M1Before {

    public static void greet(String message){
        System.out.println("=== Start ===");
        System.out.println(message);
        System.out.println("=== Start ===");
    }

    public static void greetMorning(){
        System.out.println("=== Start ===");
        System.out.println("Good Morning");
        System.out.println("=== Start ===");
    }

    public static void greetAfternoon(){
        System.out.println("=== Start ===");
        System.out.println("Good Afternoon");
        System.out.println("=== Start ===");
    }

    public static void greetEvening(){
        System.out.println("=== Start ===");
        System.out.println("Good Evening");
        System.out.println("=== Start ===");
    }

    public static void main(String[] args) {
        greetMorning();
        greetAfternoon();
        greetEvening();

        greet("Kiaora");
    }
}
