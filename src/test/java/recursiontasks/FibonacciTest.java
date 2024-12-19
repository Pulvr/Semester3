package recursiontasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacciRecursiveWith0() { assertEquals(0, Fibonacci.fibonacciRecursive(0)); }
    @Test
    void fibonacciRecursiveWith1() {assertEquals(1, Fibonacci.fibonacciRecursive(1)); }
    @Test
    void fibonacciRecursiveWith2() { assertEquals(1, Fibonacci.fibonacciRecursive(2)); }
    @Test
    void fibonacciRecursiveWith3() { assertEquals(2, Fibonacci.fibonacciRecursive(3)); }
    @Test
    void fibonacciRecursiveWith4() { assertEquals(3, Fibonacci.fibonacciRecursive(4)); }
    @Test
    void fibonacciRecursiveWith5() { assertEquals(5, Fibonacci.fibonacciRecursive(5)); }
    @Test
    void fibonacciRecursiveWith6() { assertEquals(8, Fibonacci.fibonacciRecursive(6)); }
    @Test
    void fibonacciRecursiveWith7() { assertEquals(13, Fibonacci.fibonacciRecursive(7)); }
    @Test
    void fibonacciRecursiveWith8() { assertEquals(21, Fibonacci.fibonacciRecursive(8)); }
    @Test
    void fibonacciRecursiveWith9() { assertEquals(34, Fibonacci.fibonacciRecursive(9)); }
    @Test
    void fibonacciRecursiveWith10() { assertEquals(55, Fibonacci.fibonacciRecursive(10)); }

}