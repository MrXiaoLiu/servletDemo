package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class GsonUtil {

    private static Gson gson = new GsonBuilder().create();

    public static String bean2Json(Object object){

        return gson.toJson(object);
    }

    public static <T>T json2Bean(String string,Class<T> objClass){

        return gson.fromJson(string,objClass);
    }

    public static String jsonFormatter(String uglyJsonStr){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonParser jp = new JsonParser();

        JsonElement parse = jp.parse(uglyJsonStr);

        return gson.toJson(parse);


    }
}
