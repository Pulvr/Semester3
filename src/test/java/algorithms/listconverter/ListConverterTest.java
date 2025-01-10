package algorithms.listconverter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListConverterTest {

    @Test
    void toArrayTest() {
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        ListConverter converter = new ListConverter();

        Integer[] actualArray = converter.toArray(myList);
        Integer[] expectedArray = {1, 2, 3};

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void toListTest() {
        Integer[] myArray = {1, 2, 3};
        ListConverter converter = new ListConverter();
        List<Integer> actualList = converter.toList(myArray);
        assertIterableEquals(List.of(1, 2, 3), actualList);
    }

    @Test
    void emptyListTest() {
        List<Integer> emptyList = new ArrayList<>();
        ListConverter converter = new ListConverter();
        Exception e = assertThrows(ListEmptyException.class, () -> converter.toArray(emptyList));
        assertEquals("Liste darf nicht leer sein", e.getMessage());
    }
}