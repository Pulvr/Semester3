package genericmethodsdone.randomutil;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomUtilTest {

    @RepeatedTest(5)
    void randomElementTestInt() {
        Integer[] myArray = {1, 2, 3, 4, 5}; //primitive Datentypen nicht supported also Integer
        int randomIntElement = RandomUtil.randomElement(myArray);
        System.out.println(randomIntElement);
        assertThat(randomIntElement).isIn(Arrays.asList(myArray));
    }

    @RepeatedTest(5)
    void randomElementTestString() {
        String[] myStringArray = {"Dorothy", "Fred", "Richy", "Cayd"};
        String randomStringElement = RandomUtil.randomElement(myStringArray);
        System.out.println(randomStringElement);
        assertThat(randomStringElement).isIn(Arrays.asList(myStringArray));
    }

    @Test
    void testArrayEmpty() {
        Integer[] emptyArray = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> RandomUtil.randomElement(emptyArray));
        assertEquals("Array can't be null or empty", exception.getMessage());
    }

    @Test
    void testArrayNull() {
        String[] nullArray = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> RandomUtil.randomElement(nullArray));
        assertEquals("Array can't be null or empty", exception.getMessage());
    }
}