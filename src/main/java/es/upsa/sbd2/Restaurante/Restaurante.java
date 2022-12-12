package es.upsa.sbd2.Restaurante;

import es.upsa.sbd2.Enumeraciones.CategoriaRestaurante;
import es.upsa.sbd2.Enumeraciones.Provincia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Restaurante {
    private String establecimiento;
    private String numRegistro;
    private String codigo;
    private String tipo;
    private CategoriaRestaurante categoria; //FALTA UNA ENUM DE CATEGORIA
    private String especialidades;
    private String clase;
    private String nombre;
    private String direccion;
    private String cp;
    private Provincia provincia;
    private String municipio;
    private String localidad;
    private String nucleo;
    private String tlf1;
    private String tlf2;
    private String tlf3;
    private String email;
    private String web;
    private String calidadQ;
    private String centralReservas;
    private String posadaReal;
    private int plazas;
    private String longitud;
    private String latitud;
    private String accesible;
    private String posicion;

}
