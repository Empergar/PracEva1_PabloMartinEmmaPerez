package es.upsa.sbd2.AlojamientosWithRestaurantes;

import es.upsa.sbd2.Restaurante.RestauranteJsonAdapter;
import es.upsa.sbd2.Restaurante.RestauranteJsonbAdapter;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class AlojamientosWithRestJsonbAdapter implements JsonbAdapter<AlojamientosWithRestaurantes, JsonObject> {

    @Override
    public JsonObject adaptToJson(AlojamientosWithRestaurantes alojamientosWithRestaurantes) throws Exception {
        return Json.createObjectBuilder()
                .add("tipo", alojamientosWithRestaurantes.getAlojamiento().getTipo().getTipoAlojamientoString())
                .add("categoria", alojamientosWithRestaurantes.getAlojamiento().getCategoria())
                .add("nombre", alojamientosWithRestaurantes.getAlojamiento().getNombre())
                .add("ubicacion", Json.createObjectBuilder()
                                         .add("direccion", alojamientosWithRestaurantes.getAlojamiento().getDireccion())
                                         .add("codPostal", alojamientosWithRestaurantes.getAlojamiento().getCodPostal())
                                         .add("provincia", alojamientosWithRestaurantes.getAlojamiento().getProvincia())
                                         .add("municipio", alojamientosWithRestaurantes.getAlojamiento().getMunicipio())
                                         .add("localidad", alojamientosWithRestaurantes.getAlojamiento().getLocalidad())
                                         .add("nucleo", alojamientosWithRestaurantes.getAlojamiento().getNucleo())
                                         .build())
                .add("restaurantes", new RestauranteJsonbAdapter().toJsonbArray(alojamientosWithRestaurantes.getRestaurantes()))
                .build();
    }


    @Override
    public AlojamientosWithRestaurantes adaptFromJson(JsonObject jsonObject) throws Exception {
        return null;
    }
}
