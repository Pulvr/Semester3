package algorithms.objectcaster;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectCasterTest {

    @Test
    void toSquaredIntegerListTest() {
        List<Integer> acutalList = ObjectCaster.toSquaredIntegerList(List.of(0, 1, 2, 3, 4, 5));
        assertIterableEquals(acutalList, List.of(0, 1, 4, 9, 16, 25));
    }

    @Test
    void toSquaredIntegerListWithFloatTest() {
        List<Integer> actualList = ObjectCaster.toSquaredIntegerList(List.of(1.1f, 2, 3.3f, 4));
        assertIterableEquals(actualList, List.of(1, 4, 9, 16));
    }

    @Test
    void emptyListTest() {
        List<Integer> emptyList = ObjectCaster.toSquaredIntegerList(List.of());
        assertIterableEquals(emptyList, List.of());
    }

    @Test
    void listWithString() {
        List<Integer> listWithStrings = ObjectCaster.toSquaredIntegerList(List.of("String", "1", 3, 3.3));
        assertIterableEquals(listWithStrings, List.of(9, 9));
    }
}