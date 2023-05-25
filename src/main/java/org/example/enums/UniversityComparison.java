package org.example.enums;

public enum UniversityComparison {
    SHORT_NAME("SHORT_NAME"),
    YEAR_OF_FOUNDATION("YEAR_OF_FOUNDATION"),
    MAIN_PROFILE("MAIN_PROFILE"),
    FULL_NAME("FULL_NAME"),
    ID("ID");

    private final String name;

    UniversityComparison(String profileName) {
        this.name = profileName;
    }

    public String getName() {
        return name;
    }
}
