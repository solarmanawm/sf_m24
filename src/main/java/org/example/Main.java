package org.example;

public class Main {
    public static void main(String[] args) {
        University university = new University(
                "1",
                "Московский государственный университет",
                "МГУ",
                1755,
                StudyProfile.MATH
        );
        Student student = new Student(
                "Серафим Соколов",
                "1",
                1,
                4.57f
        );
        System.out.println(university);
        System.out.println(student);
    }
}