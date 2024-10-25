package org.example.currency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    @Test
    void convertInvalidPairTest() {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        assertThrows(CurrencyNotSupportedException.class,() -> currencyConverter.convert(Currency.EURO, Currency.EURO, 2));
        assertThrows(CurrencyNotSupportedException.class,() -> currencyConverter.convert(Currency.DOLLAR, Currency.INVALID, 2));

    }

    @Test
    void convertValidPairTest(){
        CurrencyConverter currencyConverter = new CurrencyConverter();
        Money actualResult = currencyConverter.convert(Currency.EURO, Currency.DOLLAR, 2);
        assertEquals(2.12608,actualResult.value(),0.00001);
    }

    @Test
    void negativeConvertMoneyTest(){
        CurrencyConverter currencyConverter = new CurrencyConverter();
        Exception exception = assertThrows(NegativeValueException.class, () -> currencyConverter.convert(Currency.INVALID,Currency.DOLLAR,-2));
        assertEquals("Negative amount cannot be converted.",exception.getMessage());
    }

    @Test
    void getConversionRateTest() {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        assertEquals(1.06304, currencyConverter.getConversionRate(Currency.EURO,Currency.DOLLAR).value());
        assertEquals(0.94056, currencyConverter.getConversionRate(Currency.DOLLAR,Currency.EURO).value());
    }

    @Test
    void currencyNotSupportedTest(){
        CurrencyConverter currencyConverter = new CurrencyConverter();
        assertThrows(CurrencyNotSupportedException.class, ()-> currencyConverter.getConversionRate(Currency.DOLLAR,Currency.DOLLAR));
        assertThrows(CurrencyNotSupportedException.class, ()-> currencyConverter.getConversionRate(Currency.EURO,Currency.EURO));
        assertThrows(CurrencyNotSupportedException.class, ()-> currencyConverter.getConversionRate(Currency.DOLLAR,null));

    }

}