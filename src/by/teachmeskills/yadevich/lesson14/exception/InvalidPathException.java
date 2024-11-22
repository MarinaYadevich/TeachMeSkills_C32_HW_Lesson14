package by.teachmeskills.yadevich.lesson14.exception;

public class InvalidPathException extends Exception {
    private int exceptionCode;

    public InvalidPathException(String message, int exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }
}

