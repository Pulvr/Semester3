package mockitolecture;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ArgumentMatchers {

    @Test
    void demo() {
        List<String> mockedList = mock();
        // Stubbing mit anyInt()-Matcher
        when(mockedList.get(anyInt())).thenReturn("element"); // wenn get mit irgendeinen int-Wert aufgerufen, dann gebe "element" zurück.

        // Stubbing ist nur notwendig, wenn der Rückgabewert eine Rolle spielt (siehe .thenReturn).
        // Ansonsten lassen sich die Methoden der gemockten Klasse auch einfach direkt aufrufen:
        mockedList.add("Hänno"); // Aufruf ohne stubbing

        // Ausgabe: "element"
        System.out.println(mockedList.get(999));

        // Ausgabe: false
        System.out.println(mockedList.contains("Elon"));

        // Argument Matchers funktionieren auch mit verify.
        verify(mockedList).get(anyInt());
        verify(mockedList).add(anyString());
    }
}