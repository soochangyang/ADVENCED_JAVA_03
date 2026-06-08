package generic.ex1;

public class RowTypeMain {

    public static void main(String[] args) {
        //row type 또는 원시타입이라고 한다. 에지간 하면 쓰지마라.... 하위버전의 자바 지원을 위한 것....
        GenericBox integerBox = new GenericBox<>();
        //아래와 같이 타입을 지정하는것을 권장한다.
        //= GenericBox<Object> integerBox = new GenericBox(); // 권장
        integerBox.set(10);
        Object obj = integerBox.get();
        System.out.println("obj = " + obj);
    }
}
