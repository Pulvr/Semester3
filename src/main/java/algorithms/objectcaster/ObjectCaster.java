package algorithms.objectcaster;

import java.util.ArrayList;
import java.util.List;

public class ObjectCaster {
    static List<Integer> toSquaredIntegerList(List<Object> objects) {
        List<Integer> integerListSquared = new ArrayList<>();
        for (Object o : objects) {
            if (o instanceof Integer) {
                integerListSquared.add((Integer) o * (Integer) o);
            }
        }

        return integerListSquared;
    }
}
