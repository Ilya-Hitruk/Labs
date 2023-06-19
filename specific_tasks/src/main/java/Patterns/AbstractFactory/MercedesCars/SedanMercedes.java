package Patterns.AbstractFactory.MercedesCars;

import Patterns.AbstractFactory.CarFactories.Sedan;

public class SedanMercedes extends MercedesBenz implements Sedan {
    public SedanMercedes(int serialNumber, String model, double volumeOfEngine) {
        super(serialNumber, model, volumeOfEngine);
    }
}
