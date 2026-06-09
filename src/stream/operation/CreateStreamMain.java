package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamMain {
    static void main(String[] args) {
        System.out.println("1. 컬랙션으로부터 생성 ");
        List<String> list = List.of("a", "b", "c");
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::print);

        System.out.println("\n2. 배열로부터 생성 ");
        String[] arr = {"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(arr);
        stream2.forEach(System.out::print);

        System.out.println("\n3. Stream.of() 사용 ");
        Stream<String> stream3 = Stream.of("a", "b", "c");
        stream3.forEach(System.out::print);

        System.out.println("\n4. 무한 스티림 생성 iterate() 사용하고 limit()로 제어 ");
        // iterate : 초기 값과 다음 값을 만드는 함수를 지정
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        infiniteStream.limit(5).forEach(System.out::println);

        System.out.println("\n5. 무한 스티림 생성 - generate() ");
        // generate: Supplier를 사용 하여 무한 하게 생성
        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.limit(5).forEach(System.out::println);

    }

}
