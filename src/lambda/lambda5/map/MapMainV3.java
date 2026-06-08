package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV3 {
    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        //문자열을 숫자로 변환
        List<Integer> toNumber = map(list, s -> Integer.valueOf(s));
        System.out.println("toNumber = " + toNumber);

        //문자열의 길이
        List<Integer> toLength = map(list, s -> s.length());
        System.out.println("toLength = " + toLength);

    }

    private static List map(List<String> list, Function<String, Integer> func) {
        List<Integer> ret = new ArrayList<>();
        for (String str : list) {
            ret.add(func.apply(str));
        }
        return ret;
    }




}
