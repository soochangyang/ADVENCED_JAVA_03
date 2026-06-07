package generic.ex1;

public class BoxMain2 {
    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
        Integer integer = (Integer) integerBox.get();
        System.out.println("integer = " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("hello");
        String str = (String) stringBox.get();
        System.out.println("string = " + str);

        //잘못된 타입의 인수 전달시 - 재사용 가능하지만 타입안전 하지 못함
        integerBox.set("문자100");
        Integer result = (Integer) integerBox.get(); // ClassCastException
        System.out.println("result = " + result);
    }
}
