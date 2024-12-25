package callbacks.bigbrother;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigBrotherTest {

    @Test
    void subscribeAndNotifyOnNameChanged() {
        Person dennis = new Person("Dennis");
        Person ada = new Person("Ada");

        BigBrother bigBrother = new BigBrother()
                .add(dennis)
                .add(ada);

        dennis.setName("Ritchie");
        assertTrue(bigBrother.logContains("Dennis changed name to Ritchie"));

        ada.setName("Lovelace");
        assertTrue(bigBrother.logContains("Ada changed name to Lovelace"));
    }

    @Test
    void notifyIfNotSubscribedOnNameChanged() {
        Person dennis = new Person("Dennis");

        BigBrother bigBrother = new BigBrother();

        dennis.setName("Ritchie");
        assertFalse(bigBrother.logContains("Dennis changed name to Ritchie"));
    }
}