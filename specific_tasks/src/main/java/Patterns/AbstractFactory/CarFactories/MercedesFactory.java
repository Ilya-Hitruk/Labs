package Patterns.AbstractFactory.CarFactories;

import Patterns.AbstractFactory.MercedesCars.CabrioletMercedes;
import Patterns.AbstractFactory.MercedesCars.CoupeMercedes;
import Patterns.AbstractFactory.MercedesCars.SedanMercedes;
import Patterns.AbstractFactory.Models.MercedesTemplate;

public class MercedesFactory implements CarFactory {
    @Override
    public Sedan createSedan() {
        return new SedanMercedes(
                MercedesTemplate.SEDAN.getSERIAL_NUMBER(),
                MercedesTemplate.SEDAN.getMODEL(),
                MercedesTemplate.SEDAN.getVOLUME_OF_ENGINE());
    }

    @Override
    public Coupe createCoupe() {
        return new CoupeMercedes(
                MercedesTemplate.COUPE.getSERIAL_NUMBER(),
                MercedesTemplate.COUPE.getMODEL(),
                MercedesTemplate.COUPE.getVOLUME_OF_ENGINE());
    }

    @Override
    public Cabriolet createCabriolet() {
        return new CabrioletMercedes(
                MercedesTemplate.CABRIOLET.getSERIAL_NUMBER(),
                MercedesTemplate.CABRIOLET.getMODEL(),
                MercedesTemplate.CABRIOLET.getVOLUME_OF_ENGINE());
    }
}
