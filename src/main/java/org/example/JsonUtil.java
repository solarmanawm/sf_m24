package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private static JsonUtil _instance = null;

    public static JsonUtil getInstance() {
        if (_instance == null) {
            _instance = new JsonUtil();
        }

        return _instance;
    }

    private final Gson gson;

    private JsonUtil() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    String serializeStudent(Student student) {
        return this.gson.toJson(student);
    }

    String serializeUniversity(University university) {
        return this.gson.toJson(university);
    }

    Student deserializeStudent(String studentJson) {
        return this.gson.fromJson(studentJson, Student.class);
    }

    University deserializeUniversity(String universityJson) {
        return this.gson.fromJson(universityJson, University.class);
    }

    String serializeStudentsList(List<Student> students) {
        return this.gson.toJson(students);
    }

    <T> String serialize(T object) {
        return this.gson.toJson(object);
    }

    String serializeUniversitiesList(List<University> universities) {
        return this.gson.toJson(universities);
    }

    List<Student> deserializeStudentsList(String studentsJson) {
        Type typeToken = new TypeToken<ArrayList<Student>>() {}.getType();
        return this.gson.fromJson(studentsJson, typeToken);
    }

    List<University> deserializeUniversitiesList(String universitiesJson) {
        Type typeToken = new TypeToken<ArrayList<University>>() {}.getType();
        return this.gson.fromJson(universitiesJson, typeToken);
    }
}
