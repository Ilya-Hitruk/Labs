package hw13;

public class ElectricEngine implements Engine {

    private final int batteryCapacity;
    private final int countOfCoils;
    private static boolean isStarted;

    public ElectricEngine(int batteryCapacity, int countOfCoils) {
        this.batteryCapacity = batteryCapacity;
        this.countOfCoils = countOfCoils;
        isStarted = false;
    }

    private static final double COEFFICIENT_OF_CONSUMPTION =  0.3;

    @Override
    public double getConsumption() {
        return batteryCapacity * COEFFICIENT_OF_CONSUMPTION;
    }

    @Override
    public double getConsumption(int distance) {
        return (distance / DEFAULT_DISTANCE) * getConsumption();
    }

    @Override
    public void onEngine() {
        if (isStarted) {
            System.out.println("Electric engine is already ON");
            return;
        }
        System.out.println("On electric engine");
        isStarted = true;
    }

    @Override
    public void offEngine() {
        if (!isStarted) {
            System.out.println("Electric engine is already OFF");
            return;
        }
        System.out.println("OFF electric engine");
        isStarted = false;
    }

    @Override
    public String toString() {
        return "ElectricEngine{" +
                "batteryCapacity=" + batteryCapacity +
                ", countOfCoils=" + countOfCoils +
                '}';
    }
}
