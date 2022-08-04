package Lesson_9;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainClass {
    static class Student{
        enum Course{
            Java, Linux, HTML_CSS, Web_Security;
        }
        private String name;
        private Integer age;

        private Course course;

        public Student(String name, Integer age, Course course) {
            this.name = name;
            this.age = age;
            this.course = course;
        }

        public String getName() {
            return name;
        }

        public Integer getAge(){
            return age;
        }

        public Course getCourse(){
            return course;
        }

    }
    private static List<Student> getList() {
        List<Student> students = new ArrayList<>();
        Faker faker = new Faker();
        Random random = new Random(40);
        Random randomCourse = new Random();
        for (int i = 0; i < 10; i++) {

        Student student = new Student(faker.name().fullName(),random.nextInt(10),
                Student.Course.values()[randomCourse.nextInt(2)]);
                students.add(student);
    }

        return students;
    }
    public static void main(String[] args) {

        List<Student> studentList = getList();


//        1 задание
        studentList.stream().map(student -> student.course.toString()).forEach(System.out::println);

//        2 задание
        studentList.stream().map(student -> student.getCourse()).collect(Collectors.toList()).forEach(System.out::println);

//        3 задание
        studentList.stream().filter(student -> student.course == Student.Course.Java).forEach(System.out::println);

    }
}
