package hw13;

import java.util.Objects;

public class Car implements CarInterface {
    private static final int FULL_BACK_FUEL = 60;
    private static final int FULL_CHARGE_ELECTRIC = 1000;
    private String model;
    private TypeOfCar typeOfCar;
    private int horsePowers;
    private int mass;
    private int seats;
    private int fuelCapacity;
    private Engine engine;

    public Car(){}

    public Car(String model, TypeOfCar typeOfCar, int horsePowers, int mass, int seats, int fuelCapacity, Engine engine) {
        this.model = model;
        this.typeOfCar = typeOfCar;
        this.horsePowers = horsePowers;
        this.mass = mass;
        this.seats = seats;
        this.fuelCapacity = fuelCapacity;
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }


    @Override
    public void move(int distance) {
        if (this.engine instanceof FuelEngine) {
           overcomeDistance(distance);
        }
        if (this.engine instanceof ElectricEngine) {
            overcomeDistance(distance);
        }

    }

    @Override
    public void completeFuel() {
        if (this.engine instanceof FuelEngine) {
            this.fuelCapacity = FULL_BACK_FUEL;
        }
        if (this.engine instanceof ElectricEngine) {
            this.fuelCapacity = FULL_CHARGE_ELECTRIC;
        }
        System.out.println("Bac is full " + this.fuelCapacity + "\n");
    }

    private void overcomeDistance(int distance) {
        if ((distance / this.engine.getConsumption()) > fuelCapacity) {
            System.out.println("Not enough fuel\n");
            return;
        }
        this.fuelCapacity -= (int)this.engine.getConsumption(distance);
        System.out.printf("You overcame %d km. Bac capacity = %d\n", distance, this.fuelCapacity);
    }




    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine=" + engine +
                ", typeOfCar=" + typeOfCar.getType() +
                ", horsePowers=" + horsePowers +
                ", mass=" + mass +
                ", seats=" + seats +
                ", fuelCapacity=" + fuelCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return horsePowers == car.horsePowers && mass == car.mass && seats == car.seats && fuelCapacity == car.fuelCapacity && Objects.equals(model, car.model) && typeOfCar == car.typeOfCar && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, typeOfCar, horsePowers, mass, seats, fuelCapacity, getEngine());
    }
}
