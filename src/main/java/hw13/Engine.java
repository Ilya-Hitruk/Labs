package hw13;

public interface Engine {
    double DEFAULT_DISTANCE = 100;
    double getConsumption();
    double getConsumption(int distance);

    void onEngine();
    void offEngine();
}
