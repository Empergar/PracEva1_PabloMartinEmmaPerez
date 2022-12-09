package es.upsa.sbd2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Restaurante {
    private String establecimiento = "Restaurantes"; //Lo dejo asi para acordarme
    private String numRegistro;
    private String codigo;
    private String tipo;
    private String categoria; //FALTA UNA ENUM DE CATEGORIA
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
