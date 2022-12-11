package es.upsa.sbd2.Enumeraciones;

public enum TipoAlojamiento {
    HOSTAL("Hostal"), HOSTAL_RESIDENCIA("Hostal Residencia"),
    HOTEL("Hotel"), HOTEL_APARTAMENTO("Hotel Apartamento"),
    HOTEL_RESIDENCIA("Hotel Residencia"), MOTEL("Motel"),
    MOTEL_RESIDENCIA("Motel Residencia"), PENSION("Pensión"),
    RESIDECNIA_APARTAMENTO("Residencia Apartamento");

    private final String tipoAlojamiento;

    TipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }
}
