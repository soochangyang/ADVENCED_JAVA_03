package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class MapExampleEx2 {

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
        List<String> largeStrings = map(words, new StringFunction() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });
        System.out.println(largeStrings);

        List<String> appendStrings = map(words, new StringFunction() {
            @Override
            public String apply(String s) {
                return "***".concat(s).concat("***");
            }
        });
        System.out.println(appendStrings);
    }



}
