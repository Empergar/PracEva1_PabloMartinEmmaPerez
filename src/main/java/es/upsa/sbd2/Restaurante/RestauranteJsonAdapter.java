package es.upsa.sbd2.Restaurante;

import es.upsa.sbd2.Enumeraciones.CategoriaRestaurante;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.JsonAdapter;
import es.upsa.sbd2.TelefonoJsonAdapter;
import es.upsa.sbd2.TelefonoJsonbAdapter;
import jakarta.json.*;
import jakarta.json.bind.adapter.JsonbAdapter;

import java.util.List;

public class RestauranteJsonAdapter implements JsonAdapter<Restaurante>
{
    //Creamos el adaptador para el telefono porque necesita un formato/estructura especial
    private final JsonAdapter<String> telefonoJsonAdapter = new TelefonoJsonAdapter();

    //Funcion que creara los objetos Json de los restaurantes
    @Override
    public JsonValue toJson(Restaurante data) {
        return Json.createObjectBuilder()

                .add("nregistro", data.getNumRegistro())
                .add("categoria", data.getCategoria())
                .add("nombre", data.getNombre())
                .add("plazas", data.getPlazas())
                .add("discapacidad", data.getAccMinusvalidos())
                .add("ubicacion", Json.createObjectBuilder()
                                         .add("direccion", data.getDireccion())
                                         .add("cpostal", data.getCodPostal())
                                         .add("provincia", data.getProvincia())
                                         .add("municipio", data.getMunicipio())
                                         .add("localidad", data.getLocalidad())
                                         .add("nucleo", data.getNucleo())
                                         .add("gps", Json.createObjectBuilder()
                                                            .add("longitud", data.getLongitud())
                                                            .add("latitud", data.getLatitud())
                                                            .build())
                                         .build())
                .add("contactos",Json.createObjectBuilder()
                        .add("telefonos", telefonoJsonAdapter.toJsonArray(data.getTelefonos()))
                        .add("email", data.getEmail())
                        .add("web", data.getWeb()))
                .build();
    }

    @Override
    public JsonArray toJsonArray(List<Restaurante> data) {
        return JsonAdapter.super.toJsonArray(data);
    }

}