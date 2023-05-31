package hw13;


import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

@Builder
@ToString
public class CarLombok {
    private String model;
    @NonNull private TypeOfCar typeOfCar;
    private int horsePowers;
    private int mass;
    private int seats;
    private int fuelCapacity;
    @NonNull private Engine engine;



}
