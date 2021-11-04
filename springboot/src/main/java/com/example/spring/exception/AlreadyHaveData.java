package com.example.spring.exception;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 15:55 2021/11/4
 */
public class AlreadyHaveData extends Exception{
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public AlreadyHaveData(String message) {
        super(message);
    }
}
