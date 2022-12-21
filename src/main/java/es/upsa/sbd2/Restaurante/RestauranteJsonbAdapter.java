package es.upsa.sbd2.Restaurante;

import es.upsa.sbd2.Enumeraciones.CategoriaRestaurante;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.TelefonoAdapter.TelefonoJsonbAdapter;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

import java.util.List;

public class RestauranteJsonbAdapter implements JsonbAdapter<Restaurante, JsonObject> {
    @Override
    public JsonObject adaptToJson(Restaurante restaurante) {
        return Json.createObjectBuilder()
                .add("nombre", restaurante.getNombre())
                .add("direccion", restaurante.getDireccion())
                .build();
    }

    @Override
    public Restaurante adaptFromJson(JsonObject jsonObject) throws Exception {
        return Restaurante.builder()
                .withEstablecimiento("Restaurantes")
                .withNumRegistro(jsonObject.getString("nregistro"))
                .withCategoria(CategoriaRestaurante.getCategoriaRestaurante(jsonObject.getString("categoria")))
                .withNombre(jsonObject.getString("nombre"))
                .withPlazas(jsonObject.getInt("plazas"))
                .withAccMinusvalidos(jsonObject.getBoolean("discapacidad"))
                .withDireccion(jsonObject.getJsonObject("ubicacion").getString("direccion"))
                .withCodPostal(jsonObject.getJsonObject("ubicacion").getString("cpostal"))
                .withProvincia(Provincia.getProvincia(jsonObject.getJsonObject("ubicacion").getString("provincia")))
                .withMunicipio(jsonObject.getJsonObject("ubicacion").getString("municipio"))
                .withLocalidad(jsonObject.getJsonObject("ubicacion").getString("localidad"))
                .withNucleo(jsonObject.getJsonObject("ubicacion").getString("nucleo"))
                .withLongitud(jsonObject.getJsonObject("ubicacion").getJsonObject("gps").getString("longitud"))
                .withLatitud(jsonObject.getJsonObject("ubicacion").getJsonObject("gps").getString("latitud"))
                .withTelefonos(new TelefonoJsonbAdapter().adaptFromJson(jsonObject.getJsonObject("contactos").getJsonArray("telefonos")))
                .withEmail(jsonObject.getJsonObject("contactos").getString("email"))
                .withWeb(jsonObject.getJsonObject("contactos").getString("web"))
                .build();
    }

    public JsonArray toJsonbArray(List<Restaurante> data)
    {
        JsonArrayBuilder jab = Json.createArrayBuilder();
        data.forEach( item -> jab.add( adaptToJson(item) ) );

        return jab.build();
    }
}
