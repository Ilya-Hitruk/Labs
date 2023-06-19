package Patterns.AbstractFactory.ToyotaCars;

import Patterns.AbstractFactory.CarFactories.Coupe;

public class CoupeToyota extends Toyota implements Coupe {
    public CoupeToyota(int serialNumber, String model, double volumeOfEngine) {
        super(serialNumber, model, volumeOfEngine);
    }
}
