package functional;

import java.util.List;

public class ImmutableMain3 {
    static void main(String[] args) {
        ImmutablePerson m1 = new ImmutablePerson("Kim", 10);
        ImmutablePerson m2 = new ImmutablePerson("Lee", 10);

        List<ImmutablePerson> originList = List.of(m1, m2);
        System.out.println("OriginList: " + originList);

        //Stream에서 setAge를 사용하면서 originList의 데이터까지 변경되어 버렸다.
        List<ImmutablePerson> resultList = originList.stream()
                .map(p -> p.withAge(p.getAge() + 1))
                .toList();

        System.out.println("=== 실행 후 ===");
        System.out.println("originList: " + originList);
        System.out.println("resultList: " + resultList);
    }
}
