package methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefEx4 {
    static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("KIM"),
                new Person("PARK"),
                new Person("LEE")
        );

        List<String> result1 = mapPersonToString(personList, (Person p) -> p.introduce());
        List<String> result2 = mapPersonToString(personList, Person::introduce);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);


        List<String> upperResult1 = mapStringToString(result1, s -> s.toUpperCase());
        List<String> upperResult2 = mapStringToString(result1, String::toLowerCase);
        System.out.println(upperResult1);
        System.out.println(upperResult2);


    }

    static List<String> mapPersonToString(List<Person> personList, Function<Person, String> func){
        List<String> result = new ArrayList<>();
        for (Person p : personList){
            String applied = func.apply(p);
            result.add(applied);
        }
        return result;
    }

    static List<String> mapStringToString(List<String> strings, Function<String, String> func){
        List<String> result = new ArrayList<>();
        for (String s : strings){
            String applied = func.apply(s);
            result.add(applied);
        }
        return result;
    }
}
