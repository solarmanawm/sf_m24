package org.example.comparatos;

import org.apache.commons.lang3.StringUtils;
import org.example.Student;
import org.example.interfaces.StudentComparatorInterface;

public class StudentFullNameComparator implements StudentComparatorInterface {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
