package Patterns.AbstractFactory.CarFactories;

public interface CarFactory {
    Sedan createSedan();
    Coupe createCoupe();
    Cabriolet createCabriolet();
}
