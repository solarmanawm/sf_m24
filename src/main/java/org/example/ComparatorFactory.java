package org.example;

import org.example.comparatos.*;
import org.example.enums.StudentComparison;
import org.example.enums.UniversityComparison;
import org.example.interfaces.StudentComparatorInterface;
import org.example.interfaces.UniversityComparatorInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ComparatorFactory {
    static StudentComparatorInterface getStudentComparator(StudentComparison comparison) throws Exception {
        Map<StudentComparison, Callable<StudentComparatorInterface>> map = new HashMap<>();
        map.put(StudentComparison.AVG_EXAM, StudentAvgExamScoreComparator::new);
        map.put(StudentComparison.COURSE_NUMBER, StudentCourseNumberComparator::new);
        map.put(StudentComparison.FULL_NAME, StudentFullNameComparator::new);
        map.put(StudentComparison.UNIVERSITY_ID, StudentUniversityIdComparator::new);

        return map.get(comparison).call();
    }

    static UniversityComparatorInterface getUniversityComparator(UniversityComparison comparison) throws Exception {
        Map<UniversityComparison, Callable<UniversityComparatorInterface>> map = new HashMap<>();
        map.put(UniversityComparison.ID, UniversityIdComparator::new);
        map.put(UniversityComparison.FULL_NAME, UniversityFullNameComparator::new);
        map.put(UniversityComparison.MAIN_PROFILE, UniversityMainProfileComparator::new);
        map.put(UniversityComparison.SHORT_NAME, UniversityShortNameComparator::new);
        map.put(UniversityComparison.YEAR_OF_FOUNDATION, UniversityYearOfFoundationComparator::new);

        return map.get(comparison).call();
    }
}
