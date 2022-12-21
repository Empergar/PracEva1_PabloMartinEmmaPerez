package es.upsa.sbd2;

import jakarta.json.JsonArray;
import jakarta.json.JsonValue;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.adapter.JsonbAdapter;

import java.util.ArrayList;
import java.util.List;

public class TelefonoJsonbAdapter implements JsonbAdapter<List<String>, JsonArray>
{

    @Override
    public JsonArray adaptToJson(List<String> strings) throws Exception {
        return null;
    }

    @Override
    public List<String> adaptFromJson(JsonArray jsonValues){
            List<String> tlfs = new ArrayList<>();
            for (JsonValue jsonValue : jsonValues) {
                tlfs.add(jsonValue.toString().replace("\"", ""));
            }
            return tlfs;
    }
}

