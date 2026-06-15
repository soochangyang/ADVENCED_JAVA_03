package functional;

import java.util.function.Function;

// 함수 합성 Composition
// 간단한 함수를 조합해 더 복잡한 함수를 만드는 것을 권장한다.
// 작은 단위의 함수들을 체이닝(Chaining)하거나 파이프라이닝(Pipelineing)해서 재사용성을 높이고, 코드 이해도를 높인ㄷ.ㅏ
public class CompositionMain1 {
    static void main(String[] args) {
        // 1. x를 입력받아 x * x 하는 함수
        Function<Integer, Integer> square = x -> x * x;
        // 2. x를 입력받아 x + 1 하는 함수
        Function<Integer, Integer> add = x -> x + 1;

        //함수 합성
        // 1. compose()를 사용한 새로운 함수 생성
        // 먼저 add 적용 후 square 적용하는 새로운 함수 newFunc1 생성
        // = square(add(2)) -> add(2) = 3 * 3 = 9
        Function<Integer, Integer> newFunc1 = square.compose(add);
        System.out.println("newFunc1 결과 : " + newFunc1.apply(2));

        // 2. andThen() 을 사용한 새로운 함수 생성
        // 먼저 square 적용 후 add 적용하는 새로운 함수 newFunc2생성
        // add(square(2)) -> add(4) -> 5
        Function<Integer, Integer> newFunc2 = square.andThen(add);
        System.out.println("newFunc2 결과 : " + newFunc2.apply(2));
    }
}
