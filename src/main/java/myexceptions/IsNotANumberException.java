package myexceptions;

public class IsNotANumberException extends RuntimeException {
    public IsNotANumberException(String message) {
        super(message);
    }
}
