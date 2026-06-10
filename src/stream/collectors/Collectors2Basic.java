package stream.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class Collectors2Basic {


    static void main(String[] args) {

        //inner Class
        class Student {
            int grade ;
            String name;
            int score;

            public Student(int grade, String name, int score) {
                this.grade = grade;
                this.name = name;
                this.score = score;
            }

            public int getGrade() {
                return grade;
            }

            public String getName() {
                return name;
            }

            public int getScore() {
                return score;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "grade=" + grade +
                        ", name='" + name + '\'' +
                        ", score=" + score +
                        '}';
            }
        }

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            students.add(new Student(1,"길동"+i,i+1));
            if (i % 2 == 0) students.add(new Student(2,"달동"+i,i+1));
            if (i % 3 == 0) students.add(new Student(3,"선동"+i,i+1));
        }

        // toList
        List<String> seniorStudents = students.stream()
                .filter(x -> x.getGrade() == 3)
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("seniorStudents = " + seniorStudents);


        // Grade Grouping 학년별 학생목록
        Map<Integer, List<Student>> studentsByGreade = students.stream()
                        .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("studentsByGreade = " + studentsByGreade);


        // 학년별 점수 통계
        //IntSummaryStatistics stats
        Map<Integer, IntSummaryStatistics> staticsByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.summarizingInt(Student::getScore)
                ));
        System.out.println("staticsByGrade = " + staticsByGrade);

        //TopScoreByGrade
        Map<Integer, Optional<Student>> topScoreByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.maxBy(Comparator.comparingInt(Student::getScore))
                        ));
        topScoreByGrade.get(1).ifPresent(x-> System.out.println("1학년 최우수: "+ x.getName() + " | "+ x.getScore() ));
        topScoreByGrade.get(2).ifPresent(x-> System.out.println("2학년 최우수: "+ x.getName() + " | "+ x.getScore() ));
        topScoreByGrade.get(3).ifPresent(x-> System.out.println("3학년 최우수: "+ x.getName() + " | "+ x.getScore() ));

        /*System.out.println("topScoreByGrade = " + topScoreByGrade.get(1).ifPresent(x -> x));
        System.out.println("topScoreByGrade = " + topScoreByGrade.get(2));
        System.out.println("topScoreByGrade = " + topScoreByGrade.get(3));*/
    }




}

