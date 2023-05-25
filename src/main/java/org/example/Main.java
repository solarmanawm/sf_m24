package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.StudentComparison;
import org.example.enums.UniversityComparison;
import org.example.interfaces.StudentComparatorInterface;
import org.example.interfaces.UniversityComparatorInterface;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        UniversityInfo universityInfo = UniversityInfo.getInstance();
        universityInfo.readStudents();
        universityInfo.readUniversities();

        List<Student> students = universityInfo.getStudents();
        List<University> universities = universityInfo.getUniversities();

//        StudentComparatorInterface studentsByCourseNumberComparator = ComparatorFactory.getStudentComparator(StudentComparison.COURSE_NUMBER);
//        StudentComparatorInterface studentsByAvgExamScoreComparator = ComparatorFactory.getStudentComparator(StudentComparison.AVG_EXAM);
//        StudentComparatorInterface studentsByUniversityIdComparator = ComparatorFactory.getStudentComparator(StudentComparison.UNIVERSITY_ID);
//        StudentComparatorInterface studentsByFullNameComparator = ComparatorFactory.getStudentComparator(StudentComparison.FULL_NAME);
//
//        UniversityComparatorInterface universityByFullNameComparator = ComparatorFactory.getUniversityComparator(UniversityComparison.FULL_NAME);
//        UniversityComparatorInterface universityByShortNameComparator = ComparatorFactory.getUniversityComparator(UniversityComparison.SHORT_NAME);
//        UniversityComparatorInterface universityByIdComparator = ComparatorFactory.getUniversityComparator(UniversityComparison.ID);
//        UniversityComparatorInterface universityByMainProfileComparator = ComparatorFactory.getUniversityComparator(UniversityComparison.MAIN_PROFILE);
//        UniversityComparatorInterface universityByYearOfFoundationComparator = ComparatorFactory.getUniversityComparator(UniversityComparison.YEAR_OF_FOUNDATION);

//        students.stream().sorted(studentsByCourseNumberComparator).forEach(System.out::print);
//        students.stream().sorted(studentsByAvgExamScoreComparator).forEach(System.out::print);
//        students.stream().sorted(studentsByUniversityIdComparator).forEach(System.out::print);
//        students.stream().sorted(studentsByFullNameComparator).forEach(System.out::print);
//
//        universities.stream().sorted(universityByFullNameComparator).forEach(System.out::print);
//        universities.stream().sorted(universityByShortNameComparator).forEach(System.out::print);
//        universities.stream().sorted(universityByIdComparator).forEach(System.out::print);
//        universities.stream().sorted(universityByMainProfileComparator).forEach(System.out::print);
//        universities.stream().sorted(universityByYearOfFoundationComparator).forEach(System.out::print);

        for (StudentComparison comparison : StudentComparison.values()) {
            System.out.println();
            System.out.println("SORT BY: " + comparison.getName());
            StudentComparatorInterface comparator = ComparatorFactory.getStudentComparator(comparison);
            students.stream().sorted(comparator).forEach(System.out::print);
        }

        for (UniversityComparison comparison : UniversityComparison.values()) {
            System.out.println();
            System.out.println("SORT BY: " + comparison.getName());
            UniversityComparatorInterface comparator = ComparatorFactory.getUniversityComparator(comparison);
            universities.stream().sorted(comparator).forEach(System.out::print);
        }

        log.info("Это информационное сообщение!");
        log.error("Это сообщение ошибки");
    }
}
