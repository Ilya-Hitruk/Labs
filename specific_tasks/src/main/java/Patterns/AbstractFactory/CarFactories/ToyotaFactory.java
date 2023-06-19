package Patterns.AbstractFactory.CarFactories;

import Patterns.AbstractFactory.ToyotaCars.ToyotaCars;

public class ToyotaFactory implements CarFactory {
    @Override
    public Sedan createSedan() {
        return (Sedan) ToyotaCars.SEDAN_TOYOTA.createCar();
    }

    @Override
    public Coupe createCoupe() {
        return (Coupe) ToyotaCars.COUPE_TOYOTA.createCar();
    }

    @Override
    public Cabriolet createCabriolet() {
        return (Cabriolet) ToyotaCars.CABRIOLET_TOYOTA.createCar();
    }
}
