package es.upsa.sbd2.Alojamiento;

import es.upsa.sbd2.Enumeraciones.CategoriaAlojamiento;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.Enumeraciones.TipoAlojamiento;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@JsonbPropertyOrder({"numRegistro", "tipo", "categoria", "nombre", "plazas", "accMinusvalidos", "ubicacion", "contactos"})
public class Alojamiento
{

    @JsonbCreator
    public static Alojamiento of(@JsonbProperty("numRegistro") String numRegistro,
                                 @JsonbProperty("tipo") String tipo,
                                 @JsonbProperty("categoria") String categoria,
                                 @JsonbProperty("nombre") String nombre,
                                 @JsonbProperty("discapacidad") Boolean discapacidad,
                                 @JsonbProperty("ubicacion") JsonObject ubicacion,
                                 @JsonbProperty("contactos") JsonObject contactos)
    {
            String accMinusvalidos;

            if (discapacidad){
                accMinusvalidos = "Si";
            } else {
                accMinusvalidos = "";
            }

        return Alojamiento.builder()
                .withNumRegistro(numRegistro)
                .withTipo(TipoAlojamiento.getTipoAlojamiento(tipo))
                .withCategoria(CategoriaAlojamiento.getCategoriaAlojamiento(categoria))
                .withNombre(nombre)
                .withAccMinusvalidos(accMinusvalidos)
                .withDireccion(ubicacion.getString("direccion"))
                .withCodPostal(ubicacion.getString("codPostal"))
                .withProvincia(Provincia.getProvincia(ubicacion.getString("provincia")))
                .withMunicipio(ubicacion.getString("municipio"))
                .withLocalidad(ubicacion.getString("localidad"))
                .withNucleo(ubicacion.getString("nucleo"))
                .withLongitud(ubicacion.getJsonObject("gps").getString("longitud"))
                .withLatitud(ubicacion.getJsonObject("gps").getString("latitud"))
                .withTelefonos(contactos.getJsonArray("telefonos").getValuesAs((JsonValue::toString)))
                .withEmail(contactos.getString("email"))
                .withWeb(contactos.getString("web"))
                .build();
    }

    @NonNull
    private String numRegistro;
    @NonNull
    private TipoAlojamiento tipo;
    private CategoriaAlojamiento categoria;
    private String especialidades;
    @NonNull
    private String nombre;
    private String direccion;
    @NonNull
    private String codPostal;
    @NonNull
    private Provincia provincia;
    @NonNull
    private String municipio;
    @NonNull
    private String localidad;
    private String nucleo;
    private List<String> telefonos;
    private String email;
    private String web;
    private String calidadQ;
    private String centralReservas;
    private Integer plazas;
    private String longitud;
    private String latitud;
    @JsonbProperty (value = "discapacidad")
    private String accMinusvalidos;
}
