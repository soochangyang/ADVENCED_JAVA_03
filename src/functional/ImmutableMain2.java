package functional;

import java.util.ArrayList;
import java.util.List;

public class ImmutableMain2 {
    static void main(String[] args) {
        MutablePerson m1 = new MutablePerson("Kim", 10);
        MutablePerson m2 = new MutablePerson("Lee", 10);

        List<MutablePerson> originList = List.of(m1, m2);
        System.out.println("OriginList: " + originList);

        //Stream에서 setAge를 사용하면서 originList의 데이터까지 변경되어 버렸다.
        List<MutablePerson> resultList = originList.stream()
                .map(p -> {
                    p.setAge(p.getAge() + 1);
                    return p;
                })
                .toList();

        System.out.println("=== 실행 후 ===");
        System.out.println("originList: " + originList);
        System.out.println("resultList: " + resultList);
    }
}
