package stream.start;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class StreamStartMain {

    static void main(String[] args) {
        List<String> names = List.of("Apple", "Banana", "Berry", "Tomato");

        // "B" 로 시작하는 이름만 필터 후 대문자로 바꾸서 리스트 수집
        Stream<String> stream = names.stream();
        List<String> result = stream.filter(name -> name.startsWith("B"))
                .map(s -> s.toUpperCase())
                .toList();

        System.out.println("=== 외부 반복 ===");
        for (String s : result) {
            System.out.println(s);
        }

        System.out.println("=== forEach, 내부 반복 ===");
        names.stream().filter(s -> s.startsWith("B"))
                .map(s->s.toUpperCase())
                .forEach(System.out::println);

        System.out.println("=== Method reference ===");
        names.stream().filter(name -> name.startsWith("B"))
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println("=== All ===");
        names.forEach(s -> System.out.println(s));


        System.out.println("=== student test ===");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kang", 100));
        students.add(new Student("Han", 90));
        students.add(new Student("Kim", 80));
        students.add(new Student("Yun", 70));

        students.forEach(s -> System.out.println(s.getName()+ ": " + s.getScore()));

        System.out.println("=== student filter test ===");
        students.stream().filter(s -> s.getScore() > 70)
                        .forEach(s -> System.out.println(s.getName().toUpperCase() +" : "+s.getScore()));

        System.out.println("=== student filter & return test ===");
        List<Student> goodStudents = students.stream().filter(s -> s.getScore() > 70).toList();
        goodStudents.forEach(System.out::println);

    }

    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName(){
            return this.name;
        }

        public int getScore(){
            return this.score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
