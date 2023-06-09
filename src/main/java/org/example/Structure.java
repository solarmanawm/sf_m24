package org.example;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Structure {
    @XmlElement(name="processedAt")
    @SerializedName("processedAt")
    private String date;
    @XmlElement(name="statisticalInfo")
    @SerializedName("statisticalInfo")
    private StatisticalInfo statisticalInfo;
    @XmlElement(name="universitiesInfo")
    @SerializedName("universitiesInfo")
    private UniversitiesInfo universitiesInfo;
    @XmlElement(name="studentsInfo")
    @SerializedName("studentsInfo")
    private StudentsInfo studentsInfo;

    public UniversitiesInfo getUniversitiesInfo() {
        return universitiesInfo;
    }

    public void setUniversitiesInfo(UniversitiesInfo universitiesInfo) {
        this.universitiesInfo = universitiesInfo;
    }

    public StudentsInfo getStudentsInfo() {
        return studentsInfo;
    }

    public void setStudentsInfo(StudentsInfo studentsInfo) {
        this.studentsInfo = studentsInfo;
    }

    public StatisticalInfo getStatisticalInfo() {
        return statisticalInfo;
    }

    public void setStatisticalInfo(StatisticalInfo statisticalInfo) {
        this.statisticalInfo = statisticalInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Structure() {
    }
}
