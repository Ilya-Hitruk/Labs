package hw25;


import java.util.Iterator;

public interface  BinaryTreeInterface<E> extends Iterable<E> {
    void add(E element);
    void remove(E element);
    void set(E oldValue, E newValue);
    boolean contains(E element);
    Iterator<E> iterator();
    int size();
}
