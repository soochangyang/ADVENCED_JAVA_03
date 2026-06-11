package optional;

import javax.swing.text.html.Option;
import java.sql.SQLOutput;
import java.util.Optional;

public class OptionalRetrievalMain {

    static void main(String[] args) {
        // 예제: 문자열 "Java"가 있는  Optional과 비어 있는 Optional 준비
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        // isPresent(): 값이 있으면 True
        System.out.println("=== 1. isPresent() / isEmpty)( ===");
        System.out.println("optValue.isPresent() = " + optValue.isPresent());
        System.out.println("optEmpty.isPresent() = " + optEmpty.isPresent());
        System.out.println("optValue.isEmpty() = " + optValue.isEmpty());
        System.out.println("optEmpty.isEmpty() = " + optEmpty.isEmpty());

        // get() : 직접 내부 값을 꺼냄, 값이 없으면 예외 (NoSuchElementException)
        System.out.println("=== 2. get() ===");
        String getValue = optValue.get();
        System.out.println("getValue = " + getValue);
        // NoSuchElementException 발생
        //String getValue2 = optEmpty.get();
        //System.out.println("getValue2 = " + getValue2);

        //값이 있으면 그 값, 없으면 지정된 기본값 사용
        System.out.println("=== 3. orElse() ===");
        String value1 = optValue.orElse("Default Value");
        String empty1 = optEmpty.orElse("Default Value");
        System.out.println("value1 = " + value1);
        System.out.println("empty1 = " + empty1);
        System.out.println();

        // 값이 없을 때만 람다(Supplier)가 실행되어 기본값 생성
        System.out.println("=== 4. orElseGet() ===");
        String value2 = optValue.orElseGet(() -> {
            //값이 있으면 lambda 호출 안됨
            System.out.println("Invoke Lambda - optValue");
            return "New Value";
        });

        String empty2 = optEmpty.orElseGet(() -> {
            System.out.println("Invoke Lambda - optEmpty");
            return "New Value";
        });
        System.out.println("value2 = " + value2);
        System.out.println("empty2 = " + empty2);

        // 값이 있으면 반환, 없으면 예외
        System.out.println("=== 5.orElseGet() ===");
        String value3 = optValue.orElseThrow(() -> new RuntimeException("값이 없어요."));
        System.out.println("value3 = " + value3);

        try{
            String empty3 = optEmpty.orElseThrow(()-> new RuntimeException("없다고요  !!"));
            System.out.println("empty3 = " + empty3); //실행안됨
        }catch(Exception e){
            System.out.println("예외 발생 : " + e.getMessage());
        }

        System.out.println("=== 6. or() ===");
        Optional<String> result1 = optValue.or(() -> Optional.of("Fallback"));
        System.out.println("result1 = " + result1);

        Optional<String> result2 = optEmpty.or(() -> Optional.of("Fallback"));
        System.out.println("result2 = " + result2);
    }

}
