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
        return alojamiento -> Provincia.getProvincia(alojamiento.getProvincia()).equals(provincia);
    }

    //Crea y devuelve un Predicate<Alojamiento> que verifica si el tipo del alojamiento lo es de un determinado TipoAlojamiento.
    public static Predicate<Alojamiento> alojamientosByTipo(TipoAlojamiento tipo){
        return  alojamiento -> alojamiento.getTipo().equals(tipo);
    }

    //Crea y devuelve un Predicate<Alojamiento> que verifica si un alojamiento lo es de una determinada Categoría
    public static Predicate<Alojamiento> alojamientosByCategoria(CategoriaAlojamiento categoria){
        return alojamiento -> CategoriaAlojamiento.getCategoriaAlojamiento(alojamiento.getCategoria()).equals(categoria);
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
    public static Predicate<Alojamiento> alojamientosByAccesibilidadMinusvalidos(){
        return Alojamiento::getAccMinusvalidos;
    }

    //Crea y devuelve un Predicate<Alojamiento> que siempre se cumplirá para cualquier alojamiento.
    public static Predicate<Alojamiento> allAlojamientos(){
        return new allAlojamientos();
        //Otra solución que planteamos de primeras:
        //return alojamiento -> alojamiento.equals(alojamiento);
    }

    //Crea y devuelve un Predicate<Restaurante> que verifica si el restaurante está ubicado en una determinada Provincia.
    public static Predicate<Restaurante> restaurantesByProvincia(Provincia provincia){
        return restaurante -> Provincia.getProvincia(restaurante.getProvincia()).equals(provincia);
    }

    //Crea y devuelve un Predicate<Restaurante> que verifica si un restaurante está ubicado en una determinada localidad
    public static Predicate<Restaurante> restaurantesByLocalidad(String localidad){
        return restaurante -> restaurante.getLocalidad().toLowerCase().equals(localidad.toLowerCase());
    }

    //Crea y devuelve un Predicate<Restaurante> que verifica si un restaurante lo es de una determinada Categoría
    public static Predicate<Restaurante> restaurantesByCategoria(CategoriaRestaurante categoria){
        return restaurante -> CategoriaRestaurante.getCategoriaRestaurante(restaurante.getCategoria()).equals(categoria);
    }

    //Crea y devuelve un Predicate<Restaurante> que verifica si un restaurante tiene, al menos, un número determinado de plazas.
    public static Predicate<Restaurante> restaurantesByPlazas(int plazas){
        return restaurante -> restaurante.getPlazas() >= plazas;
    }

    //Crea y devuelve un Predicate<Restaurante> que verificará si el restaurante está ubicado en la misma provincia y
    // localidad que el alojamiento, si su categoría es acorde a la categoría del alojamiento y si dispone de al menos
    // un número de plazas igual a las del alojamiento.
    public static Predicate<Restaurante> restaurantesByAlojamiento(Alojamiento alojamiento){

        return Predicates.restaurantesByProvincia(Provincia.getProvincia(alojamiento.getProvincia()))
                                                     .and(Predicates.restaurantesByLocalidad(alojamiento.getLocalidad()))
                                                     .and(Predicates.restaurantesByCategoria(getCategoriaEquivalente(alojamiento)))
                                                     .and(Predicates.restaurantesByPlazas(alojamiento.getPlazas()));
    }

    public static CategoriaRestaurante getCategoriaEquivalente(Alojamiento alojamiento)
    {
        CategoriaRestaurante categoriaEquivalente;

        switch (CategoriaAlojamiento.getCategoriaAlojamiento(alojamiento.getCategoria()))
        {
            case QUINTA:
                categoriaEquivalente = CategoriaRestaurante.LUJO;
                break;
            case CUARTA:
                categoriaEquivalente = CategoriaRestaurante.PRIMERA;
                break;
            case TERCERA:
                categoriaEquivalente = CategoriaRestaurante.SEGUNDA;
                break;
            case SEGUNDA:
                categoriaEquivalente = CategoriaRestaurante.TERCERA;
                break;
            case PRIMERA:
                categoriaEquivalente = CategoriaRestaurante.CUARTA;
                break;
            default: categoriaEquivalente = CategoriaRestaurante.UNSPECIFIED;
        }
        return categoriaEquivalente;
    }
}
