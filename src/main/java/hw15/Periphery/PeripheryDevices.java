package hw15.Periphery;

public class PeripheryDevices {
    protected int price;
    protected String name;

    public PeripheryDevices(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ", name='" + name +
                ", price=" + price + '\'' +
                '}' + "\n";
    }
}
