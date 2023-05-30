package hw25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class BinaryTreeExampleTest {

    private BinaryTreeInterface<Integer> binaryTree;
    private static final Integer[] EXAMPLE = {12, 47, 12, 96, 1, 7};

    @BeforeEach
    void createAndFillTree() {
        binaryTree = new BinaryTreeExample<>();
    }

    @Test
    void add_Element_In_Empty_Tree() {
        // Arrange
        Integer number = 10;

        // Act
        binaryTree.add(number);
        boolean actual = binaryTree.contains(number);

        // Assert
        assertTrue(actual);
    }

    @Test
    void add_Element_In_Tree_With_One_Root() {
        // Arrange
        Integer root = EXAMPLE[0];
        Integer number = EXAMPLE[1];

        // Act
        binaryTree.add(root);
        binaryTree.add(number);
        boolean actual = binaryTree.contains(number);

        // Assert
        assertTrue(actual);
    }

    @Test
    void add_Element_In_Tree_With_Two_Elements() {
        // Arrange
        Integer root = EXAMPLE[0];
        Integer first = EXAMPLE[1];
        Integer second = EXAMPLE[2];

        // Act
        binaryTree.add(root);
        binaryTree.add(first);
        binaryTree.add(second);
        boolean actual = binaryTree.contains(second);

        // Assert
        assertTrue(actual);
    }

    @Test
    void add_Element_In_Filled_Tree() {
        // Arrange
        for(Integer value: EXAMPLE) {
            binaryTree.add(value);
        }
        int number = -1;

        // Act
        binaryTree.add(number);
        boolean actual = binaryTree.contains(number);

        // Assert
        assertTrue(actual);
    }
    @Test
    void remove_Element_With_Only_Root() {
        // Arrange
        Integer number = EXAMPLE[0];

        // Act
        binaryTree.add(number);
        binaryTree.remove(number);
        boolean actual = binaryTree.contains(number);

        // Assert
        assertFalse(actual);
    }

    @Test
    void remove_Element_In_Tree_With_Two_Elements() {
        // Arrange
        Integer root = EXAMPLE[0];
        Integer number = EXAMPLE[1];

        // Act
        binaryTree.add(root);
        binaryTree.add(number);
        binaryTree.remove(number);
        boolean actual = binaryTree.contains(number);

        // Assert
        assertFalse(actual);
    }

    @Test
    void remove_Element_In_Filled_Tree() {
        // Arrange
        for (Integer value: EXAMPLE) {
            binaryTree.add(value);
        }

        // Act
        binaryTree.remove(EXAMPLE[5]);
        boolean actual = binaryTree.contains(EXAMPLE[5]);

        // Assert
        assertFalse(actual);
    }

    @Test
    void set() {
        // Arrange
        for (Integer value: EXAMPLE) {
            binaryTree.add(value);
        }
        Integer newValue = 100;
        // Act


        binaryTree.set(EXAMPLE[5], newValue);
        boolean actual = binaryTree.contains(newValue);

        // Assert
        assertTrue(actual);
    }

    @Test
    void contains() {
        // Arrange
        for (Integer value: EXAMPLE) {
            binaryTree.add(value);
        }
        // Act

        boolean actual = binaryTree.contains(EXAMPLE[4]);

        // Assert
        assertTrue(actual);
    }

    @Test
    void size() {
        // Arrange
        for (Integer value: EXAMPLE) {
            binaryTree.add(value);
        }
        // Act

        int actual = binaryTree.size();

        // Assert
        assertEquals(EXAMPLE.length, actual);
    }
}