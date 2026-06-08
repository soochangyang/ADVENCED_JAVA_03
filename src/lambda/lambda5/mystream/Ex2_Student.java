package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex2_Student {

    public static void main(String[] args) {
        // 점수가 80점 이상인 학생의 이름을 추출
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Cherry", 40)
        );

        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);

        List<String> lambdaResult = lambda1(students);
        System.out.println("lambdaResult = " + directResult);
    }

    public static List<String> direct(List<Student> students) {
        List<String> directResult = new ArrayList<>();
        for (Student student : students) {
            if(student.getScore() >= 80){
                directResult.add(student.getName());
            }
        }
        return directResult;
    }

    public static List<String> lambda1(List<Student> students) {
       List<Student> list = GenericFilter.filter(students, student -> student.getScore() >= 80);
       List<String> lambdaResult = GenericMapper.map(list, (student) -> student.getName());
       return lambdaResult;
    }
}
