package hw13;

public enum TypeOfCar {
    SEDAN("Sedan"),
    COUPE("Coupe"),
    CABRIOLET("Cabriolet");

    private final String type;

    TypeOfCar(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}