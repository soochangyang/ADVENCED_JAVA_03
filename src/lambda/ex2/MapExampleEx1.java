package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class MapExampleEx1 {

    public static List<String> map(List<String> list, StringFunction func){
        List<String> result = new ArrayList<>();
        for(String s: list){
            result.add(func.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트 : " + words);
        List<String> upperList = map(words, s -> s.toUpperCase());
        System.out.println(upperList);

        List<String> decoList = map(words, s -> "***".concat(s).concat("***"));
        System.out.println(decoList);
    }



}
