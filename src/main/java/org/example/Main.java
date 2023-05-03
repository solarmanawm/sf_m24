package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
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
        log.info("Это информационное сообщение!");
        log.error("Это сообщение ошибки");
    }
}