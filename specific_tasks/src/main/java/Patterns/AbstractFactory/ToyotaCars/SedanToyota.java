package Patterns.AbstractFactory.ToyotaCars;

import Patterns.AbstractFactory.CarFactories.Sedan;

public class SedanToyota extends Toyota implements Sedan {
    public SedanToyota(int serialNumber, String model, double volumeOfEngine) {
        super(serialNumber, model, volumeOfEngine);
    }
}
