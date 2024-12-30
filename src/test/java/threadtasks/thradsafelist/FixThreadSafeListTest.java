package threadtasks.thradsafelist;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

class FixThreadSafeListTest {

    @RepeatedTest(5)
    void readWriteListShouldNotThrowAnyException() throws InterruptedException{
        boolean exceptionWasThrown = FixThreadSafeList.readWriteList();
        assertFalse(exceptionWasThrown);
    }
}