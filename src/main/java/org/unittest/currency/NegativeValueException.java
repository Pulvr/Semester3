package org.unittest.currency;

class NegativeValueException extends RuntimeException {
    public NegativeValueException(String message) {
        super(message);
    }
}
