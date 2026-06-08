package methodref;

import java.util.function.Function;

public class MethodRefEx3 {
    public static void main(String[] args){
        // 4. 임의 객체의인스턴스 메서드 참조 (특정 타입의)
        Person person1 = new Person("KIM");
        Person person2 = new Person("PARK");
        Person person3 = new Person("LEE");

        //lambda
        Function<Person, String> func1= (Person person) -> person.introduce(); //특정객체
        System.out.println("person1.introduce = " + func1.apply(person1));
        System.out.println("person2.introduce = " + func1.apply(person2));
        System.out.println("person3.introduce = " + func1.apply(person3));

        // 메서드 참조, 타입이 첫 번째 매개변수가 됨,
        // 그리고 첫 번째 매개변수의 메서드를 호출, 나머지는 순서대로 매개변수에 전달
        //Reference to an instance method of an arbitray object of a particular type
        Function<Person, String> func2 = Person::introduce; // 타입::인스턴스메서드 -임의객체
        System.out.println("person1.introduce = " + func2.apply(person1));
        System.out.println("person2.introduce = " + func2.apply(person2));
        System.out.println("person3.introduce = " + func2.apply(person3));
    }
}
