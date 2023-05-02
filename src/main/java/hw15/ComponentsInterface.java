package hw15;

import hw15.Periphery.*;
import hw15.Components.*;

public interface ComponentsInterface {
    Body body = new Body(50, "Computer body");
    GPU gpu = new GPU(700, "Nvidia geForce");
    HardDrive hardDrive = new HardDrive(100, "Hardware");
    MotherBoard motherBoard = new MotherBoard(300, "MotherBoard");
    Processor processor = new Processor(650, "Intel core i5");
    RAM ram = new RAM(50, "Kingston");
    Touchpad touchpad = new Touchpad(20, "Touchpad");
    Keyboard keyboard = new Keyboard(30, "HyperX");
    Monitor monitor = new Monitor(150, "MSI");
    Mouse mouse = new Mouse(15, "Razor");
    Headphones headphones = new Headphones(50, "Sony 3D pulse");
}
