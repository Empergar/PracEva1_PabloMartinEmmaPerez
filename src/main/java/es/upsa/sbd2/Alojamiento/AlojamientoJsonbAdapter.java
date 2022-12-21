package es.upsa.sbd2.Alojamiento;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class AlojamientoJsonbAdapter implements JsonbAdapter<Alojamiento, JsonObject> {
    @Override
    public JsonObject adaptToJson(Alojamiento alojamiento) throws Exception {
        /*
        return Json.createObjectBuilder()
                .add("dia", toJson(obj.getDia()))
                .add("horario", obj.getInicio() + "-" + obj.getFin())
                .build();
         */
        return null;
    }

    @Override
    public Alojamiento adaptFromJson(JsonObject jsonObject) throws Exception {
        /*
        String[] tokens = obj.getString("horario").split("-");
        return Horario.builder()
                .withDia(fromJson(obj.getString("dia")))
                .withInicio(tokens[0])
                .withFin(tokens[1])
                .build();
         */
        return null;
    }
}
