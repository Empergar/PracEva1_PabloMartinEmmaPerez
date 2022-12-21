package es.upsa.sbd2.Interfaces;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonValue;

import java.util.List;

public interface JsonAdapter <T> {

    //Funcion abstracta que tratará de crear los objetos java extraidos del csv a Json
    JsonValue toJson(T data);


    //Funcion que tratará de crear JsonArrays en el fichero Json
    default JsonArray toJsonArray(List<T> data)
    {
        JsonArrayBuilder jab = Json.createArrayBuilder();
        data.forEach( item -> jab.add( toJson(item) ) );

        return jab.build();
    }


}
