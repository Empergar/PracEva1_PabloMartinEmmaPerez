package es.upsa.sbd2.Restaurante;

import es.upsa.sbd2.Enumeraciones.CategoriaRestaurante;
import es.upsa.sbd2.Enumeraciones.Provincia;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Restaurante {
    @NonNull
    private String establecimiento;
    @NonNull
    private String numRegistro;
    private String codigo;
    private String tipo;
    private CategoriaRestaurante categoria;
    private String especialidades;
    private String clase;
    @NonNull
    private String nombre;
    private String direccion;
    @NonNull
    private String cp;
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
    private String accesible;
    private String posicion;

}
