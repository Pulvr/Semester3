package algorithms.objectcaster;

import java.util.ArrayList;
import java.util.List;

public class ObjectCaster {
    static List<Integer> toSquaredIntegerList(List<Object> objects) {
        List<Integer> integerListSquared = new ArrayList<>();
        for (Object o : objects) {
            if (o instanceof Number) {
                integerListSquared.add(((Number) o).intValue() * ((Number) o).intValue());
            }
        }

        return integerListSquared;
    }
}
