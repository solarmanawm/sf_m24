package org.example.interfaces;

import org.example.University;
import java.util.Comparator;

public interface UniversityComparatorInterface extends Comparator<University> {
    @Override
    int compare(University o1, University o2);
}
