package Patterns.AbstractFactory.MercedesCars;

import Patterns.AbstractFactory.CarFactories.Coupe;

public class CoupeMercedes extends MercedesBenz implements Coupe {
    public CoupeMercedes(int serialNumber, String model, double volumeOfEngine) {
        super(serialNumber, model, volumeOfEngine);
    }
}
