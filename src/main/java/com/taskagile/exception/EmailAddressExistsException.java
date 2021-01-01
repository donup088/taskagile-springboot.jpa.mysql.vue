package com.taskagile.exception;

public class EmailAddressExistsException extends RuntimeException{
    public EmailAddressExistsException() {
        super();
    }

    public EmailAddressExistsException(String message) {
        super(message);
    }

    public EmailAddressExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailAddressExistsException(Throwable cause) {
        super(cause);
    }

    protected EmailAddressExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
