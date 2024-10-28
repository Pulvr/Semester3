package org.unittest.listutil;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ListUtilTest {

    @Test
    void createLinkedListTest() {
        //Arrange
        List<String> actualList = ListUtil.createLinkedList();
        //Act
        List<String> expected = List.of("This", "will", "be", "tested", "with", "JUnit");
        //Assert
        assertInstanceOf(LinkedList.class, actualList); //ist es wirklich eine Liste?
        assertThat(expected).hasSize(6);   //Anzahl der Elemente testen
        assertEquals(actualList,expected);             //stimmt der Inhalt?
        //könnten schon zu viele asserts sein, eher für testzwecke
    }

    @Test
    void getMostFrequentElementTest() {
        //Arrange
        List<Integer> myList = List.of(1,2,3,3,2,0,0,0,0);
        int listResult = ListUtil.getMostFrequentElement(myList);
        assertEquals(0,listResult);
    }

    @Test
    void getMostFrequentElementSameElementTest(){
        List<Integer> myList = List.of(1,1,2,2);
        assertEquals(1,ListUtil.getMostFrequentElement(myList)); //1 wird erwartet, da es das erste Element ist, das häufiger war
    }

    @Test
    void getSingleElementTest(){
        List<Integer> myList = List.of(1);
        assertEquals(1,ListUtil.getMostFrequentElement(myList)); //ein einzelnes Element sollte alleine zurückgegeben werden
    }

    @Test
    void checkEmptyListTest(){
        List <Integer> emptyList = List.of();
        //wir erwarten eine NoSuchElementException wenn die Liste leer ist.
        assertThrows(NoSuchElementException.class, ()->ListUtil.getMostFrequentElement(emptyList));
    }
}