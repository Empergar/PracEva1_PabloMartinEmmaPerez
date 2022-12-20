package es.upsa.sbd2.Alojamiento;

import es.upsa.sbd2.Enumeraciones.CategoriaAlojamiento;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.Enumeraciones.TipoAlojamiento;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Alojamiento {
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
    private String posadaReal;
    private Integer plazas;
    private String longitud;
    private String latitud;
    private String accMinusvalidos;
    private String posicion;
}
