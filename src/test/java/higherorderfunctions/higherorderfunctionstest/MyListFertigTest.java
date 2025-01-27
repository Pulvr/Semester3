package higherorderfunctions.higherorderfunctionstest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class MyListFertigTest {

    // Der Konstruktor in MyList übernimmt und speichert die vier übergebenen Elemente. D. h. myList enthält anschließend die vier Strings.
    private final MyListFertig<String> myListFertig = new MyListFertig<>(List.of("Dennis", "Sara", "Jeff", "Steve"));

    // contains mit Objekt ----------------------------------------------------------------------------------------------
    @Test
    void containsTrue() {
        assertTrue(myListFertig.contains("Dennis"));
    }

    @Test
    void containsFalse() {
        assertFalse(myListFertig.contains("ednnis"));
    }

    @Test
    void containsFalseCaseSensitive() {
        assertFalse(myListFertig.contains("dennis"));
    }

    // contains mit Lambda ----------------------------------------------------------------------------------------------
    @Test
    void containsLambdaTrue() {
        assertTrue(myListFertig.contains(element -> element.equals("Dennis")));
    }

    @Test
    void containsLambdaTrueCaseInsensitive() {
        assertTrue(myListFertig.contains(element -> element.equalsIgnoreCase("dennis")));
    }

    @Test
    void containsLambdaFalse() {
        assertFalse(myListFertig.contains(element -> element.equals("ednnis")));
    }

    // contains mit Lambda, aber anderer Typ als String ----------------------------------------------------------
    @Test
    void containsOtherTypeTrue() {
        var myIntegerList = new MyListFertig<>(List.of(1, 2, 3));
        assertTrue(myIntegerList.contains(element -> element.equals(3)));
    }

    @Test
    void containsOtherTypeFalse() {
        var myIntegerList = new MyListFertig<>(List.of(1, 2, 3));
        assertFalse(myIntegerList.contains(element -> element.equals(4)));
    }
}
