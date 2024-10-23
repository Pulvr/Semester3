package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilTest {

    @Test
    void createLinkedListTest() {
        //Arrange
        List<String> actualList = ListUtil.createLinkedList();
        //Act
        List<String> expcected = List.of("This", "will", "be", "tested", "with", "JUnit");
        //Assert
        assertInstanceOf(LinkedList.class, actualList); //ist es wirklich eine Liste?
        assertEquals(actualList,expcected);             //stimmt der Inhalt?

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