package higherorderfunctionstest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class MyListTest {

    // Der Konstruktor in MyList übernimmt und speichert die vier übergebenen Elemente. D. h. myList enthält anschließend die vier Strings.
    private final MyList<String> myList = new MyList<>(List.of("Dennis", "Sara", "Jeff", "Steve"));

    // contains mit Objekt ----------------------------------------------------------------------------------------------
    @Test
    void containsTrue() {
        assertTrue(myList.contains("Dennis"));
    }

    @Test
    void containsFalse() {
        assertFalse(myList.contains("ednnis"));
    }

    @Test
    void containsFalseCaseSensitive() {
        assertFalse(myList.contains("dennis"));
    }

    // contains mit Lambda ----------------------------------------------------------------------------------------------
    @Test
    void containsLambdaTrue() {
        assertTrue(myList.contains(element -> element.equals("Dennis")));
    }

    @Test
    void containsLambdaTrueCaseInsensitive() {
        assertTrue(myList.contains(element -> element.equalsIgnoreCase("dennis")));
    }

    @Test
    void containsLambdaFalse() {
        assertFalse(myList.contains(element -> element.equals("ednnis")));
    }

    // contains mit Lambda, aber anderer Typ als String ----------------------------------------------------------
    @Test
    void containsOtherTypeTrue() {
        var myIntegerList = new MyList<>(List.of(1, 2, 3));
        assertTrue(myIntegerList.contains(element -> element.equals(3)));
    }

    @Test
    void containsOtherTypeFalse() {
        var myIntegerList = new MyList<>(List.of(1, 2, 3));
        assertFalse(myIntegerList.contains(element -> element.equals(4)));
    }
}
