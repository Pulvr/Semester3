package algorithms.helloworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    void helloWorld() {
        String helloWorldString = HelloWorld.helloWorld();
        assertEquals("Hello World", helloWorldString);
    }
}