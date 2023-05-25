package org.example.comparatos;

import org.example.Student;
import org.example.interfaces.StudentComparatorInterface;

public class StudentCourseNumberComparator implements StudentComparatorInterface {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
