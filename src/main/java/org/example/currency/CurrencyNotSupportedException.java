package org.example.currency;

class CurrencyNotSupportedException extends RuntimeException {
    public CurrencyNotSupportedException(String message) {
        super(message);
    }
}
