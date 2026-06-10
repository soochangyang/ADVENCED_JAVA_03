package stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DownStreamMain2 {
    static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 9)
        );

        // 1. 학년별 학생들을 그룹화 해라.
        //Map<Integer, List<Student>>
        Map<Integer, List<Student>> collect1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade
                ));
        System.out.println("collect 1 = " + collect1);

        // 2. 학년별로 가장 점수가 높은 학생을 구하고 reducing를 사용
        Map<Integer, Optional<Student>> collect_2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.reducing(
                                (s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2
                        )
                ));
        System.out.println("collect 2 = " + collect_2);

        // 3. 학년별로 가장 점수가 높은 학생을 구하고 maxBy를 사용
        Map<Integer, Optional<Student>> collect3 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        //Collectors.maxBy((s1, s2) -> s1.getScore() > s2.getScore() ? 1 : -1)
                        Collectors.maxBy(Comparator.comparingInt(Student::getScore))
                ));
        System.out.println("collect 3 = " + collect3);
        //collect 3 = {1=Optional[Student{name='Kim', grade=1, score=85}], 2=Optional[Student{name='Han', grade=2, score=90}], 3=Optional[Student{name='Hoon', grade=3, score=90}]}
        //collect 3 = {1=Optional[Student{name='Kim', grade=1, score=85}], 2=Optional[Student{name='Han', grade=2, score=90}], 3=Optional[Student{name='Hoon', grade=3, score=90}]}
    }
}
