package hw18.Logger;

import java.util.Optional;

public interface LoggerInterface {
    void add(int value);
    void add(int value, int index);
    Optional<Integer> getFirst();
}
