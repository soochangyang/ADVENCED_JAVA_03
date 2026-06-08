package lambda.lambda5.map;

import java.util.List;

public class MapMainV4 {
    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        //문자열을 숫자로 변환
        List<Integer> toNumber = StringToIntegerMapper.map(list, s -> Integer.valueOf(s));
        System.out.println("toNumber = " + toNumber);

        //문자열의 길이
        List<Integer> toLength = StringToIntegerMapper.map(list, s -> s.length());
        System.out.println("toLength = " + toLength);

    }
}
