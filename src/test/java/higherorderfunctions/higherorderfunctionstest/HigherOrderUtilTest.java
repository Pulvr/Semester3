package higherorderfunctions.higherorderfunctionstest;

import higherorderfunctions.higherorderfunctionstest.HigherOrderUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class HigherOrderUtilTest {
    @Test
    void applyToEach() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        //returns each modified number based on the given Lambda.
        List<Integer> doubled = HigherOrderUtil.applyToEach(numbers, x -> x * 2);

        assertThat(doubled).isEqualTo(List.of(2, 4, 6, 8, 10));
    }


    @Test
    void applyToEachIf() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // returns modified numbers, but only for those numbers that fulfil a given condition (3rd parameter).
        List<Integer> halfedIfEven = HigherOrderUtil.applyToEachIf(numbers, x -> x / 2, x -> x % 2 == 0);

        // Parameters: 1st source, 2nd modifier lambda, 3nd condition lambda
        assertThat(halfedIfEven).isEqualTo(List.of(1, 2));
    }
}
