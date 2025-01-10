package algorithms.linearsearch;

import java.util.Collection;
import java.util.List;

public class LinearSearch {
    static int findIndexOfNumber(Collection<Integer> numbers, int desiredNumber) {
        if (numbers != null) {
            List<Integer> collectionAsList = numbers.stream().toList();
            for (int i = 0; i < collectionAsList.size(); i++) {
                if (collectionAsList.get(i) == desiredNumber) {
                    return collectionAsList.indexOf(desiredNumber);
                }
            }
            return -1;
        } else {
            throw new NullPointerException("Liste darf nicht leer sein");
        }

    }
}
