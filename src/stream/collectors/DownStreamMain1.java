package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamMain1 {
    static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 9)
        );

        // 1.학년별로 학생들을 그룹화
        Map<Integer, List<Student>>  collect1_1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,  // 그룹화 기준 학년
                        Collectors.toList() // 다운스트림 : 학생을 리스트로 수집 toList는 생략가능
                ));
        System.out.println("collect1_1 = " + collect1_1);

        // 2.학년별로 학생의 이름을 출력하라.
        Map<Integer, List<String>>  collect2_1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,  // 그룹화 기준 학년
                        Collectors.mapping(Student::getName, // DownStream 1: Student Obj-> Name
                                Collectors.toList()) // DownStream 2 : Name -> List
                ));
        System.out.println("collect2_1 = " + collect2_1);

        // 3. 학년별로 학생수를 출력하라.
        Map<Integer, Long> collect3_1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.counting()
                ));
        System.out.println("collect3_1 = " + collect3_1);

        // 4. 학년별로 학생들으 평균 성적 출력
        Map<Integer, Double> collect4_1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.averagingInt(Student::getScore)
                ));
        System.out.println("collect4_1 = " + collect4_1);
    }
}
