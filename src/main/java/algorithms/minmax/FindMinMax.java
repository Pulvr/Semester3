package algorithms.minmax;

import java.util.Collection;
import java.util.Collections;

public class FindMinMax {
    static MinMax findMinMax(Collection<Integer> myList) {
        return new MinMax(Collections.min(myList), Collections.max(myList));
    }
}
