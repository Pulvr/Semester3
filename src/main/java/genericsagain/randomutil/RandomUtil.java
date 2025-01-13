package genericsagain.randomutil;

import java.util.Random;

public class RandomUtil {
    static <T> T randomElement(T[] myArray) {
        Random random = new Random();
        int randomValue = random.nextInt(myArray.length);
        return myArray[randomValue];
    }
}
