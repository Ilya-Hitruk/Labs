package Patterns.AbstractFactory.MercedesCars;

public abstract class MercedesBenz {
    private final int serialNumber;
    private final String model;
    private final double volumeOfEngine;

    public MercedesBenz(int serialNumber, String model, double volumeOfEngine) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.volumeOfEngine = volumeOfEngine;
    }

    @Override
    public String toString() {
        return "MercedesBenz{" +
                "serialNumber=" + serialNumber +
                ", model='" + model + '\'' +
                ", volumeOfEngine=" + volumeOfEngine +
                '}';
    }
}
