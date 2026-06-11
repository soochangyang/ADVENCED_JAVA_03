package optional;

import java.util.HashMap;
import java.util.Map;

public class OptionalStartMain1 {

    private static final Map<Long, String> map = new HashMap<>();

    // init map when class Loading
    static {
        map.put(1L, "Kim");
        map.put(2l, "Seo");
    }

    static void main(String[] args) {
        findAndPrint(1L);
        findAndPrint(3L);
    }

    // 이름이 있으면 이름을 대문자로 출력, 없으면 "UNKNOW" 출력
    static void findAndPrint(Long id){
        String name = findNameById(id);
        // null point exception 유발
        // System.out.println("name = " + name.toUpperCase());

        // null check
        if (name != null) {
            System.out.println(id + " : "+ name.toUpperCase());
        } else {
            System.out.println(id + " : UNKNOWN");

        }
    }
    static String findNameById(Long id) {
        return map.get(id);
    }
}
