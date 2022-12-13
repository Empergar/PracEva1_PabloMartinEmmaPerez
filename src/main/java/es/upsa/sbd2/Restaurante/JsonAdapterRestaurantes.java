package es.upsa.sbd2.Restaurante;

import es.upsa.sbd2.JsonAdapter;
import es.upsa.sbd2.Restaurante.Restaurante;
import jakarta.json.Json;
import jakarta.json.JsonValue;

public class JsonAdapterRestaurantes implements JsonAdapter<Restaurante>
{
    @Override
    public JsonValue toJson(Restaurante data) {

        return Json.createObjectBuilder()

                .add("numRegistro", data.getNumRegistro())
                .add("tipo", data.getTipo())
                .add("categoria", data.getCategoria().ordinal())
                .add("nombre", data.getNombre())
                .add("plazas", data.getPlazas())
                .add("accesible", data.getAccesible().equals(""))
                .add("ubicacion", Json.createObjectBuilder()
                                         .add("direccion", data.getDireccion())
                                         .add("cp", data.getCp())
                                         .add("provincia", data.getProvincia().ordinal())
                                         .add("municipio", data.getMunicipio())
                                         .add("localidad", data.getLocalidad())
                                         .add("nucleo", data.getNucleo())
                                         .add("gps", Json.createObjectBuilder()
                                                            .add("longitud", data.getLongitud())
                                                            .add("latitud", data.getLatitud())
                                                            .build())
                                         .build())
                .add("contacto",Json.createObjectBuilder()
                        .add("telefono", Json.createObjectBuilder()
                                .add("telefono1", data.getTlf1())
                                .add("telefono2", data.getTlf2())
                                .add("telefono3", data.getTlf3())
                                .build())
                        .add("email", data.getEmail())
                        .add("web", data.getWeb()))
                .build();


    }
}
