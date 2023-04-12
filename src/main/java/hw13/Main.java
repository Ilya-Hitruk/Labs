package hw13;

import java.text.DecimalFormat;

public class Main {

//    private static final String MODEL_MERCEDES = "Mercedes";
//    private static final TypeOfCar TYPE_MERCEDES = TypeOfCar.SEDAN;
//    private static final int HORSE_POWERS_MERCEDES = 250;
//    private static final int MASS_MERCEDES = 1500;
//    private static final int SEATS_MERCEDES = 4;
//    private static final Engine ENGINE_MERCEDES = new FuelEngine(3.0, 6);


    private static final String MODEL_TESLA = "Tesla";
    private static final TypeOfCar TYPE_TESLA = TypeOfCar.CABRIOLET;
    private static final int HORSE_POWERS_TESLA = 300;
    private static final int MASS_TESLA = 1200;
    private static final int SEATS_TESLA = 4;
    private static final int FUEL_CAPACITY_TESLA = 1000;
    private static final Engine ENGINE_TESLA = new ElectricEngine(500, 4);


    private final static String EXAMPLE = "#0.00";
    private final static int DISTANCE = 1000;


    public static void main(String[] args) {


        Director director = new Director();

        Car fuelCar = director.constructFuelCar();
        System.out.println(fuelCar);
        System.out.println(new DecimalFormat(EXAMPLE).format(fuelCar.getEngine().getConsumption()));
        System.out.println(new DecimalFormat(EXAMPLE).format(fuelCar.getEngine().getConsumption(DISTANCE)));
        fuelCar.getEngine().offEngine();
        fuelCar.getEngine().onEngine();
        fuelCar.move(200);
        fuelCar.completeFuel();

        System.out.println();



        Car manualElectroCar = CarBuilder.aCar()
                .withModel(MODEL_TESLA)
                .withTypeOfCar(TYPE_TESLA)
                .withHorsePowers(HORSE_POWERS_TESLA)
                .withMass(MASS_TESLA)
                .withSeats(SEATS_TESLA)
                .withFuelCapacity(FUEL_CAPACITY_TESLA)
                .withEngine(ENGINE_TESLA)
                .build();

        System.out.println(manualElectroCar);

        System.out.println(new DecimalFormat(EXAMPLE).format(manualElectroCar.getEngine().getConsumption()));
        System.out.println(new DecimalFormat(EXAMPLE).format(manualElectroCar.getEngine().getConsumption(DISTANCE)));
        manualElectroCar.getEngine().onEngine();
        manualElectroCar.getEngine().offEngine();
        manualElectroCar.move(200);
        manualElectroCar.completeFuel();

    }
}
