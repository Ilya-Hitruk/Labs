package hw18.Stack;


import java.util.EmptyStackException;

public class StackExample<E> implements StackInterface<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public E push(E value) {
        head = new Node<>(value, head);
        size++;
        return value;
    }

    @Override
    public E pop() {
        if (head != null) {
            E value = head.value;
            head = head.next;
            size--;
            return value;
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public E peek() {
        if (head != null) {
            return head.value;
        }
        else {
            throw new EmptyStackException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(current.value.toString()).append("\n");
            current = current.next;
        }
        return stringBuilder.toString();
    }
}
