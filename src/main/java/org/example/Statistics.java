package org.example;

import org.example.enums.StudyProfile;

public class Statistics {
    private StudyProfile studyProfile;
    private float avgExamScore;
    private int studentsByStudyProfile;
    private int universitiesByStudyProfile;
    private String[] universitiesNames;

    void setStudyProfile(StudyProfile profile) {
        this.studyProfile = profile;
    }

    void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    void setStudentsByStudyProfile(int studentsByStudyProfile) {
        this.studentsByStudyProfile = studentsByStudyProfile;
    }

    void setUniversitiesByStudyProfile(int universitiesByStudyProfile) {
        this.universitiesByStudyProfile = universitiesByStudyProfile;
    }

    void setUniversitiesNames(String[] universitiesNames) {
        this.universitiesNames = universitiesNames;
    }

    StudyProfile getStudyProfile() {
        return studyProfile;
    }

    float getAvgExamScore() {
        return avgExamScore;
    }

    int getStudentsByStudyProfile() {
        return studentsByStudyProfile;
    }

    int getUniversitiesByStudyProfile() {
        return universitiesByStudyProfile;
    }

    String[] getUniversitiesNames() {
        return universitiesNames;
    }
}
