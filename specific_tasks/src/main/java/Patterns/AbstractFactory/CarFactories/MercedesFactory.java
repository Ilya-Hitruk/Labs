package Patterns.AbstractFactory.CarFactories;

import Patterns.AbstractFactory.MercedesCars.MercedesCars;

public class MercedesFactory implements CarFactory {
    @Override
    public Sedan createSedan() {
        return (Sedan) MercedesCars.SEDAN_MERCEDES.createCar();
    }

    @Override
    public Coupe createCoupe() {
        return (Coupe) MercedesCars.COUPE_MERCEDES.createCar();
    }

    @Override
    public Cabriolet createCabriolet() {
        return (Cabriolet) MercedesCars.CABRIOLET_MERCEDES.createCar();
    }
}
