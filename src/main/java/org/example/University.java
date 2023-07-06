package org.example;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name="universityEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class University {
    @SerializedName("universityId")
    @XmlElement(name="universityId")
    private String id;
    @SerializedName("universityName")
    @XmlElement(name="universityName")
    private String fullName;
    @SerializedName("universityAbbreviation")
    @XmlTransient
    private String shortName;
    @SerializedName("universityEst")
    @XmlTransient
    private int yearOfFoundation;
    @SerializedName("universityProfile")
    @XmlElement(name="universityProfile")
    private StudyProfile mainProfile;
    private University() {}

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
