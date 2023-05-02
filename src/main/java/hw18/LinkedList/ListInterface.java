package hw18.LinkedList;

public interface ListInterface<T> extends Iterable<T>, Comparable<T> {
    void add(T element);
    void add(int index, T element);
    void set(int index, T element);
    T get(int index);
    T getFirst();
    T getLast();
    T remove(int index);
    T removeFirst();
    T removeLast();

    boolean contains(T element);
    boolean isEmpty();
    int size();
    void clear();

}