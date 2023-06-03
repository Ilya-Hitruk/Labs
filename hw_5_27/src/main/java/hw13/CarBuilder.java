package hw13;

public final class CarBuilder {

    private final Car car;

    public CarBuilder() {
        car = new Car();
    }

    public CarBuilder withModel(String model) {
        car.setModel(model);
        return this;
    }

    public CarBuilder withTypeOfCar(TypeOfCar typeOfCar) {
        car.setTypeOfCar(typeOfCar);
        return this;
    }

    public CarBuilder withHorsePowers(int horsePowers) {
        car.setHorsePowers(horsePowers);
        return this;
    }

    public CarBuilder withMass(int mass) {
        car.setMass(mass);
        return this;
    }

    public CarBuilder withSeats(int seats) {
        car.setSeats(seats);
        return this;
    }

    public CarBuilder withFuelCapacity(int fuelCapacity) {
        car.setFuelCapacity(fuelCapacity);
        return this;
    }

    public CarBuilder withEngine(Engine engine) {
        car.setEngine(engine);
        return this;
    }

    public Car build() {
        return car;
    }
}
