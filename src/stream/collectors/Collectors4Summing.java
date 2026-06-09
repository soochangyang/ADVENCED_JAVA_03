package stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4Summing {
    public static void main(String[] args) {
        // 다운스트림 콜렉터에서 유용하게 사용
        Long count1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .collect(Collectors.counting());
        System.out.println("count1 = " + count1);

        Long count2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .count();
        System.out.println("count2 = " + count2);

        //Average
        Double average1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .collect(Collectors.averagingInt(i -> i));
        System.out.println("average1 = " + average1);

        // Stream -> 기본형 특화 스트림으로 변환
        double average2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .mapToInt(i -> i)
                .average().getAsDouble();
        System.out.println("average2 = " + average2);

        // 기본형 특화 스트림 사용
        double average3 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .average().getAsDouble();
        System.out.println("average3 = " + average3);

        // 통계
        IntSummaryStatistics stats = Stream.of("Apple", "Banana", "Tomoto")
                .collect(Collectors.summarizingInt(String::length));
        System.out.println("Count = " + stats.getCount());
        System.out.println("Average = " + stats.getAverage());
        System.out.println("Sum = " + stats.getSum());
        System.out.println("Min = " + stats.getMin());
        System.out.println("Max = " + stats.getMax());
        System.out.println("Min = " + stats.getMin());
        System.out.println("Max = " + stats.getMax());
    }
}
