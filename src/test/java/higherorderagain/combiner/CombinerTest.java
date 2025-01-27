package higherorderagain.combiner;

import higherorderagain.combiner.Combiner;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class CombinerTest {

    private static final double TOLERANCE = 0.000000000001;

    @Test
    void stringsWithSpaceCombiner() {
        Combiner<String, String> withSpaceCombiner = (string1, string2) -> "%s %s".formatted(string1, string2);
        String actual = withSpaceCombiner.combine("Steve", "Wozniak");
        assertThat(actual).isEqualTo("Steve Wozniak");
    }

    @Test
    void integersAsStringsCombiner() {
        Combiner<Integer, String> numbersAsStringCombiner = (number1, number2) -> "%s%s".formatted(number1, number2);
        String actual = numbersAsStringCombiner.combine(4, 2);
        assertThat(actual).isEqualTo("42");
    }

    @Test
    void integersAsDoubleCombiner() {
        Combiner<Integer, Double> numbersAsStringCombiner = (number1, number2) -> (double) (number1 + number2);
        Double actual = numbersAsStringCombiner.combine(4, 2);
        assertThat(actual).isWithin(TOLERANCE).of(6.0);

    }
}
