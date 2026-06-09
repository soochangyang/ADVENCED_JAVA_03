package stream.basic;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain3 {
    static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 Star ==");
        Integer result = MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + "  -> " + mapped);
                    return mapped;
                })
                .getFirst();
        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 End ==");
    }

    // Lazy Evaluation 이란
    // Intermediate Operation (중간 연산 ex: filter, map) 들은 terminal operation(최종연산: ex)toList, forEach, findFirst)이 호출 되기 전까지 실행 되지 않는다.
    // 이를 Short-circuit 단축 평가 이라한다 (findFirst, anyMatch, limit을 사용하면 불필요한 연산을 최소화 한다)
    private static void ex2(List<Integer> data) {
        System.out.println("== Sream API Start ==");
        Integer result = data.stream()
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + "  -> " + mapped);
                    return mapped;
                })
                .findFirst().get();
        System.out.println("result = " + result);
        System.out.println("== Sream API End ==");
    }
}
