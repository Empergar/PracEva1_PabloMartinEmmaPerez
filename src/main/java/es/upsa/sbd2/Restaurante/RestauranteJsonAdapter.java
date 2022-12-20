package es.upsa.sbd2.Restaurante;

import es.upsa.sbd2.JsonAdapter;
import es.upsa.sbd2.TelefonoJsonAdapter;
import jakarta.json.Json;
import jakarta.json.JsonValue;

public class RestauranteJsonAdapter implements JsonAdapter<Restaurante>
{
    //Creamos el adaptador para el telefono porque necesita un formato/estructura especial
    private final JsonAdapter<String> telefonoJsonAdapter = new TelefonoJsonAdapter();

    //Funcion que creara los objetos Json de los restaurantes
    @Override
    public JsonValue toJson(Restaurante data) {
        return Json.createObjectBuilder()

                .add("numRegistro", data.getNumRegistro())
                .add("tipo", data.getTipo())
                .add("categoria", data.getCategoria().getCategoriaRestauranteString())
                .add("nombre", data.getNombre())
                .add("plazas", data.getPlazas())
                .add("discapacidad", data.getAccesible().equals("Si"))
                .add("ubicacion", Json.createObjectBuilder()
                                         .add("direccion", data.getDireccion())
                                         .add("cp", data.getCp())
                                         .add("provincia", data.getProvincia().getProvinciaString())
                                         .add("municipio", data.getMunicipio())
                                         .add("localidad", data.getLocalidad())
                                         .add("nucleo", data.getNucleo())
                                         .add("gps", Json.createObjectBuilder()
                                                            .add("longitud", data.getLongitud())
                                                            .add("latitud", data.getLatitud())
                                                            .build())
                                         .build())
                .add("contacto",Json.createObjectBuilder()
                        .add("telefonos", telefonoJsonAdapter.toJsonArray(data.getTelefonos()))
                        .add("email", data.getEmail())
                        .add("web", data.getWeb()))
                .build();


    }
}
