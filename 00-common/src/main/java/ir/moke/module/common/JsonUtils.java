package ir.moke.module.common;

import com.google.gson.Gson;

public class JsonUtils {
    private static final Gson gson = new Gson();

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    public static <T> T toObject(String json, Class<T> typeClass) {
        return gson.fromJson(json, typeClass);
    }
}
