package refactoring.temperatureconverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureConverterTest {

    private static final double TOLERANCE = 0.00001;


    @Test
    void convertToFahrenheit() {
        var actual = TemperatureConverter.convertCelsiusToFahrenheit(0);

        assertEquals(32, actual, TOLERANCE);
    }

    @Test
    void convertToFahrenheitWithNegativeDecimals() {
        var actual = TemperatureConverter.convertCelsiusToFahrenheit(-0.33f);

        assertEquals(31.406, actual, TOLERANCE);
    }

    @Test
    void convertToCelsius() {
        var actual = TemperatureConverter.convertFahrenheitToCelsius(32);

        assertEquals(0, actual, TOLERANCE);
    }

    @Test
    void convertToCelsiusWithNegativeDecimals() {
        var actual = TemperatureConverter.convertFahrenheitToCelsius(-31.01f);

        assertEquals(-35.00556, actual, TOLERANCE);
    }

}