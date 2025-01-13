package genericsagain.randomutil;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomUtilTest {

    @RepeatedTest(5)
    void randomElement() {
        Integer[] myArray = {1, 2, 3, 4, 5};
        int actualElement = RandomUtil.randomElement(myArray);
        assertTrue(Arrays.stream(myArray).toList().contains(actualElement));
    }
}