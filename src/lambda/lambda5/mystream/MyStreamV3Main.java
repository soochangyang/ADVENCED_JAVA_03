package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamV3Main {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Pear", 90),
                new Student("Peach", 80)
        );

        // score >= 80
        List<String> result1 = ex1(students);
        System.out.println("result1 = " + result1);

        // 점수가 80점 이상, 이름의 길이가 5자인 학생의 이름을 대문자로
        List<String> result2 = ex2(students);
        System.out.println("result2 = " + result2);
    }

    public static List<String> ex1(List<Student> students) {
        return MyStreamV3.of(students).filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .toList();
    }

    public static List<String> ex2(List<Student> students) {
        return MyStreamV3.of(students).filter(s -> s.getScore() >= 80)
                .filter(s -> s.getName().length() == 5)
                .map(s -> s.getName().toUpperCase())
                .toList();
    }
}
