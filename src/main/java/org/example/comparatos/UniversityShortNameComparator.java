package org.example.comparatos;

import org.apache.commons.lang3.StringUtils;
import org.example.University;
import org.example.interfaces.UniversityComparatorInterface;

public class UniversityShortNameComparator implements UniversityComparatorInterface {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
