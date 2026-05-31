package lambda.ex2;

public class BuildGreeterExample {

    public static StringFunction buildGreeter(String greeting){
        return s -> greeting + ", " + s;

    }


    public static void main(String[] args) {
        StringFunction hello = buildGreeter("Hello");
        StringFunction hi = buildGreeter("hi");

        System.out.println(hello.apply("Java"));
        System.out.println(hi.apply("Lambda"));
    }
}
