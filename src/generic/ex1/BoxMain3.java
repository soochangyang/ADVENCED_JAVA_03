package generic.ex1;

public class BoxMain3 {

    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>(); // 생성시점에 T의 타입이 결정됨
        integerBox.set(10);
        //integerBox.set("문자열100"); //Integer 타압만 혀용되고, 컴파일 오류 발생
        Integer integer = integerBox.get(); //Integer 타입 반환 (no need to cast)
        System.out.println("integer = " + integer);

        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("hello");
        String string = stringBox.get();
        System.out.println("string = " + string);

        GenericBox<Double> doubleBox = new GenericBox<>();
        doubleBox.set(10.5);
        Double doubleValue = doubleBox.get();
        System.out.println("doubleValue = " + doubleValue);

        //타입추론 : 생성하는 제너릭 타입 생략가능
        GenericBox<Integer> integerBox2 = new GenericBox<>();
    }
}
