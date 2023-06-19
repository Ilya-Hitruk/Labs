package Patterns.AbstractFactory.ToyotaCars;

import Patterns.AbstractFactory.CarFactories.Cabriolet;

public class CabrioletToyota extends Toyota implements Cabriolet {
    public CabrioletToyota(int serialNumber, String model, double volumeOfEngine) {
        super(serialNumber, model, volumeOfEngine);
    }
}
