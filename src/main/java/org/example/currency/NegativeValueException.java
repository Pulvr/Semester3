package org.example.currency;

class NegativeValueException extends RuntimeException {
    public NegativeValueException(String message) {
        super(message);
    }
}
