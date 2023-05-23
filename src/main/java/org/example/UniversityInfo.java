package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UniversityInfo {
    private static UniversityInfo _instance = null;

    public static UniversityInfo getInstance() throws IOException {
        if (_instance == null) {
            _instance = new UniversityInfo();
        }

        return _instance;
    }
    private final Workbook workbook;
    private final List<Student> students = new ArrayList<>();
    private final List<University> universities = new ArrayList<>();

    UniversityInfo() throws IOException {
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        FileInputStream fileInputStream = new FileInputStream(path + "\\src\\main\\resources\\universityInfo.xlsx");
        this.workbook = new XSSFWorkbook(fileInputStream);
    }

    void readStudents() {
        Sheet studentSheet = workbook.getSheet("Студенты");
        Iterator<Row> iterator = studentSheet.iterator();
        iterator.next();

        while (iterator.hasNext()) {
            Row cells = iterator.next();
            String universityId = cells.getCell(0).getStringCellValue();
            String fullName = cells.getCell(1).getStringCellValue();
            int courseNumber = (int) cells.getCell(2).getNumericCellValue();
            float avgExamScore = (float) cells.getCell(3).getNumericCellValue();
            students.add(new Student(fullName, universityId, courseNumber, avgExamScore));
        }
    }

    List<Student> getStudents() {
        return students;
    }

    void readUniversities() {
        Sheet universitySheet = workbook.getSheet("Университеты");
        Iterator<Row> iterator = universitySheet.iterator();
        iterator.next();

        while (iterator.hasNext()) {
            Row cells = iterator.next();
            String universityId = cells.getCell(0).getStringCellValue();
            String fullName = cells.getCell(1).getStringCellValue();
            String shortName = cells.getCell(2).getStringCellValue();
            int yearOfFoundation = (int) cells.getCell(3).getNumericCellValue();
            String mainProfile = cells.getCell(4).getStringCellValue();
            universities.add(new University(universityId, fullName, shortName, yearOfFoundation, StudyProfile.valueOf(mainProfile)));
        }
    }

    List<University> getUniversities() {
        return universities;
    }
}
