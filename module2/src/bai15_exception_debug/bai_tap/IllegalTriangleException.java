package bai15_exception_debug.bai_tap;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String message) {
        super(message);
    }
}
