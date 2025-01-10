package algorithms.longeststring;

import java.util.Collection;

public class LongestString {
    static String findLongestString(Collection<String> stringList) {
        String longestString = "";
        if (stringList != null) {
            for (String s : stringList) {
                if (s.length() > longestString.length()) {
                    longestString = s;
                }
            }
        } else {
            throw new NullPointerException("Liste darf nicht null sein");
        }
        return longestString;
    }
}
