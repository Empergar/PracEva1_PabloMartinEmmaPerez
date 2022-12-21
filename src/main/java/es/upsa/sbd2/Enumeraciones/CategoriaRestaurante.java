package es.upsa.sbd2.Enumeraciones;

import es.upsa.sbd2.DataNotValidException;

public enum CategoriaRestaurante {

    LUJO("lujo - 5 tenedores"), PRIMERA("1ª - 4 tenedores"),
    SEGUNDA("2ª - 3 tenedores"), TERCERA("3ª - 2 tenedores"),
    CUARTA("4ª - 1 tenedor"), UNSPECIFIED("no especificado");

    private final String categoriaRestaurante;

    CategoriaRestaurante(String categoriaRestaurante) {
        this.categoriaRestaurante = categoriaRestaurante;
    }

    public String getCategoriaRestauranteString()
    {
        return categoriaRestaurante;
    }

    //Creacion del metodo getCategoriaRestaurante
    public static CategoriaRestaurante getCategoriaRestaurante(String categoria)
    {
        //Se comprueba si el campo al ser opcional puede estar vacio
        if (categoria.equals(""))
        {
            return CategoriaRestaurante.UNSPECIFIED;
        }

        //Se comprueba si recorriendo la enumeracion...
        for (CategoriaRestaurante cat: CategoriaRestaurante.values())
        {
            //Se encuentra coincidencia entre lo encontrado en el csv y la enumeracion
            if (cat.categoriaRestaurante.equals(categoria.toLowerCase()))
            {
                return cat;
            }
        }
        //Si no es así propaga excepcion
        throw new DataNotValidException();
    }
}
