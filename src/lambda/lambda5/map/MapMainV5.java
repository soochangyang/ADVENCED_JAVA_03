package lambda.lambda5.map;

import java.util.List;

public class MapMainV5 {
    public static void main(String[] args) {
        List<String> fluits = List.of("apple", "banana", "orange", "melon", "strawberry", "persipmon");

        // String -> String
        List<String> upperFluits = GenericMapper.map(fluits, s -> s.toUpperCase());
        System.out.println(upperFluits);

        // String -> Integer
        List<Integer> lengthFruits = GenericMapper.map(fluits, s -> s.length());
        System.out.println(lengthFruits);

        // Integer -> String
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strings = GenericMapper.map(integers, i -> "*".repeat(i));
        System.out.println(strings);

    }
}
