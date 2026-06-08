package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamLoopMain {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Pear", 90),
                new Student("Peach", 80)
        );

        List<String> result = MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .toList();

        // 외부 반복
        for (String student : result) {
            System.out.println("name : " + student);
        }

        MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .forEach(name -> System.out.println("name : " + name));
    }


}
