package es.upsa.sbd2.Enumeraciones;

public enum CategoriaRestaurante {

    LUJO("Lujo - 5 Tenedores"), PRIMERA("1ª - 4 Tenedores"),
    SEGUNDA("2ª - 3 Tenedores"), TERCERA("3ª - 2 Tenedores"),
    CUARTA("4ª - 1 Tenedor");

    private final String CategoriaRestaurante;

    CategoriaRestaurante(String categoriaRestaurante) {
        this.CategoriaRestaurante= categoriaRestaurante;
    }
}
