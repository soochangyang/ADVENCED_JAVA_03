package functional;

import java.util.ArrayList;
import java.util.List;

public class SideEffectListMain {
    static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("banana");

        System.out.println("before list1 = " + list1);
        changeList1(list1);
        System.out.println("after list1 = " + list1);

        List<String> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("banana");
        System.out.println("before list2 = " + list2);
        List<String> result = changeList2(list2);
        System.out.println("after list2 = " + list2);
        System.out.println("result = " + result);
    }

    private static List<String> changeList2(List<String> list) {
        // 새로운 리스트를 생성해서 반환함으로 원본 리스트를 변경하지 않는다.
        // 함수형 프로그래밍에서는 이과 같은 방식을 권장한다.
        // ex) Stream 에서는 원본은 절대 변경되지 않는다.
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(s + "_complete");
        }
        return newList;
    }

    private static void changeList1(List<String> list1) {
        // 데이터를 직접 변경하여 부수 효과 일으킴
        for (int i = 0; i < list1.size(); i++) {
            list1.set(i, list1.get(i) + "_complete");
        }
    }
}
