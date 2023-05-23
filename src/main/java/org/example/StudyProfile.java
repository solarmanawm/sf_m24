package org.example;

public enum StudyProfile {
    PHYSICS("PHYSICS"),
    MEDICINE("MEDICINE"),
    LINGUISTICS("LINGUISTICS"),
    MATHEMATICS("MATHEMATICS");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    String getName() {
        return profileName;
    }
}
