package org.example.currency;

record ConversionRate(double value) {

    static ConversionRate of(double value) {
        return new ConversionRate(value);
    }
}