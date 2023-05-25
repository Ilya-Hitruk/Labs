package hw18.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListExampleTest {

    private LinkedListExample<Integer> listExample = new LinkedListExample<>();
    private static final Integer[] EXAMPLE = {4, 8, 15, 16, 23, 42};

    @BeforeEach
    void createList(){
        listExample.addAll(EXAMPLE);
    }

    @Test
    void add_Element() {
        // Arrange
        listExample = new LinkedListExample<>();
        int expected = 10;

        // Act
        listExample.add(expected);
        int actual = listExample.getFirst();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void add_Element_By_Index() {
        // Arrange
        int index = 4;
        int expected = 100;

        // Act
        listExample.add(index, expected);
        int actual = listExample.get(index);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void add_Element_By_Index_Out_Upper_Bound_Throws() {
        // Arrange
        int index = listExample.size() + 1;
        int value = 1;

        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> listExample.add(index, value));
    }
    @Test
    void add_Element_By_Index_Out_Lower_Bound_Throws() {
        // Arrange
        int index = -1;
        int value = 1;

        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> listExample.add(index, value));
    }

    @Test
    void set() {
        // Arrange
        int index = 4;
        int expected = 100;

        // Act
        listExample.set(index, expected);
        int actual = listExample.get(index);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void get() {
        // Arrange
        int index = 4;
        int expected = listExample.get(index);

        // Act
        int actual = listExample.get(index);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getFirst() {
        // Arrange
        int expected = 4;

        // Act
        int actual = listExample.getFirst();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getLast() {
        // Arrange
        int expected = 42;

        // Act
        int actual = listExample.getLast();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        // Arrange
        int index = 4;
        int expected = listExample.get(index);

        // Act
        int actual = listExample.remove(index);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void removeFirst() {
        // Arrange
        int expected = listExample.getFirst();

        // Act
        int actual = listExample.removeFirst();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void removeLast() {
        // Arrange
        int expected = listExample.getLast();

        // Act
        int actual = listExample.removeLast();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void contains_Existed_Element() {
        // Arrange
        boolean expected = true;

        // Act
        boolean actual = listExample.contains(listExample.getFirst());

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void contains_Not_Existed_Element() {
        // Arrange
        boolean expected = true;
        int notExistedNumber = 0;

        // Act
        boolean actual = listExample.contains(notExistedNumber);

        // Assert
        assertNotEquals(expected, actual);
    }

    @Test
    void isEmpty_Filled_List() {
        // Arrange
        boolean expected = false;

        // Act
        boolean actual = listExample.isEmpty();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void isEmpty_Empty_List() {
        // Arrange
        listExample = new LinkedListExample<>();
        boolean expected = true;

        // Act
        boolean actual = listExample.isEmpty();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void size() {
        // Arrange
        int expected = 6;

        // Act
        int actual = listExample.size();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void toArray() {

        // Act
        Object[] actual = listExample.toArray();

        // Assert
        assertArrayEquals(EXAMPLE, actual);
    }

    @Test
    void clear() {
        // Arrange
        boolean expected = true;

        // Act
        listExample.clear();
        boolean actual = listExample.isEmpty();

        // Assert
        assertEquals(expected, actual);
    }
}