package hw15;

import hw15.Periphery.*;
import hw15.Components.*;
import lombok.*;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class PersonalComputer implements Computer {
    @NonNull private Body body;
    @NonNull private GPU gpu;
    @NonNull private Processor processor;
    @NonNull private HardDrive hardDrive;
    @NonNull private MotherBoard motherBoard;
    @NonNull private RAM ram;

    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;
    private Headphones headphones;

}
