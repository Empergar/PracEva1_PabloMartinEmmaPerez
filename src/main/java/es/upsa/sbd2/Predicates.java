package es.upsa.sbd2;

import es.upsa.sbd2.Alojamiento.Alojamiento;
import es.upsa.sbd2.Enumeraciones.CategoriaAlojamiento;
import es.upsa.sbd2.Enumeraciones.CategoriaRestaurante;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.Enumeraciones.TipoAlojamiento;
import es.upsa.sbd2.Restaurante.Restaurante;

import java.util.function.Predicate;

public class Predicates {

    //Crea y devuelve un Predicate<Alojamiento> que verifica si un alojamiento está ubicado en un determinado código postal
    public static Predicate<Alojamiento> alojamientosByCodigoPostal(String cpostal){
        return alojamiento -> alojamiento.getCodPostal().equals(cpostal);
    }

    //Crea y devuelve un Predicate<Alojamiento> que verifica si el alojamiento está ubicado en una determinada Provincia.
    public static Predicate<Alojamiento> alojamientosByProvincia(Provincia provincia){
        return alojamiento -> alojamiento.getProvincia().equals(provincia);
    }

    //Crea y devuelve un Predicate<Alojamiento> que verifica si el tipo del alojamiento lo es de un determinado TipoAlojamiento.
    public static Predicate<Alojamiento> alojamientosByTipo(TipoAlojamiento tipo){
        return  alojamiento -> alojamiento.getTipo().equals(tipo);
    }

    //Crea y devuelve un Predicate<Alojamiento> que verifica si un alojamiento lo es de una determinada Categoría
    public static Predicate<Alojamiento> alojamientosByCategoria(CategoriaAlojamiento categoria){
        return alojamiento -> alojamiento.getCategoria().equals(categoria);
    }

    //Crea y devuelve un Predicate<Alojamiento> que verifica si un alojamiento tiene, al menos, un número determinado de plazas.
    public static Predicate<Alojamiento> alojamientosByPlazas(int plazas){
        return alojamiento -> alojamiento.getPlazas() >= plazas;
    }

    //Crea y devuelve un Predicate<Alojamiento> que verifica si un alojamiento está ubicado en una determinada localidad.
    public static Predicate<Alojamiento> alojamientosByLocalidad(String localidad){
        return alojamiento -> alojamiento.getLocalidad().toLowerCase().equals(localidad.toLowerCase());
    }

    //Crea y devuelve un Predicate<Alojamiento> que verifica si el alojamiento tiene accesibilildad para minusválidos.
    public static Predicate<Alojamiento> alojamientosByAccesibilidadMinusvaidos(){
        return alojamiento -> alojamiento.getAccMinusvalidos().toLowerCase().equals("si");
    }

    //Crea y devuelve un Predicate<Alojamiento> que siempre se cumplirá para cualquier alojamiento.
    public static Predicate<Alojamiento> allAlojamientos(){
        return new allAlojamientos();
    }

    //Crea y devuelve un Predicate<Restaurante> que verifica si el restaurante está ubicado en una determinada Provincia.
    public static Predicate<Restaurante> restaurantesByProvincia(Provincia provincia){
        return restaurante -> restaurante.getProvincia().equals(provincia);
    }

    //Crea y devuelve un Predicate<Restaurante> que verifica si un restaurante está ubicado en una determinada localidad
    public static Predicate<Restaurante> restaurantesByLocalidad(String localidad){
        return restaurante -> restaurante.getLocalidad().toLowerCase().equals(localidad.toLowerCase());
    }

    //Crea y devuelve un Predicate<Restaurante> que verifica si un restaurante lo es de una determinada Categoría
    public static Predicate<Restaurante> restaurantesByCategoria(CategoriaRestaurante categoria){
        return restaurante -> restaurante.getCategoria().equals(categoria);
    }

    //Crea y devuelve un Predicate<Restaurante> que verifica si un restaurante tiene, al menos, un número determinado de plazas.
    public static Predicate<Restaurante> restaurantesByPlazas(int plazas){
        return restaurante -> restaurante.getPlazas() >= plazas;
    }

    //Crea y devuelve un Predicate<Restaurante> que verificará si el restaurante está ubicado en la misma provincia y localidad que el alojamiento, si su categoría es acorde a la categoría del alojamiento y si dispone de al menos un número de plazas igual a las del alojamiento.
/*
    public static Predicate<Restaurante> restaurantesByAlojamiento(Alojamiento alojamiento){

    }
*/
}
