package es.upsa.sbd2.Enumeraciones;

import es.upsa.sbd2.DataNotValidException;

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

    //Se comprueba la coincidencia de la cadena del fichero con alguna de la cadena de la enumeracion
    public static TipoAlojamiento getTipoAlojamiento(String tipo)
    {
        for (TipoAlojamiento tipAl: TipoAlojamiento.values())
        {
            if (tipAl.tipoAlojamiento.equals(tipo))
            {
                return tipAl;
            }
        }
        throw new DataNotValidException();
    }
}
