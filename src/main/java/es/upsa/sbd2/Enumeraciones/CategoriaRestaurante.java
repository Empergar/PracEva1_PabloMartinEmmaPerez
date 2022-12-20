package es.upsa.sbd2.Enumeraciones;

import es.upsa.sbd2.DataNotValidException;

public enum CategoriaRestaurante {

    LUJO("Lujo - 5 Tenedores"), PRIMERA("1ª - 4 Tenedores"),
    SEGUNDA("2ª - 3 Tenedores"), TERCERA("3ª - 2 Tenedores"),
    CUARTA("4ª - 1 Tenedor"), NO_ESPECIFICADO("No especificado");

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
            if (cat.categoriaRestaurante.equals(categoria))
            {
                return cat;
            }
        }
        throw new DataNotValidException();
    }
}
