package threadtasks;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringAdderAppTest {

    @Test
    void computeTest() throws InterruptedException {
        int aCounter = 0;
        int bCounter = 0;

        List<String> actualList = StringAdderApp.compute(10);

        for (String s : actualList) {
            if (s.equals("a")) {
                aCounter++;
            } else {
                bCounter++;
            }
        }

        assertEquals(10,aCounter);
        assertEquals(10,bCounter);
    }

    @Test
    void emptyListOfStringAdder() throws InterruptedException {
        List<String> actualList = StringAdderApp.compute(0);
        assertTrue(actualList.isEmpty());
    }
}