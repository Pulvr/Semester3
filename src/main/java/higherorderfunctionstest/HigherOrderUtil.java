package higherorderfunctionstest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class HigherOrderUtil {

    public static List<Integer> applyToEach(List<Integer> numbers, UnaryOperator<Integer> operation) {
        List<Integer> appliedList = new ArrayList<>();
        int currentNumberOpAppliedTo;
        for (Integer number : numbers) {
            currentNumberOpAppliedTo = operation.apply(number);
            appliedList.add(currentNumberOpAppliedTo);
        }
        return appliedList;
    }

    public static List<Integer> applyToEachIf(List<Integer> numbers, UnaryOperator<Integer> operation, Predicate<Integer> predicate) {
        List<Integer> appliedList = new ArrayList<>();
        int currentNumberOpAppliedTo;
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                currentNumberOpAppliedTo = operation.apply(number);
                appliedList.add(currentNumberOpAppliedTo);
            }
        }
        return appliedList;
    }
}
