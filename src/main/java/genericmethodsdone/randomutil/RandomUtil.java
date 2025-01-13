package genericmethodsdone.randomutil;

import java.util.Random;

public class RandomUtil {
    static <T> T randomElement(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array can't be null or empty");
        }
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
}