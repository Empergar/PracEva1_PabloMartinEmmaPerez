package es.upsa.sbd2.Restaurante;

import es.upsa.sbd2.Enumeraciones.Provincia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with",
         buildMethodName = "newBuilder")
public class Restaurante {
    private String establecimiento; //Lo dejo asi para acordarme
    private String numRegistro;
    private String codigo;
    private String tipo;
    private String categoria; //FALTA UNA ENUM DE CATEGORIA
    private String especialidades;
    private String clase;
    private String nombre;
    private String direccion;
    private String cp;
    private Provincia provincia;
    private String municipio;
    private String localidad;
    private String nucleo;
    //Te he cambiado lo de telefonos porque hablando con alejandro he visto que es una lista en el JSON
    private List<String> telefonos;
    private String email;
    private String web;
    private String calidadQ;
    private String centralReservas;
    private String posadaReal;
    private String plazas; //es un int y en el CsvRestaurante hay que hacer la conversion pero quiero aislar un problema
    private String longitud;
    private String latitud;
    private String accesible;
    private String posicion;

}
