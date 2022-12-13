package es.upsa.sbd2;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonValue;

import java.util.List;

public interface JsonAdapter <T> {

    JsonValue toJson(T data);

    default JsonArray toJsonArray(List<T> data)
    {
        JsonArrayBuilder jab = Json.createArrayBuilder();
        data.forEach( item -> jab.add( toJson(item) ) );

        return jab.build();
    }


}
