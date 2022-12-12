package es.upsa.sbd2.Enumeraciones;

public enum CategoriaAlojamiento {
    PRIMERA("1ª - 1 Estrella"), SEGUNDA("2ª - 2 Estrellas"),
    TERCERA("3ª - 3 Estrellas"), CUARTA("4ª - 4 Estrellas"),
    QUINTA("5ª - 5 Estrellas");

    private final String CategoriaAlojamiento;

    CategoriaAlojamiento(String categoriaAlojamiento) {
        this.CategoriaAlojamiento = categoriaAlojamiento;
    }
}
