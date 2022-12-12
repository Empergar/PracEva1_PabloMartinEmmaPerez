package es.upsa.sbd2.Alojamiento;

import es.upsa.sbd2.Enumeraciones.CategoriaAlojamiento;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.Enumeraciones.TipoAlojamiento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Alojamiento {
    private String numRegistro;
    private TipoAlojamiento tipo;
    private CategoriaAlojamiento categoria;
    private String especialidades;
    private String nombre;
    private String direccion;
    private String codPostal;
    private Provincia provincia;
    private String municipio;
    private String localidad;
    private String nucleo;
    private List<String> telefonos;
    private String email;
    private String web;
    private Boolean calidadQ;
    private Boolean centralReservas;
    private Boolean posadaReal;
    private Integer plazas;
    private String longitud;
    private String latitud;
    private Boolean accMinusvalidos;
    private String posicion;
}
