package Patterns.AbstractFactory.MercedesCars;

import Patterns.AbstractFactory.CarFactories.Cabriolet;

public class CabrioletMercedes extends MercedesBenz implements Cabriolet {

    public CabrioletMercedes(int serialNumber, String model, double volumeOfEngine) {
        super(serialNumber, model, volumeOfEngine);
    }
}
