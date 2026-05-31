package lambda.start;


public class Ex0RefMain {
//Value Parameterization
    public static void hello(String arg){
        System.out.println("프로그램시작");
        System.out.println(arg);
        System.out.println("프로그램종료");
    }

    public static void main(String[] args) {
        hello("hello java");
        hello("hello Spring");
    }
}
