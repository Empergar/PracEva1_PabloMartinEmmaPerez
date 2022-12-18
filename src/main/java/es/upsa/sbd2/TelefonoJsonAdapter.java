package es.upsa.sbd2;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;

public class TelefonoJsonAdapter implements JsonAdapter<String>
{
    @Override
    public JsonValue toJson(String data) {

        return Json.createValue(data);
    }
}
