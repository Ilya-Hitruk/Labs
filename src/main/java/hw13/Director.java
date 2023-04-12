package hw13;

public class Director {

    private static final String MODEL_MERCEDES = "Mercedes";
    private static final TypeOfCar TYPE_MERCEDES = TypeOfCar.SEDAN;
    private static final int HORSE_POWERS_MERCEDES = 250;
    private static final int MASS_MERCEDES = 1500;
    private static final int SEATS_MERCEDES = 4;
    private static final int FUEL_CAPACITY_MERCEDES = 60;
    private static final Engine ENGINE_MERCEDES = new FuelEngine(3.0, 6);


    private static final String MODEL_TESLA = "Tesla";
    private static final TypeOfCar TYPE_TESLA = TypeOfCar.CABRIOLET;
    private static final int HORSE_POWERS_TESLA = 300;
    private static final int MASS_TESLA = 1200;
    private static final int SEATS_TESLA = 4;
    private static final int FUEL_CAPACITY_TESLA = 500;
    private static final Engine ENGINE_TESLA = new ElectricEngine(500, 4);

    public Car constructFuelCar() {
        return CarBuilder.aCar()
                .withModel(MODEL_MERCEDES)
                .withTypeOfCar(TYPE_MERCEDES)
                .withHorsePowers(HORSE_POWERS_MERCEDES)
                .withMass(MASS_MERCEDES)
                .withSeats(SEATS_MERCEDES)
                .withFuelCapacity(FUEL_CAPACITY_MERCEDES)
                .withEngine(ENGINE_MERCEDES)
                .build();
    }


    public Car constructElectricCar() {
        return CarBuilder.aCar()
                .withModel(MODEL_TESLA)
                .withTypeOfCar(TYPE_TESLA)
                .withHorsePowers(HORSE_POWERS_TESLA)
                .withMass(MASS_TESLA)
                .withSeats(SEATS_TESLA)
                .withFuelCapacity(FUEL_CAPACITY_TESLA)
                .withEngine(ENGINE_TESLA)
                .build();
    }
}
