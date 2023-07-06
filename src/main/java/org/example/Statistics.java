package org.example;

import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="statisticsEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name="universityProfile")
    private StudyProfile studyProfile;
    @XmlElement(name="avgScore")
    private float avgExamScore;
    @XmlTransient
    private int studentsByStudyProfile;
    @XmlTransient
    private int universitiesByStudyProfile;
    @XmlTransient
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
