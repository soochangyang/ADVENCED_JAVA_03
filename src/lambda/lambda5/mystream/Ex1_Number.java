package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex1_Number{
    public static void main(String[] args) {
        //짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> directResult = direct(list);
        System.out.println(directResult);

        List<Integer> lambda1Result = lambda1(list);
        System.out.println(lambda1Result);

    }

    public static List<Integer> direct(List<Integer> list){
        List<Integer> directResult = new ArrayList<>();
        for(int myNum : list){
            if (myNum % 2 == 0){
                directResult.add(myNum * 2);
            }
        };
        return directResult;
    }

    public static List<Integer> lambda1(List<Integer> list){
        return GenericMapper.map(GenericFilter.filter(list, myNum -> myNum % 2 == 0), myNum -> myNum * 2);
    }

}
