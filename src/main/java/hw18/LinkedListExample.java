package hw18;

import java.util.NoSuchElementException;
import java.util.Objects;


public class LinkedListExample<T> implements ListInterface<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else {
            this.last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size + 1);
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else if (index == size) {
            last.next = newNode;
            last = newNode;
        } else {
            Node<T> previous = getNodeByIndex(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }
        size++;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        node.element = element;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }

    @Override
    public T getFirst() {
        final Node<T> tempFirst = first;
        if (tempFirst == null)
            throw new NoSuchElementException();
        return tempFirst.element;
    }

    @Override
    public T getLast() {
        final Node<T> tempLast = last;
        if (tempLast == null)
            throw new NoSuchElementException();
        return tempLast.element;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> previous = getNodeByIndex(index - 1);
            removedElement = previous.next.element;
            previous.next = previous.next.next;
            if (index == size - 1) {
                last = previous;
            }
        }
        size--;
        return removedElement;
    }

    @Override
    public T removeFirst() {
        return remove(0);
    }

    @Override
    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(current.element.toString()).append("\n");
            current = current.next;
        }
        return stringBuilder.toString();
    }
}
