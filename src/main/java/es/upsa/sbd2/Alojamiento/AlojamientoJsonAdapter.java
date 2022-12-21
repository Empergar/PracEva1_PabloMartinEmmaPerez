package es.upsa.sbd2.Alojamiento;

import es.upsa.sbd2.JsonAdapter;
import es.upsa.sbd2.TelefonoJsonAdapter;
import jakarta.json.Json;
import jakarta.json.JsonValue;

public class AlojamientoJsonAdapter implements JsonAdapter<Alojamiento> {

    //Creamos el adaptador para el telefono porque necesita un formato/estructura especial
    private final JsonAdapter<String> telefonosJsonAdapter = new TelefonoJsonAdapter();

    //Funcion que creara los objetos Json de los alojamientos
    @Override
    public JsonValue toJson(Alojamiento data) {

        return  Json.createObjectBuilder()
                    .add("numRegistro", data.getNumRegistro())
                    .add("tipo",data.getTipo().getTipoAlojamientoString())
                    .add("categoria",data.getCategoria())
                    .add("nombre", data.getNombre())
                    .add("plazas", data.getPlazas())
                    .add("discapacidad", data.getAccMinusvalidos())
                    .add("ubicacion", Json.createObjectBuilder()
                                             .add("direccion", data.getDireccion())
                                             .add("codPostal", data.getCodPostal())
                                             .add("provincia", data.getProvincia())
                                             .add("municipio", data.getMunicipio())
                                             .add("localidad", data.getLocalidad())
                                             .add("nucleo", data.getNucleo())
                                             .add("gps", Json.createObjectBuilder()
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
