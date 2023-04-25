package hw15;

import hw15.Components.*;
import hw15.Periphery.*;


public class Director {
    private static final Body body = new Body(50, "Computer body");
    private static final GPU gpu = new GPU(700, "Nvidia geForce");
    private static final HardDrive hardDrive = new HardDrive(100, "Hardware");
    private static final MotherBoard motherBoard = new MotherBoard(300, "MotherBoard");
    private static final Processor processor = new Processor(650, "Intel core i5");
    private static final RAM ram = new RAM(50, "Kingston");
    private static final Touchpad touchpad = new Touchpad(20, "Touchpad");
    private static final Keyboard keyboard = new Keyboard(30, "HyperX");
    private static final Monitor monitor = new Monitor(150, "MSI");
    private static final Mouse mouse = new Mouse(15, "Razor");
    private static final Headphones headphones = new Headphones(50, "Sony 3D pulse");


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
