package es.upsa.sbd2.Enumeraciones;

import es.upsa.sbd2.Exceptions.DataNotValidException;

public enum CategoriaAlojamiento {
    PRIMERA("1ª - 1 estrella"), SEGUNDA("2ª - 2 estrellas"),
    TERCERA("3ª - 3 estrellas"), CUARTA("4ª - 4 estrellas"),
    QUINTA("5ª - 5 estrellas"), UNSPECIFIED("no especificado");


    private final String categoriaAlojamiento;

    CategoriaAlojamiento(String categoriaAlojamiento) {
        this.categoriaAlojamiento = categoriaAlojamiento;
    }

    public String getCategoriaAlojamientoString()
    {
        return categoriaAlojamiento;
    }

    //Creacion del metodo getCategoriaAlojamiento
    public static CategoriaAlojamiento getCategoriaAlojamiento(String categoria)
    {
        //Se comprueba si el campo al ser opcional puede estar vacio
        if (categoria.equals(""))
        {
            return CategoriaAlojamiento.UNSPECIFIED;
        }

        //Se comprueba si recorriendo la enumeracion...
        for (CategoriaAlojamiento cat: CategoriaAlojamiento.values())
        {
            //Se encuentra coincidencia entre lo encontrado en el csv y la enumeracion
            if (cat.categoriaAlojamiento.equals(categoria.toLowerCase()))
            {
                return cat;
            }
        }
        //Si no es así propaga excepcion
        throw new DataNotValidException();
    }

}
