package Patterns.AbstractFactory.CarFactories;

import Patterns.AbstractFactory.Models.ToyotaTemplate;
import Patterns.AbstractFactory.ToyotaCars.CabrioletToyota;
import Patterns.AbstractFactory.ToyotaCars.CoupeToyota;
import Patterns.AbstractFactory.ToyotaCars.SedanToyota;

public class ToyotaFactory implements CarFactory {
    @Override
    public Sedan createSedan() {
        return new SedanToyota(
                ToyotaTemplate.SEDAN.getSERIAL_NUMBER(),
                ToyotaTemplate.SEDAN.getMODEL(),
                ToyotaTemplate.SEDAN.getVOLUME_OF_ENGINE());
    }

    @Override
    public Coupe createCoupe() {
        return new CoupeToyota(
                ToyotaTemplate.COUPE.getSERIAL_NUMBER(),
                ToyotaTemplate.COUPE.getMODEL(),
                ToyotaTemplate.COUPE.getVOLUME_OF_ENGINE());
    }

    @Override
    public CabrioletToyota createCabriolet() {
        return new CabrioletToyota(
                ToyotaTemplate.CABRIOLET.getSERIAL_NUMBER(),
                ToyotaTemplate.CABRIOLET.getMODEL(),
                ToyotaTemplate.CABRIOLET.getVOLUME_OF_ENGINE());
    }
}
