package hw18.LinkedList;


import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class LinkedListExample<T extends Comparable<T>> implements ListInterface<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private Comparator<T> reverseComparator() {
        return new ReversedListComparator();
    }

    private final class ListIterator implements Iterator<T> {
        private Node<T> current;
        private int index;

        public ListIterator() {
            this.current = first;
            index = 0;
        }
        @Override
        public boolean hasNext() {
            if (Objects.isNull(current)) {
                throw new NoSuchElementException("No such element");
            }

            return Objects.nonNull(current.next);
        }
        @Override
        public T next() {

            if (!hasNext()) {
                throw new IllegalArgumentException("Element doesn't exists");
            }

            if(index == 0) {
                index++;
                return first.value;
            }

            current = current.next;
            index++;
            return current.value;
        }
    }

    private final class ListComparator implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
        @Override
        public Comparator<T> reversed() {
            return new ReversedListComparator();
        }
    }

    private final class ReversedListComparator implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o2.compareTo(o1);
        }
        @Override
        public Comparator<T> reversed() {
            return new ListComparator();
        }
    }

    @Override
    public void add(T value) {
        linkLast(value);
    }

    @Override
    public void add(int index, T value) {
        Objects.checkIndex(index, size + 1);
        final Node<T> newNode = new Node<>(null, value, null);
        if (first == null) {
            first = last = newNode;
            size++;
        } else if (index == 0) {
            linkFirst(value);
        } else if (index == size) {
            linkLast(value);
        } else {
            Node<T> previous = getNodeByIndex(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
            newNode.previous = previous.previous;
            size++;
        }
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        node.value = element;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).value;
    }

    @Override
    public T getFirst() {
        final Node<T> tempFirst = first;
        if (Objects.isNull(first)) {
            throw new NoSuchElementException();
        }
        return tempFirst.value;
    }

    @Override
    public T getLast() {
        final Node<T> tempLast = last;
        if (tempLast == null)
            throw new NoSuchElementException();
        return tempLast.value;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = removeFirstElement();
        } else {
            removedElement = removeElement(index);
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
            if (current.value.equals(element)) {
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
    public Object[] toArray() {
        Object[] arrayOfList = new Object[size];
        Node<T> temp = first;
        int i = 0;
        while (Objects.nonNull(temp)){
            arrayOfList[i] = temp.value;
            temp = temp.next;
            i++;
        }
        return arrayOfList;
    }

    @Override
    public void addAll(T[] array) {
            for (T value : array) {
                add(value);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void sort(boolean order) {
        Object[] arrayOfList = toArray();

        if (order) {
            Arrays.sort(arrayOfList);
        } else {
            Arrays.sort(arrayOfList, (Comparator) reverseComparator());
        }
        for (int i = 0; i < arrayOfList.length; i++) {
            set(i, (T)arrayOfList[i]);
        }
    }
    @Override
    public Stream<T> stream() {
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(iterator(), Spliterator.SIZED);
        return StreamSupport.stream(spliterator, true);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(current.value.toString()).append("\n");
            current = current.next;
        }
        return stringBuilder.toString();
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void linkFirst(T value) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(null, value, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.previous = newNode;
        size++;
    }

    private void linkLast(T value) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private T removeFirstElement() {
        T removed = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return removed;
    }

    private T removeElement(int index) {
        T removed;
        Node<T> previous = getNodeByIndex(index - 1);
        removed = previous.next.value;
        previous.next = previous.next.next;
        if (index == size - 1) {
            last = previous;
        }
        return removed;
    }
}