package com.example.web.springbootweb.exception;

/**
 * @author Xinrui Yu
 * @date 2021-11-6 1:01
 */
public class IdNotFoundException extends Exception{
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public IdNotFoundException(String message) {
        super(message);
    }
}
