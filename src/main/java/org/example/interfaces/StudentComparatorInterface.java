package org.example.interfaces;

import org.example.Student;
import java.util.Comparator;

public interface StudentComparatorInterface extends Comparator<Student> {
    @Override
    int compare(Student o1, Student o2);
}
