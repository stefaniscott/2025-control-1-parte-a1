package es.upm.grise.profundizacion.cruiseControl;

public class SpeedSetAboveSpeedLimitException extends Exception {
    public SpeedSetAboveSpeedLimitException(String mensaje) {
        super(mensaje);
    }
}

