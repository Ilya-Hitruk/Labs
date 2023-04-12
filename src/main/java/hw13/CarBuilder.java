package hw13;

public final class CarBuilder {
    private String model;
    private TypeOfCar typeOfCar;
    private int horsePowers;
    private int mass;
    private int seats;
    private int fuelCapacity;
    private Engine engine;

    public CarBuilder() {
    }

    public static CarBuilder aCar() {
        return new CarBuilder();
    }

    public CarBuilder withModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder withTypeOfCar(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
        return this;
    }

    public CarBuilder withHorsePowers(int horsePowers) {
        this.horsePowers = horsePowers;
        return this;
    }

    public CarBuilder withMass(int mass) {
        this.mass = mass;
        return this;
    }

    public CarBuilder withSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public CarBuilder withFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
        return this;
    }

    public CarBuilder withEngine(Engine engine) {
        this.engine = engine;
        return this;
    }


    public Car build() {
        return new Car(model, typeOfCar, horsePowers, mass, seats, fuelCapacity, engine);
    }
}
