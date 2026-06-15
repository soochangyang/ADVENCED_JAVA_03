package functional;

import java.util.function.Function;

public class FirstClassCitizenMain {
    public static void main(String[] args) {
        // 함수를 변수에 담는다.
        Function<Integer, Integer> func = x -> x * 2;

        //함수를 인자로 전달
        applyFunction(10, func);

        //함수를 바환
        getFunc().apply(10);
    }
    // 자바의 함수형 인터페이스를 사용해 함수를 변수처럼 취급하고 있다. 함수를 인자로 전달 하거나 반환함으로써 함수가
    // 일급 시민 (fist-class Citizen)인 모습을 확인 할 수 있다. 이는 고차 함수를 구현하는 기반이 된다.

    // 고차 함수 : 함수를 이자로 받음
    private static Integer applyFunction(int input, Function<Integer, Integer> func) {
        return func.apply(input);
    }

    // 고차 함수 : 함수를 반환
    private static Function<Integer, Integer> getFunc() {
        return x -> x * 2;
    }
}
