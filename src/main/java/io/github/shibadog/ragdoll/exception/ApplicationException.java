package io.github.shibadog.ragdoll.exception;

import java.io.Serializable;

public class ApplicationException extends Exception implements Serializable {
    public static final long serialVersionUID = 1L;

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}