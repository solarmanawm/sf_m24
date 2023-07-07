package org.example;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="statisticalInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatisticalInfo {
    @XmlElement(name="statisticsEntry")
    @SerializedName("statisticsEntry")
    private List<Statistics> statisticsList;
    public StatisticalInfo() {}

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
    }
}
