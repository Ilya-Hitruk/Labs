package hw18.LinkedList;

import java.util.stream.Stream;

public interface ListInterface<T> extends Iterable<T>{
    void add(T element);
    void add(int index, T element);
    void set(int index, T element);
    T get(int index);
    T getFirst();
    T getLast();
    T remove(int index);
    T removeFirst();
    T removeLast();
    void addAll(T[] array);

    boolean contains(T element);
    boolean isEmpty();
    int size();
    void clear();
    Object[] toArray();
    void sort(boolean order);
    Stream<T> stream();
}