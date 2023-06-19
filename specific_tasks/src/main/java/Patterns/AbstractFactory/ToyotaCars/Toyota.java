package Patterns.AbstractFactory.ToyotaCars;

public abstract class Toyota {
    private final int serialNumber;
    private final String model;
    private final double volumeOfEngine;

    public Toyota(int serialNumber, String model, double volumeOfEngine) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.volumeOfEngine = volumeOfEngine;
    }

    @Override
    public String toString() {
        return "Toyota{" +
                "serialNumber=" + serialNumber +
                ", model='" + model + '\'' +
                ", volumeOfEngine=" + volumeOfEngine +
                '}';
    }
}
