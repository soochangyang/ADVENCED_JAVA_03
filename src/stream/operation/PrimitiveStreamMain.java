package stream.operation;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {
    static void main(String[] args) {
        // 기본형 특화 스트림 생성 (IntStream, LongStream, DoubleStream)
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        stream.forEach(i-> System.out.print(i + " "));
        System.out.println();

        // 범위 생성 메서드 (IntStream, LongStream)
        IntStream range1 = IntStream.range(1, 6);
        IntStream range2 = IntStream.rangeClosed(1, 5);
        range1.forEach(i -> System.out.print(i + " ")   );
        System.out.println();
        range2.forEach(i -> System.out.print(i + " ")   );
        System.out.println();

        // 1. 통계 관련 메서드 (sum, average, max, min, count)
        int sum = IntStream.range(1, 6).sum();
        System.out.println("sum = " + sum);
        System.out.println();

        // average
        //OptionalDouble average = IntStream.range(1, 6).average();
        double average = IntStream.range(1, 6).average().getAsDouble();
        System.out.println("average = "+ average);

        // max
        OptionalInt max = IntStream.range(1, 6).max();
        System.out.println("max = " + max);

        // min
        OptionalInt min = IntStream.range(3, 8).min();
        System.out.println("min = " + min);

        //count
        long count = IntStream.range(1, 6).count();
        System.out.println("count = " + count);

        // summaryStatistics(): 모든 통계 정보
        IntSummaryStatistics stats = IntStream.range(1, 10).summaryStatistics();
        System.out.println("합    계 : " + stats.getSum());
        System.out.println("평    균 : " + stats.getAverage());
        System.out.println("최 대 값 : " + stats.getMax());
        System.out.println("최 소 값 : " + stats.getMin());
        System.out.println("개    수 : " + stats.getCount());


        // 2. 타입 변환 메서드
        // IntStream -> LongStream
        LongStream longStream = IntStream.range(1, 5).asLongStream();
        // IntStream -> DoubleStream
        DoubleStream doubleStream = IntStream.range(1, 5).asDoubleStream();

        // IntStream -> Stream<Integer>
        Stream<Integer> boxedStream = IntStream.range(1, 5).boxed();
        System.out.println("boxedStream : " + boxedStream);

        // 3. 기본형 특화 매핑
        // int -> long 변환 매핑
        LongStream mappedLong = IntStream.range(1, 5)
                .mapToLong(i -> i * 10L);

        // int -> double
        DoubleStream mappedDouble = IntStream.range(1, 5)
                .mapToDouble(d -> d * 1.5);

        // int -> 개체 변환 매핑
        Stream<String> mappedObj = IntStream.range(1, 5)
                .mapToObj(i -> "Number : " + i);

        // 4. 객체 스트림 -> 기본형 특화 스트림으로 매핑
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.mapToInt(i -> i);

        // 5. 객체 스트림 -> 기본형 특화 스트림으로 매핑
        int result = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(i -> i)
                .sum();
        System.out.println("result = " + result);


    }
}
