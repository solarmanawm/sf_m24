package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="universitiesInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class UniversitiesInfo {
    @XmlElement(name="universityEntry")
    private List<University> universityList;
    public UniversitiesInfo() {}

    public List<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }
}
