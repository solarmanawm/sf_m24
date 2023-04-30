package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PHYSICS("Физика"),
    MATH("Математика"),
    CHEMISTRY("Химия"),
    GEOGRAPHY("География"),
    BIOLOGY("Биология");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    String getName() {
        return profileName;
    }
}
