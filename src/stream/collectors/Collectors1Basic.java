package stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
//가능하면 Collectors 는 static import 로 하자 (프로그램 만들때)
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors1Basic {
    public static void main(String[] args) {
        //Collectors.toList (+ Java 16)
        List<String> list = Stream.of("Java", "Srping", "JPA")
                .collect(Collectors.toList()); // 수정가능한 리스트를 반환
        list.add("hello");
        System.out.println("list = " + list);

        //수정불가능한 리스트 반환
        List<String> unModifiableList = Stream.of("Java", "Srping", "JPA")
                .collect(Collectors.toUnmodifiableList());
        //UnsupportedOperationException 수정이 불가 해서 오류발생함....
        //unModifiableList.add("hello");
        System.out.println("unModifiableList = " + unModifiableList);

        Set<Integer> collectSet = Stream.of(1, 2, 2, 3, 3, 3)
                .collect(Collectors.toSet());
        System.out.println("collectSet = " + collectSet);

        // 타입 지정
        TreeSet<Integer> treeSet = Stream.of(3, 4, 5, 2, 1)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet = " + treeSet);


    }
}
