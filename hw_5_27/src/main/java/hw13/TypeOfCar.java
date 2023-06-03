package hw13;

public enum TypeOfCar {
    SEDAN("Sedan"),
    CABRIOLET("Cabriolet");

    private final String type;

    TypeOfCar(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}