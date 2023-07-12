package Patterns.AbstractFactory.Models;

public enum ToyotaTemplate {

    SEDAN(155, "Camry", 3.5),
    COUPE(140, "Supra", 3.0),
    CABRIOLET(110, "Solar", 2.0);

    private final int SERIAL_NUMBER;
    private final String MODEL;
    private final double VOLUME_OF_ENGINE;

    ToyotaTemplate(int SERIAL_NUMBER, String MODEL, double VOLUME_OF_ENGINE) {
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
