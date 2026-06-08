package generic.ex1;

public class BoxMain1 {

    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.set(10);
        System.out.println("integer = " + integerBox.get());

        StringBox stringBox = new StringBox();
        stringBox.set("hello");
        System.out.println("string = " + stringBox.get());
    }
}
