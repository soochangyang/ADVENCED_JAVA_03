package methodref;

import java.util.function.BiFunction;

//매계변수가 추가
public class MethodRefEx6 {
    public static void main(String[] args) {
        //4. 임의 객체의 인스턴스 메서드 참조 (특정 타입)
        Person person = new Person("KIM");

        // lambda
        BiFunction<Person, Integer, String> func1 =
                (Person p , Integer number) -> p.introduceWithNumber(number);
        System.out.println("person.introduceWithNumber" + func1.apply(person, 10));

        BiFunction<Person, Integer, String> func2 = Person::introduceWithNumber;
        System.out.println("person.introduceWithNumber" + func2.apply(person, 20));
    }
}
