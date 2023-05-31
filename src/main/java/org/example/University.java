package org.example;

import com.google.gson.annotations.SerializedName;
import org.example.enums.StudyProfile;

public class University {
    @SerializedName("universityId")
    private String id;
    @SerializedName("universityName")
    private String fullName;
    @SerializedName("universityAbbreviation")
    private String shortName;
    @SerializedName("universityEst")
    private int yearOfFoundation;
    @SerializedName("universityProfile")
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public String toString() {
        System.out.println();
        System.out.println("-----------------------");

        return "\nUniversity \"%s\"\nShort name: %s\nYear of foundation: %d\nMain Profile: %s".formatted(
                fullName,
                shortName,
                yearOfFoundation,
                mainProfile.getName()
        );
    }
}
