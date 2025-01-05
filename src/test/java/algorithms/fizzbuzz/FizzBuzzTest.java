package algorithms.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FizzBuzzTest {

    @Test
    void fizzBuzzMethodTest() {
        FizzBuzz fizzy = new FizzBuzz();
        List<String> actualList = fizzy.fizzBuzzMethod(1, 16);
        int fizzCounter = 0;
        int buzzCounter = 0;
        int fizzBuzzCounter = 0;
        for (String s : actualList) {
            System.out.println(s);
            if (s.equals("Fizz")) {
                fizzCounter++;
            } else if (s.equals("Buzz")) {
                buzzCounter++;
            } else if (s.equals("FizzBuzz")) {
                fizzBuzzCounter++;
            }
        }
        assertEquals(4, fizzCounter);
        assertEquals(2, buzzCounter);
        assertEquals(1, fizzBuzzCounter);
    }

    @Test
    void fizzBuzzNulltest() {
        FizzBuzz fizzBuzz = mock();
        List<String> actualList = fizzBuzz.fizzBuzzMethod(0, 0);
        assertIterableEquals(actualList, List.of());
    }
}