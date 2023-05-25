package org.example.enums;

public enum StudentComparison {
    AVG_EXAM("AVG_EXAM"),
    COURSE_NUMBER("COURSE_NUMBER"),
    FULL_NAME("FULL_NAME"),
    UNIVERSITY_ID("UNIVERSITY_ID");

    private final String name;

    StudentComparison(String profileName) {
        this.name = profileName;
    }

    public String getName() {
        return name;
    }
}
