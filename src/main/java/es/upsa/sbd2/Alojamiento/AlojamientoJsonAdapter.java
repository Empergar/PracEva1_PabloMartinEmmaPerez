package es.upsa.sbd2.Alojamiento;

import es.upsa.sbd2.JsonAdapter;
import es.upsa.sbd2.TelefonoJsonAdapter;
import jakarta.json.Json;
import jakarta.json.JsonValue;

public class AlojamientoJsonAdapter implements JsonAdapter<Alojamiento> {

    private final JsonAdapter<String> telefonosJsonAdapter = new TelefonoJsonAdapter();
    @Override
    public JsonValue toJson(Alojamiento data) {

        return  Json.createObjectBuilder()
                    .add("numRegistro", data.getNumRegistro())
                    .add("tipo",data.getTipo().ordinal())
                    .add("categoria",data.getCategoria().ordinal())
                    .add("nombre", data.getNombre())
                    .add("plazas", data.getPlazas())
                    .add("accesible", data.getAccMinusvalidos().equals("Si"))
                    .add("ubicacion", Json.createObjectBuilder()
                                             .add("direccion", data.getDireccion())
                                             .add("codPostal", data.getCodPostal())
                                             .add("provincia", data.getProvincia().ordinal())
                                             .add("municipio", data.getMunicipio())
                                             .add("localidad", data.getLocalidad())
                                             .add("nucleo", data.getNucleo())
                                             .add("ubicacion", Json.createObjectBuilder()
                                                                      .add("longitud", data.getLongitud())
                                                                      .add("latitud", data.getLatitud())
                    ))
                    .add("contactos", Json.createObjectBuilder()
                                             .add("telefonos", telefonosJsonAdapter.toJsonArray(data.getTelefonos()))
                                             .add("email", data.getEmail())
                                             .add("web", data.getWeb()
                    ))
                .build();
    }
}
