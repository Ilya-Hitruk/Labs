package hw15;

import hw15.Periphery.*;
import hw15.Components.*;
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
