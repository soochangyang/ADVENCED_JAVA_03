package stream.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapVsFlatMapMain {
    static void main(String[] args) {
        List<List<Integer>> outerList = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );

        //for
        ArrayList<Integer> forResult = new ArrayList<>();
        for (List<Integer> list : outerList){
            for(Integer item: list){
                forResult.add(item);
            }
        }
        System.out.println("outerList = "+outerList);
        System.out.println("forResult = "+forResult);

        // map
        List<Stream<Integer>> mapResult = outerList.stream()
                .map(list -> list.stream())
                .toList();
        System.out.println("mapResult = " + mapResult);

        // flatMap
        List<Integer> flatMapResult = outerList.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println("flatMapResult = " + flatMapResult);


    }
}
