package es.upsa.sbd2.Enumeraciones;

public enum Provincia {
    AVILA("Ávila"), BURGOS("Burgos"), LEON("León"),
    PALENCIA("Palencia"), SALAMANCA("Salamanca"), SEGOVIA("Segovia"),
    SORIA("Soria"), VALLADOLID("Valladolid"), ZAMORA("Zamora");

    private final String provincia;

    Provincia(String provincia) {
        this.provincia = provincia;
    }
}
