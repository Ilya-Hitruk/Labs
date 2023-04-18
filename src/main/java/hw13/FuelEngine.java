package hw13;

public class FuelEngine implements Engine {

    private final double engineCapacity;
    private final int cylinders;
    private static boolean isStarted;

    public FuelEngine() {
        engineCapacity = 0;
        cylinders = 0;
    }

    public FuelEngine(double engineCapacity, int cylinders) {
        this.engineCapacity = engineCapacity;
        this.cylinders = cylinders;
    }

    private static final double COEFFICIENT_OF_CONSUMPTION =  3.2;

    @Override
    public double getConsumption() {
        return engineCapacity * COEFFICIENT_OF_CONSUMPTION;
    }

    @Override
    public double getConsumption(int distance) {
        return (distance / DEFAULT_DISTANCE) * getConsumption();
    }

    @Override
    public void onEngine() {
        if (isStarted) {
            System.out.println("Fuel engine is already ON");
            return;
        }
        System.out.println("On Fuel engine");
        isStarted = true;
    }

    @Override
    public void offEngine() {
        if (!isStarted) {
            System.out.println("Fuel engine is already OFF");
            return;
        }
        System.out.println("OFF Fuel engine");
        isStarted = false;
    }

    @Override
    public String toString() {
        return "FuelEngine{" +
                "engineCapacity=" + engineCapacity +
                ", cylinders=" + cylinders +
                '}';
    }


}
