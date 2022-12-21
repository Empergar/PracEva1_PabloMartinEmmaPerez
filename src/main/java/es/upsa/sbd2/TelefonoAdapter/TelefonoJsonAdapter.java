package es.upsa.sbd2.TelefonoAdapter;

import es.upsa.sbd2.Interfaces.JsonAdapter;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonValue;

import java.util.List;

public class TelefonoJsonAdapter implements JsonAdapter<String>
{
    //Muestra los telefonos como un array en el Json
    @Override
    public JsonValue toJson(String data) {

        return Json.createValue(data);
    }

    @Override
    public JsonArray toJsonArray(List<String> data) {
        return JsonAdapter.super.toJsonArray(data);
    }
}
