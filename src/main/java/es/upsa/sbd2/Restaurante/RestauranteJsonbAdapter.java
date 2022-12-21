package es.upsa.sbd2.Restaurante;

import es.upsa.sbd2.Enumeraciones.CategoriaRestaurante;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.TelefonoJsonbAdapter;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;

public class RestauranteJsonbAdapter implements JsonbAdapter<Restaurante, JsonObject>
{
    @Override
    public JsonObject adaptToJson(Restaurante restaurante) throws Exception {
        return null;
    }

    @Override
    public Restaurante adaptFromJson(JsonObject jsonObject) throws Exception {
        String accMinusvalidos;

        if (jsonObject.getBoolean("discapacidad")){
            accMinusvalidos = "Si";
        } else {
            accMinusvalidos = "";
        }

        return Restaurante.builder()
                .withEstablecimiento("Restaurantes")
                .withNumRegistro(jsonObject.getString("numRegistro"))
                .withTipo(jsonObject.getString("tipo"))
                .withCategoria(CategoriaRestaurante.getCategoriaRestaurante(jsonObject.getString("categoria")))
                .withNombre(jsonObject.getString("nombre"))
                .withPlazas(jsonObject.getInt("plazas"))
                .withAccMinusvalidos(accMinusvalidos)
                .withDireccion(jsonObject.getJsonObject("ubicacion").getString("direccion"))
                .withCodPostal(jsonObject.getJsonObject("ubicacion").getString("codPostal"))
                .withProvincia(Provincia.getProvincia(jsonObject.getJsonObject("ubicacion").getString("provincia")))
                .withMunicipio(jsonObject.getJsonObject("ubicacion").getString("municipio"))
                .withLocalidad(jsonObject.getJsonObject("ubicacion").getString("localidad"))
                .withNucleo(jsonObject.getJsonObject("ubicacion").getString("nucleo"))
                .withLongitud(jsonObject.getJsonObject("ubicacion").getJsonObject("gps").getString("longitud"))
                .withLatitud(jsonObject.getJsonObject("ubicacion").getJsonObject("gps").getString("latitud"))
                .withTelefonos(new TelefonoJsonbAdapter().adaptFromJson(jsonObject.getJsonObject("contacto").getJsonArray("telefonos")))
                .withEmail(jsonObject.getJsonObject("contacto").getString("email"))
                .withWeb(jsonObject.getJsonObject("contacto").getString("web"))
                .build();
    }

}
