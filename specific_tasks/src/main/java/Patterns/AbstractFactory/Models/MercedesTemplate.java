package Patterns.AbstractFactory.Models;

public enum MercedesTemplate {

    SEDAN(221, "Mercedes-Benz E63", 4.0),
    COUPE(202, "Mercedes-Benz C43 Coupe", 3.0),
    CABRIOLET(230, "Mercedes-Benz S53 Cabriolet", 5.5);

    private final int SERIAL_NUMBER;
    private final String MODEL;
    private final double VOLUME_OF_ENGINE;

    MercedesTemplate(int SERIAL_NUMBER, String MODEL, double VOLUME_OF_ENGINE) {
        this.SERIAL_NUMBER = SERIAL_NUMBER;
        this.MODEL = MODEL;
        this.VOLUME_OF_ENGINE = VOLUME_OF_ENGINE;
    }

    public int getSERIAL_NUMBER() {
        return SERIAL_NUMBER;
    }

    public String getMODEL() {
        return MODEL;
    }

    public double getVOLUME_OF_ENGINE() {
        return VOLUME_OF_ENGINE;
    }
}
