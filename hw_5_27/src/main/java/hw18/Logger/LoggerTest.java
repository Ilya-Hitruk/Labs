package hw18.Logger;

import hw18.LinkedList.LinkedListExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Optional;

public class LoggerTest  implements LoggerInterface {

    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    private final LinkedListExample<Integer> listExample;

    public LoggerTest() {
        this.listExample = new LinkedListExample<>();
    }

    @Override
    public void add(int value) {
        listExample.add(value);
    }

    @Override
    public void add(int value, int index) {
        try {
            listExample.add(index, value);
        } catch (IndexOutOfBoundsException e) {
            logger.warn("Index out of bounds");
        }
    }

    @Override
    public Optional<Integer> getFirst() {
        try {
            return Optional.of(listExample.getFirst());
        } catch (NoSuchElementException e) {
            logger.warn("No such element");
            return Optional.empty();
        }

    }
}
