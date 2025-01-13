package genericsagain.collectionutil;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilTest {

    @Test
    void runAllTest() {
        //muss über array laufen, weil die Zuweisung nicht verändert werden darf, jedoch der Wert
        final int[] callBacks = {0};
        Iterable<Runnable> runnables = List.of(
                () -> callBacks[0]++
        );
        CollectionUtil.runAll(runnables);
        assertEquals(1, callBacks[0]);
    }

    @Test
    void runMultipleTest() {
        int[] callBacks = {0};
        Runnable counter = () -> callBacks[0]++;
        Iterable<Runnable> runnables = List.of(counter, counter, counter);
        CollectionUtil.runAll(runnables);
        assertEquals(3, callBacks[0]);
    }
}