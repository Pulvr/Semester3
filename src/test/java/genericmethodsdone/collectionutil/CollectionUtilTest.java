package genericmethodsdone.collectionutil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilTest {

    @Test
    void runAllTest() {
        List<String> executedTasks = new ArrayList<>();

        Thread theadWithNothing = new Thread(() -> executedTasks.add("nothing"));
        Runnable runTask = () -> executedTasks.add("again");

        Iterable<Runnable> runnableList = List.of(theadWithNothing, runTask);

        CollectionUtil.runAll(runnableList);

        assertThat(executedTasks).hasSize(2);
        assertEquals("nothing", executedTasks.get(0));
        assertEquals("again", executedTasks.get(1));
        assertTrue(executedTasks.contains("nothing"));
        assertTrue(executedTasks.contains("again"));
    }

    /**
     * mit Wildcards ist die Zielliste vom Typ Number und die Quelle von einem Beliebigen Numbers Typ
     */
    @Test
    void copNumbersWildcardsTest() {
        //Arrange
        List<Double> doubleList = new ArrayList<>(List.of(0.1, 1.3, 2.3, 3.3, 4.3));
        List<Number> targetListAsDouble = new ArrayList<>();
        //Act
        CollectionUtil.copyNumbersWildcards(doubleList, targetListAsDouble);
        //Assert
        assertEquals(List.of(0.1, 1.3, 2.3, 3.3, 4.3), targetListAsDouble);
    }

    /**
     * Ohne Wildcards müssen beide Listen vom selben Typ sein
     */
    @Test
    void copyNumbersNoWildCardsTest() {
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> targetList = new ArrayList<>();

        CollectionUtil.copyNumbers(integerList, targetList);

        assertEquals(List.of(1, 2, 3, 4), targetList);
    }

    @Test
    void findMaxInCollectionNumber() {
        List<Integer> integerList = new ArrayList<>(List.of(-2, -20, 3, 50));
        int maxElement = CollectionUtil.findMaxInList(integerList);
        System.out.println(maxElement);
        assertEquals(50, maxElement);
    }

    @Test
    void findMaxInCollectionStrings() {
        List<String> stringList = new ArrayList<>(List.of("Hans", "Hanna", "Petra", "Alf", "Zebra"));
        String maxElement = CollectionUtil.findMaxInList(stringList);
        System.out.println(maxElement);
        assertEquals("Zebra", maxElement);
    }

    @Test
    void findMaxEmptyList() {
        List<String> emptyList = new ArrayList<>();
        Exception exception = assertThrows(NoSuchElementException.class, () -> CollectionUtil.findMaxInList(emptyList));
        assertEquals("Liste ist leer", exception.getMessage());
    }

}
