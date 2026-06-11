package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartMain2 {

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
        //String name = findNameById(id).orElse("UNKNOWN");

        Optional<String> optName = findNameById(id);
        String name = optName.orElse("UNKNOWN");

        System.out.println(id + " : "+ name.toUpperCase());

    }

    static Optional<String> findNameById(Long id) {
        String findName = map.get(id);
        Optional<String> optName = Optional.ofNullable(findName);
        return optName;
    }
}
