package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

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

    <T> String serialize(T object) {
        return this.gson.toJson(object);
    }

    <T> T deserialize(String json) {
        Type typeToken = new TypeToken<T>() {}.getType();
        return this.gson.fromJson(json, typeToken);
    }
}
