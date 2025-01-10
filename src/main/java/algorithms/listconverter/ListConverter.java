package algorithms.listconverter;

import java.util.Arrays;
import java.util.List;

public class ListConverter {
    Integer[] toArray(List<Integer> list) {
        Integer[] convertedArray = new Integer[list.size()];
        if (!list.isEmpty()) {
            for (Integer i : list) {
                convertedArray[i - 1] = i;
            }
            return convertedArray;
        } else {
            throw new ListEmptyException("Liste darf nicht leer sein");
        }
    }

    List<Integer> toList(Integer[] array) {
        return Arrays.stream(array).toList();
    }
}
