package org.example;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name="studentEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @SerializedName("studentName")
    @XmlElement(name="studentName")
    private String fullName;
    @SerializedName("studentUniversityId")
    @XmlElement(name="universityId")
    private String universityId;
    @SerializedName("studentCourseNumber")
    @XmlTransient
    private int currentCourseNumber;
    @SerializedName("studentAvgExamScore")
    @XmlElement(name="avgScore")
    private float avgExamScore;
    private Student() {}

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public String toString() {
        System.out.println();
        System.out.println("-----------------------");

        return "\nStudent \"%s\"\nUniversity id: %s\nCourse number: %d\nAvg. exam score: %f".formatted(
                fullName,
                universityId,
                currentCourseNumber,
                avgExamScore
        );
    }
}
