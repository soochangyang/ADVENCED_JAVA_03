package functional;

import java.util.ArrayList;
import java.util.List;

//선언형 Declarative  접근
// 어떻게가 아닌 무엇을 계산할지 기술한다.
// 복잡한 제어 구조나 상태 관리를 함수의 합성과 함수 호출로 대체하여 간결하고 가독성 높은 코드를 작성한다.
public class DeclarativeMain {

    //짝수면 값을 제곱해라.
    static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        //명령어 :  for 문과 조건 검사로 처리
        List<Integer> result1 = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) { // 짝수 판단.
                result1.add(number * number); // 제곱한 값을 추가
            }
        }
        System.out.println("Imperative Result: " + result1);

        //선언형 :스트림 API처리
        List<Integer> result2 = numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .toList();

        System.out.println("Declarative Result: " + result2);

        //명령형 (Imperative)방식은 for 문과 조건문으로 어떻게(How) 처리할지 구체적으로 작성해야 한다.
        //반면, 선언형 (Declarative) 방식은 스트림의 filter ,map 같은 함수를 조합해(What)을 할지에 집중한다.
        //이렇게 선언형으로 작성하면 코드가 더 같결 해지고 로직이 명확해 진다.
    }
}
