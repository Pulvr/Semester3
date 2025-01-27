package higherorderfunctions.higherorderfunctionstest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MyListFertig<T> {
    private List<T> elements = new ArrayList<>();

    public MyListFertig(List<T> list) {
        this.elements = list;
    }

    public boolean contains(String myString) {
        Predicate<T> predicate = element -> element.equals(myString);
        for (T element : elements) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Predicate<T> predicate) {
        for (T element : elements) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }
}
