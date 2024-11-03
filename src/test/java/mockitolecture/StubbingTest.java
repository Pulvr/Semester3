package mockitolecture;

import org.junit.jupiter.api.Test;
import  java.util.LinkedList;

import static org.mockito.Mockito.*;

public class StubbingTest {

    @Test
    void demo(){
        //Man kann auch konkrete Klassen mocken, nicht nur Interfaces.
        //FYI: LinkedList würde man normalerweise nicht mocken(nur Demo).
        LinkedList<String> mockedList = mock();

        //Stubbint
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //Ausgabe: "first"
        System.out.println(mockedList.get(0));

        //Wirft RuntimeException
        System.out.println(mockedList.get(1));

        //Ausgabe: "null", da .get(999) nicht gestubbed wurde (gibt stattdessen einen typabhängigen default-wert zurück).
        System.out.println(mockedList.get(999));

        //Obwohl es möglich ist, einen Stubbed-Aufruf zu verifizieren, ist es überflüssig.
        verify(mockedList).get(0);

        //FYI: Stubbe nur Methoden, die auch von der zu testenden Klasse aufgerufen bzw. verwendet werden.
    }
}
