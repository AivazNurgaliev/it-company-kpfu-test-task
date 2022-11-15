package com.aivaz.nurgaliev.itcompany.exception;

public class DataNotFoundException extends Exception {
    public DataNotFoundException(String msg) {
        super(msg);
    }

    public DataNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }
}
