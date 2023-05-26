package org.example.comparatos;

import org.example.University;
import org.example.interfaces.UniversityComparatorInterface;

public class UniversityYearOfFoundationComparator implements UniversityComparatorInterface {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
