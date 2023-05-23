package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        UniversityInfo universityInfo = UniversityInfo.getInstance();
        universityInfo.readStudents();
        universityInfo.readUniversities();
        List<Student> students = universityInfo.getStudents();
        List<University> universities = universityInfo.getUniversities();
        System.out.println(students);
        System.out.println(universities);

        log.info("Это информационное сообщение!");
        log.error("Это сообщение ошибки");
    }
}