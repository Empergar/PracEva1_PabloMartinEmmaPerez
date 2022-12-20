package es.upsa.sbd2.Enumeraciones;

import es.upsa.sbd2.DataNotValidException;

public enum CategoriaRestaurante {

    LUJO("lujo - 5 tenedores"), PRIMERA("1ª - 4 tenedores"),
    SEGUNDA("2ª - 3 tenedores"), TERCERA("3ª - 2 tenedores"),
    CUARTA("4ª - 1 tenedor"), NO_ESPECIFICADO("No especificado");

    private final String categoriaRestaurante;

    CategoriaRestaurante(String categoriaRestaurante) {
        this.categoriaRestaurante = categoriaRestaurante;
    }

    public static CategoriaRestaurante getCategoriaRestaurante(String categoria)
    {
        if (categoria.equals(""))
        {
            return CategoriaRestaurante.NO_ESPECIFICADO;
        }

        for (CategoriaRestaurante cat: CategoriaRestaurante.values())
        {
            if (cat.categoriaRestaurante.equals(categoria.toLowerCase()))
            {
                return cat;
            }
        }
        throw new DataNotValidException();
    }
}
