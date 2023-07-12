package Patterns.AbstractFactory;

import Patterns.AbstractFactory.CarFactories.*;

public class Main {
    public static void main(String[] args) {

        CarFactory mercedesFactory = new MercedesFactory();
        CarFactory toyotaFactory = new ToyotaFactory();

        Sedan sedanM = mercedesFactory.createSedan();
        Coupe coupeM = mercedesFactory.createCoupe();
        Cabriolet cabrioletM = mercedesFactory.createCabriolet();

        Sedan sedanT = toyotaFactory.createSedan();
        Coupe coupeT = toyotaFactory.createCoupe();
        Cabriolet cabrioletT = toyotaFactory.createCabriolet();

        System.out.println(sedanM);
        System.out.println(coupeM);
        System.out.println(cabrioletM);
        System.out.println();
        System.out.println(sedanT);
        System.out.println(coupeT);
        System.out.println(cabrioletT);


    }
}
