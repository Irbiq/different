package com.bsu.triangle.exception;

/**
 * Created by ASUS on 08.10.2017.
 */
public class InvalidTriangleParametersException extends Exception {
    public InvalidTriangleParametersException() {
        super();
    }

    public InvalidTriangleParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTriangleParametersException(String message) {
        super(message);
    }

    public InvalidTriangleParametersException(Throwable cause) {
        super(cause);
    }

    protected InvalidTriangleParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
