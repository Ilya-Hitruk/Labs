package hw18.Stack;

public interface StackInterface<E> {
    E push(E value);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}
