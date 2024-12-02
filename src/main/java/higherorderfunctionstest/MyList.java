package higherorderfunctionstest;

import java.util.List;
import java.util.function.Predicate;

public class MyList<T> {

    public MyList(List<T> list) {
    }

    public boolean contains(String myString) {
        Predicate<String> predicate = (stringContent) -> stringContent.contains(myString);
        
        return false;

    }
}
