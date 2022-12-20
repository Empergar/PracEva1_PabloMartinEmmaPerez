package es.upsa.sbd2.Enumeraciones;

import es.upsa.sbd2.DataNotValidException;

public enum CategoriaAlojamiento {
    PRIMERA("1ª - 1 estrella"), SEGUNDA("2ª - 2 estrellas"),
    TERCERA("3ª - 3 estrellas"), CUARTA("4ª - 4 estrellas"),
    QUINTA("5ª - 5 estrellas"), NO_ESPECIFICADO("No especificado");

    private final String categoriaAlojamiento;

    CategoriaAlojamiento(String categoriaAlojamiento) {
        this.categoriaAlojamiento = categoriaAlojamiento;
    }

    public static CategoriaAlojamiento getCategoriaAlojamiento(String categoria)
    {
        if (categoria.equals(""))
        {
            return CategoriaAlojamiento.NO_ESPECIFICADO;
        }

        for (CategoriaAlojamiento cat: CategoriaAlojamiento.values())
        {
            if (cat.categoriaAlojamiento.equals(categoria.toLowerCase()))
            {
                return cat;
            }
        }
        throw new DataNotValidException();
    }

}
