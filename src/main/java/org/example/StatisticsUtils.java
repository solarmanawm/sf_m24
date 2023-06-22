package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.StudyProfile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class StatisticsUtils {
    private static final Logger log = LogManager.getLogger(StatisticsUtils.class);
    public static ArrayList<Statistics> getStatistics(List<Student> students, List<University> universities) {
        Set<StudyProfile> studyProfileSet = new HashSet<>();

        for (University university : universities) {
            studyProfileSet.add(university.getMainProfile());
        }

        ArrayList<Statistics> statsList = new ArrayList<>();

        for (StudyProfile studyProfile : studyProfileSet) {
            ArrayList<String> universitiesNamesList = new ArrayList<>();
            ArrayList<Integer> studentsByStudyProfileList = new ArrayList<>();
            ArrayList<BigDecimal> avgExamScoreList = new ArrayList<>();

            universities
                    .stream()
                    .filter(university -> university.getMainProfile() == studyProfile)
                    .forEach(university -> {
                        int count = (int) students
                                .stream()
                                .filter(student -> student.getUniversityId().equals(university.getId()))
                                .count();

                        students
                                .stream()
                                .filter(student -> student.getUniversityId().equals(university.getId()))
                                .forEach(student -> avgExamScoreList.add(BigDecimal.valueOf(student.getAvgExamScore())));

                        studentsByStudyProfileList.add(count);
                        universitiesNamesList.add(university.getFullName());
                    });

            String[] universitiesNames = new String[universitiesNamesList.size()];
            universitiesNamesList.toArray(universitiesNames);

            int studentsByStudyProfile = 0;
            for (int count : studentsByStudyProfileList) {
                studentsByStudyProfile += count;
            }

            BigDecimal avgExamScore = BigDecimal.valueOf(0);
            for (BigDecimal score : avgExamScoreList) {
                avgExamScore = avgExamScore.add(score);
            }

            Statistics statistics = new Statistics();
            statistics.setUniversitiesNames(universitiesNames);
            statistics.setStudyProfile(studyProfile);
            statistics.setStudentsByStudyProfile(studentsByStudyProfile);
            statistics.setAvgExamScore(avgExamScore.setScale(2, RoundingMode.CEILING).floatValue());
            statistics.setUniversitiesByStudyProfile(universitiesNames.length);

            statsList.add(statistics);

            log.info("Собрана статистика по университетам с профилем " + studyProfile);
        }

        return statsList;
    }
}
