package algorithms.mystack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void pushTest() {
        MyStack<Integer> myStack = new MyStack<>(new ArrayList<>(
                List.of(1, 2, 3, 4)
        ));
        myStack.push(5);
        myStack.push(6);
        int actualLastElement = myStack.pop();
        assertEquals(6, actualLastElement);
    }

    @Test
    void popTest() {
        MyStack<Integer> myStack = new MyStack<>(new ArrayList<>(
                List.of(3, 2, 1)
        ));
        myStack.pop();
        int myElement = myStack.pop();
        assertEquals(2, myElement);
    }

    @Test
    void isEmptyTest() {
        MyStack<String> myStringStack = new MyStack<>(new ArrayList<>(
                List.of("String1", "String2")
        ));
        myStringStack.pop();
        myStringStack.pop();

        assertTrue(myStringStack.isEmpty());
    }

    @Test
    void indexOutOfBoundsTest() {
        MyStack<Double> myDoubleStack = new MyStack<>(new ArrayList<>(
                List.of(1.1, 2.2)
        ));
        myDoubleStack.pop();
        myDoubleStack.pop();
        Exception e = assertThrows(IndexOutOfBoundsException.class, myDoubleStack::pop);
        assertEquals("Index is Out of Bounds", e.getMessage());

    }
}