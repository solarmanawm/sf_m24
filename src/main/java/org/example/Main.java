package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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

//        for (StudentComparison comparison : StudentComparison.values()) {
//            System.out.println();
//            System.out.println("SORT BY: " + comparison.getName());
//            StudentComparatorInterface comparator = ComparatorFactory.getStudentComparator(comparison);
//            students.stream().sorted(comparator).forEach(System.out::print);
//        }
//
//        for (UniversityComparison comparison : UniversityComparison.values()) {
//            System.out.println();
//            System.out.println("SORT BY: " + comparison.getName());
//            UniversityComparatorInterface comparator = ComparatorFactory.getUniversityComparator(comparison);
//            universities.stream().sorted(comparator).forEach(System.out::print);
//        }

//        log.info("Это информационное сообщение!");
//        log.error("Это сообщение ошибки");

        JsonUtil jsonUtil = JsonUtil.getInstance();

        String studentsJson = jsonUtil.serialize(students);
        String universitiesJson = jsonUtil.serialize(universities);

        System.out.println(studentsJson);
        System.out.println(universitiesJson);

        List<Student> newStudents = jsonUtil.deserialize(studentsJson);
        List<University> newUniversities = jsonUtil.deserialize(universitiesJson);

        System.out.println();
        System.out.println("Is the same quantity of students: " + (students.size() == newStudents.size()));
        System.out.println("Is the same quantity of universities: " + (universities.size() == newUniversities.size()));

        students.stream()
                .map(jsonUtil::serialize)
                .peek(ss -> {
                    System.out.println();
                    System.out.println();
                    System.out.println("Serialized student: ");
                    System.out.println();
                    System.out.println(ss);
                })
                .map(jsonUtil::deserialize)
                .forEach(ds -> {
                    System.out.println();
                    System.out.println("Deserialized student: ");
                    System.out.println(ds);
                });

        universities.stream()
                .map(jsonUtil::serialize)
                .peek(su -> {
                    System.out.println();
                    System.out.println();
                    System.out.println("Serialized university: ");
                    System.out.println();
                    System.out.println(su);
                })
                .map(jsonUtil::deserialize)
                .forEach(du -> {
                    System.out.println();
                    System.out.println("Deserialized university: ");
                    System.out.println(du);
                });

        String filePath = "file.xlsx";
        XlsWriter xlsWriter = new XlsWriter();
        ArrayList<Statistics> list = StatisticsUtils.getStatistics(students, universities);
        xlsWriter.generateTableAndWriteToFile(list, filePath);

        StatisticalInfo statisticalInfo = new StatisticalInfo();
        statisticalInfo.setStatisticsList(list);

        UniversitiesInfo universitiesInfo = new UniversitiesInfo();
        universitiesInfo.setUniversityList(universities);

        StudentsInfo studentsInfo = new StudentsInfo();
        studentsInfo.setStudentList(students);

        ZoneId z = ZoneId.of("Europe/Moscow");
        LocalDateTime today = LocalDateTime.now(z);

        Structure structure = new Structure();
        structure.setUniversitiesInfo(universitiesInfo);
        structure.setStudentsInfo(studentsInfo);
        structure.setStatisticalInfo(statisticalInfo);
        structure.setDate(today.toString());

        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.write(structure);

        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.write(structure);
    }
}
