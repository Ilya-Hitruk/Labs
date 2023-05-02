package hw15;

public class Main {
    public static void main(String[] args) {

        Director director = new Director();

        PersonalComputer pc = director.createPersonalComputer();

        Laptop laptop = director.createLaptop();

        System.out.println(pc + "\n");
        System.out.println(laptop);
    }
}
