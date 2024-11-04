package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @BeforeEach
    void setup(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void fizzBuzzMethodSizeTest() {
        LinkedList<String> result = fizzBuzz.fizzBuzzMethod(1,16);
        assertThat(result).hasSize(15);
    }

    @Test
    void fizzBuzzAmountTest(){
        List<String> result = fizzBuzz.fizzBuzzMethod(1,16);
        assertEquals("FizzBuzz", result.get(14));
    }
}