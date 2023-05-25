package hw25;

import java.util.Iterator;

public interface TreeIterator<E> extends Iterator<E> {
    @Override
    boolean hasNext();

    @Override
    E next();
}
