package es.upsa.sbd2.Enumeraciones;

import es.upsa.sbd2.DataNotValidException;

public enum CategoriaAlojamiento {
    PRIMERA("1ª - 1 Estrella"), SEGUNDA("2ª - 2 Estrellas"),
    TERCERA("3ª - 3 Estrellas"), CUARTA("4ª - 4 Estrellas"),
    QUINTA("5ª - 5 Estrellas");

    private final String categoriaAlojamiento;

    CategoriaAlojamiento(String categoriaAlojamiento) {
        this.categoriaAlojamiento = categoriaAlojamiento;
    }

    public static CategoriaAlojamiento getCategoriaAlojamiento(String categoria)
    {
        for (CategoriaAlojamiento cat: CategoriaAlojamiento.values())
        {
            if (cat.categoriaAlojamiento.equals(categoria))
            {
                return cat;
            }
        }
        throw new DataNotValidException();
    }

}
