package es.upsa.sbd2.Alojamiento;

import es.upsa.sbd2.Enumeraciones.CategoriaAlojamiento;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.Enumeraciones.TipoAlojamiento;
import es.upsa.sbd2.TelefonoAdapter.TelefonoJsonbAdapter;
import jakarta.json.JsonObject;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@JsonbPropertyOrder({"numRegistro", "tipo", "categoria", "nombre", "plazas", "accMinusvalidos",
                     "direccion", "codPostal", "provincia", "municipio", "localidad", "nucleo",
                     "longitud", "latitud", "telefonos", "email", "web"})
public class Alojamiento
{

    @JsonbCreator
    public static Alojamiento of(@JsonbProperty("nregistro") String nregistro,
                                 @JsonbProperty("tipo") String tipo,
                                 @JsonbProperty("categoria") String categoria,
                                 @JsonbProperty("nombre") String nombre,
                                 @JsonbProperty("plazas") Integer plazas,
                                 @JsonbProperty("discapacidad") Boolean discapacidad,
                                 @JsonbProperty("ubicacion") JsonObject ubicacion,
                                 @JsonbProperty("contactos") JsonObject contactos)
    {
        return Alojamiento.builder()
                .withNumRegistro(nregistro)
                .withTipo(TipoAlojamiento.getTipoAlojamiento(tipo))
                .withCategoria(CategoriaAlojamiento.getCategoriaAlojamiento(categoria))
                .withNombre(nombre)
                .withPlazas(plazas)
                .withAccMinusvalidos(discapacidad)
                .withDireccion(ubicacion.getString("direccion"))
                .withCodPostal(ubicacion.getString("cpostal"))
                .withProvincia(Provincia.getProvincia(ubicacion.getString("provincia")))
                .withMunicipio(ubicacion.getString("municipio"))
                .withLocalidad(ubicacion.getString("localidad"))
                .withNucleo(ubicacion.getString("nucleo"))
                .withLongitud(ubicacion.getJsonObject("gps").getString("longitud"))
                .withLatitud(ubicacion.getJsonObject("gps").getString("latitud"))
                .withTelefonos(new TelefonoJsonbAdapter().adaptFromJson(contactos.getJsonArray("telefonos")))
                .withEmail(contactos.getString("email"))
                .withWeb(contactos.getString("web"))
                .build();
    }

    @NonNull
    @JsonbProperty (value = "nregistro")
    private String numRegistro;
    @NonNull
    private TipoAlojamiento tipo;
    private CategoriaAlojamiento categoria;
    private String especialidades;
    @NonNull
    private String nombre;
    private String direccion;
    @NonNull
    @JsonbProperty (value = "cpostal")
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
    private Boolean accMinusvalidos;

    public String getCategoria() {
        return categoria.getCategoriaAlojamientoString();
    }

    public String getProvincia() {
        return provincia.getProvinciaString();
    }
}
