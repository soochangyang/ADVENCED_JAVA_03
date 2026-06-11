package optional;

import java.util.Optional;

public class OptionalProcessingMain {

    static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        // 값이 존재하면 Consumer 실행, 없으면 아무 일도 하지 않음
        System.out.println("=== 1. ifPresent() ===");
        optValue.ifPresent(v -> System.out.println("optValue 값: " + v));
        optValue.ifPresent(System.out::println);
        optEmpty.ifPresent(v -> System.out.println("optEmpty 값: " + v)); // 실행 안됨
        optEmpty.ifPresent(System.out::println);

        //값이 있음 Consumer 실행, 없으면 Runnable실행
        System.out.println("=== 1. ifPresentOrElse() ===");
        optValue.ifPresentOrElse(s -> System.out.println("optValue 값 : " + s),
                () -> System.out.println("optValue 값 없음"));
        optEmpty.ifPresentOrElse(s -> System.out.println("optEmpty 값 : " + s),
                () -> System.out.println("optEmpty 값 없음"));

        // 값이 있으면 Function 적용 후 Optional로 반환, 없으면 Optional.empty()
        System.out.println("=== 3. map() ===");
        Optional<Integer> lengthOpt1 = optValue.map(String::length);
        System.out.println("optValue.map(String::length) = " + lengthOpt1);
        Optional<Integer> lengthOpt2 = optEmpty.map(String::length);
        System.out.println("optEmpty.map(String::length) = " + lengthOpt2);

        // map()과 유사하나, 이미 Optional을 반환하는 경우 중첩을 제거
        System.out.println("=== 4. flatMap() ===");
        System.out.println("[map]");
        Optional<Optional<String>> netstedOpt = optValue.map(s -> Optional.of(s));
        System.out.println("optValue = " + optValue);
        System.out.println("netstedOpte = " + netstedOpt);
        System.out.println("[flatMap]");
        Optional<String> flatMapOpt = optValue.flatMap(s -> Optional.of(s));
        System.out.println("flatMapOpt = " + flatMapOpt);

        // 값이 있고 조건을 만족하면 그값을 그대로, 불만족시 Optiona.empty()
        System.out.println("=== 5. flatMap() ===");
        Optional<String> filtered1 = optValue.filter(s -> s.startsWith("H"));
        Optional<String> filtered2 = optValue.filter(s -> s.startsWith("X"));

        System.out.println("filtered1 = " + filtered1); // Optional[Hello]
        System.out.println("filtered2 = " + filtered2); // Optional.empty

        System.out.println("=== 6. stream() ===");
        // 값이 있으면 단일 요소 스트림, 없으면 빈 스트림
        optValue.stream()
                .forEach(s -> System.out.println("optVal = " + s));
        // 값이 없으므로 실행 안 됨
        optEmpty.stream()
                .forEach(s -> System.out.println("optEmpty = " + s));

    }
}
