package es.upsa.sbd2.Enumeraciones;

import es.upsa.sbd2.DataNotValidException;

public enum Provincia {
    AVILA("Ávila"), BURGOS("Burgos"), LEON("León"),
    PALENCIA("Palencia"), SALAMANCA("Salamanca"), SEGOVIA("Segovia"),
    SORIA("Soria"), VALLADOLID("Valladolid"), ZAMORA("Zamora");

    private final String provincia;

    Provincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvinciaString()
    {
        return provincia;
    }

    //En este caso se recorre la enumeracion hasta dar con la provincia que aparece en los ficheros
    public static Provincia getProvincia(String provincia)
    {
        for (Provincia prov: Provincia.values())
        {
            if (prov.provincia.equals(provincia))
            {
                return prov;
            }
        }
        throw new DataNotValidException();
    }
}
