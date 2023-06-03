package hw25;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class BinaryTreeExample<E extends Comparable<E>> implements BinaryTreeInterface<E> {

    public BinaryTreeExample() {
        this.size = 0;
        this.root = null;
    }

    private int size;

    private Node<E> root;

    private static final class BinaryTreeIterator<E> implements TreeIterator<E> {

            private final Queue<E> nodeList;

            public BinaryTreeIterator(Node<E> root) {
                this.nodeList = new ArrayDeque<>();
                traverseInOrder(root);
            }

            private void traverseInOrder(Node<E> current) {
                if (Objects.nonNull(current)) {
                    traverseInOrder(current.left);
                    nodeList.add(current.value);
                    traverseInOrder(current.right);
                }
            }

        @Override
        public boolean hasNext() {
            return nodeList.size() != 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("BINARY_TREE_IS_EMPTY");
            }
            return nodeList.poll();
        }
    }

    private static class Node <E> {
        E value;
        Node<E> left;
        Node<E> right;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    @Override
    @NotNull
    public Iterator<E> iterator() {
        return new BinaryTreeIterator<>(root);
    }
    @Override
    public void add(E element) {
        root = insertNode(root, element);
        size++;
    }

    @Override
    public void remove(E element) {
        root = removeNodeRecursion(root, element);
    }

    @Override
    public void set(E oldValue, E newValue) {
        if (contains(oldValue)) {
            remove(oldValue);
            add(newValue);
        }
    }

    @Override
    public boolean contains(E element) {
        return searchNode(root, element);
    }

    @Override
    public int size() {
        return size;
    }


    private Node<E> insertNode(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = insertNode(current.left, value);
        }

        if (value.compareTo(current.value) > 0) {
            current.right = insertNode(current.right, value);
        }

        return current;
    }

    private boolean searchNode(Node<E> current, E value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        } else if (value.compareTo(current.value) < 0) {
            return searchNode(current.left, value);
        } else {
            return searchNode(current.right, value);
        }
    }

    private Node<E> removeNodeRecursion(Node<E> root, E value) {
        if (Objects.isNull(root)) {
            return null;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = removeNodeRecursion(root.left, value);
        }

        if (value.compareTo(root.value) > 0) {
            root.right = removeNodeRecursion(root.right, value);
        }

        else {
            root = removeNode(root);
        }
        return root;
    }

    @Nullable
    private Node<E> removeNode(Node<E> root) {
        // Узел для удаления найден

        // Случай 1: Узел без потомков
        if (root.left == null && root.right == null) {
            return null;
        }
        // Случай 2: Узел с одним потомком
        if (Objects.requireNonNull(root).left == null) {
            root = root.right;
        } else if (root.right == null) {
            root = root.left;
        }
        // Случай 3: Узел с двумя потомками
        else {
            Node<E> minNode = findMin(root.right);
            root.value = minNode.value;
            root.right = removeNodeRecursion(root.right, minNode.value);
        }
        return root;
    }

    private Node<E> findMin(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
