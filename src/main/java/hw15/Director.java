package hw15;

public class Director implements ComponentsInterface {

    public PersonalComputer createPersonalComputer() {
        return PersonalComputer.builder()
                .gpu(gpu)
                .body(body)
                .ram(ram)
                .processor(processor)
                .hardDrive(hardDrive)
                .motherBoard(motherBoard)
                .monitor(monitor)
                .mouse(mouse)
                .keyboard(keyboard)
                .build();
    }

    public Laptop createLaptop() {
        return Laptop.builder()
                .gpu(gpu)
                .ram(ram)
                .processor(processor)
                .hardDrive(hardDrive)
                .motherBoard(motherBoard)
                .touchpad(touchpad)
                .headphones(headphones)
                .build();
    }
}
