package hw15;

import hw15.Components.*;
import hw15.Periphery.Headphones;
import hw15.Periphery.Keyboard;
import hw15.Periphery.Monitor;
import hw15.Periphery.Mouse;
import lombok.*;


@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Laptop implements Computer {

    @NonNull private GPU gpu;
    @NonNull private Processor processor;
    @NonNull private HardDrive hardDrive;
    @NonNull private MotherBoard motherBoard;
    @NonNull private RAM ram;
    @NonNull private Touchpad touchpad;

    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;
    private Headphones headphones;

}
