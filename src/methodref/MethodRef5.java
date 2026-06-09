package methodref;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class MethodRef5 {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("KIM"),
                new Person("PARK"),
                new Person("LEE")
        );

        List<String> result1 = MyStreamV3.of(personList)
                .map(person -> person.introduce())
                .map(str -> str.toUpperCase())
                .toList();

        List<String> result2 = MyStreamV3.of(personList)
                .map(Person::introduce)
                .map(String::toUpperCase)
                .toList();

        System.out.println("result1 = "+result1);
        System.out.println("result2 = "+result2);
    }

}
