package org.example.currency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    @Test
    void convertInvalidPairTest() {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        assertThrows(CurrencyNotSupportedException.class,() -> currencyConverter.convert(Currency.EURO, Currency.INVALID, 2));

    }

    @Test
    void testConvert() {
    }

    @Test
    void getConversionRate() {
    }
}