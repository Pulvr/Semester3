package algorithms.linearsearch;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    @Test
    void findIndexOfNumberTest() {
        Collection<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int actualIndex = LinearSearch.findIndexOfNumber(numbers, 3); // 2
        assertEquals(2, actualIndex);
    }

    @Test
    void numberNotFoundTest() {
        Collection<Integer> notFoundList = List.of(1, 2, 3, 4, 5);
        int actualIndex = LinearSearch.findIndexOfNumber(notFoundList, 6);
        assertEquals(-1, actualIndex);
    }

    @Test
    void emptyListTest() {
        Collection<Integer> emptyList = List.of();
        int actualIndex = LinearSearch.findIndexOfNumber(emptyList, 1);
        assertEquals(-1, actualIndex);
    }

    @Test
    void findNumberAtEndOfList() {
        Collection<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int actualIndex = LinearSearch.findIndexOfNumber(numbers, 5);
        assertEquals(4, actualIndex);
    }

    @Test
    void findNumberAtBeginningOfList() {
        Collection<Integer> numbers = List.of(1);
        int actualIndex = LinearSearch.findIndexOfNumber(numbers, 1);
        assertEquals(0, actualIndex);
    }

    @Test
    void listIsNullTest() {
        Exception e = assertThrows(NullPointerException.class, () -> LinearSearch.findIndexOfNumber(null, 1));
        assertEquals("Liste darf nicht leer sein", e.getMessage());
    }
}