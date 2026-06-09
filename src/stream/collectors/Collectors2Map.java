package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {
    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        // KeyMapper
                        name -> name,
                        // ValueMapper
                        name -> name.length()
                ));
        System.out.println("map1 = " + map1);

        // 중목된 키가 발생할
/*        Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        // KeyMapper
                        name -> name,
                        // ValueMapper
                        name -> name.length()
                ));
        System.out.println("map2 = " + map2);*/

        // 중목된 키가 발생할경우 대안
        Map<String, Integer> map3 = Stream.of("Apple", "Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        // KeyMapper
                        name -> name,
                        // ValueMapper
                        name -> name.length(),
                        // 중복될 경우 기존값 + 새값
                        (oldVal, newVal) -> oldVal + newVal
                ));
        System.out.println("map3 = " + map3);

        // Map의 타입을 지정
        Map<String, Integer> map4 = Stream.of("Apple", "Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        // KeyMapper
                        name -> name,
                        // ValueMapper
                        name -> name.length(),
                        // 중복될 경우 기존값 + 새값
                        (oldVal, newVal) -> oldVal + newVal,
                        // 멥의 타입을 지정  supplier functional interface 제공
                        LinkedHashMap::new
                ));
        System.out.println("map4 = " + map4.getClass());
    }
}
