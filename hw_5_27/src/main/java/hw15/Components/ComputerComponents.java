package hw15.Components;

public abstract class ComputerComponents {
    protected String name;
    protected int price;


    public ComputerComponents(int price, String name) {
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
