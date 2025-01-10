package algorithms.minmax;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FindMinMaxTest {

    @Test
    void findMinMaxTest() {
        Collection<Integer> integers = List.of(1, 2, 3, 4, 5, 0);
        MinMax minMax = FindMinMax.findMinMax(integers);
        assertEquals(0, minMax.min());
        assertEquals(5, minMax.max());
    }

    @Test
    void findMinMaxListDuplicatesTest() {
        Collection<Integer> integers = List.of(1, 1, 5, 2, 5, 2);
        MinMax minMax = FindMinMax.findMinMax(integers);
        assertEquals(1, minMax.min());
        assertEquals(5, minMax.max());
    }

    @Test
    void findMinMaxNegativesTest() {
        Collection<Integer> integers = List.of(-1, -2, -3, -4, -5);
        MinMax minMax = FindMinMax.findMinMax(integers);
        assertEquals(-5, minMax.min());
        assertEquals(-1, minMax.max());
    }

    @Test
    void findMinMaxOneValueTest() {
        Collection<Integer> singleValueList = List.of(1);
        MinMax minMax = FindMinMax.findMinMax(singleValueList);
        assertEquals(1, minMax.min());
        assertEquals(1, minMax.max());
    }

    @Test
    void findMinMaxListEmptyListTest() {
        Collection<Integer> integers = List.of();
        assertThrows(NoSuchElementException.class, () -> FindMinMax.findMinMax(integers));
    }

    @Test
    void findMinMaxListNullTest() {
        assertThrows(NullPointerException.class, () -> FindMinMax.findMinMax(null));
    }
}