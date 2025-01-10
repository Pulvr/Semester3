package algorithms.longeststring;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongestStringTest {

    @Test
    void findLongestStringTest() {
        Collection<String> words = List.of("Apple", "Orange", "Strawberry", "Banana");
        String longestString = LongestString.findLongestString(words);
        assertEquals("Strawberry", longestString);
    }

    @Test
    void findLongestStringSameSizeTest() {
        Collection<String> words = List.of("Apple", "Orange", "Strawberry", "Strawbarry");
        String longestString = LongestString.findLongestString(words);
        assertEquals("Strawberry", longestString);
    }

    @Test
    void findLongestStringEmptyList() {
        Collection<String> words = List.of();
        String longestString = LongestString.findLongestString(words);
        assertEquals("", longestString);
    }

    @Test
    void findLongestStringNullList() {
        Collection<String> nullList = null;
        Exception e = assertThrows(NullPointerException.class, () -> LongestString.findLongestString(nullList));
        assertEquals("Liste darf nicht null sein", e.getMessage());
    }
}