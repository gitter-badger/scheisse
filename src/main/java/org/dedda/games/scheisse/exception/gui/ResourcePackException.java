package org.dedda.games.scheisse.exception.gui;

import org.dedda.games.scheisse.exception.ExceptionCode;

/**
 * Created by dedda on 11.01.15.
 */
public class ResourcePackException extends Exception {

    public static final int UNDEFINED = 0;
    public static final int ALREADY_REGISTERED = 1;

    public final int code;

    public ResourcePackException() {
        code = UNDEFINED;
    }

    public ResourcePackException(int code) {
        this.code = code;
    }

    public ResourcePackException(String message) {
        super(message);
        code = UNDEFINED;
    }

    public ResourcePackException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ResourcePackException(Throwable cause) {
        super(cause);
        code = UNDEFINED;
    }

    public ResourcePackException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public ResourcePackException(String message, Throwable cause) {
        super(message, cause);
        code = UNDEFINED;
    }

    public ResourcePackException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }
}
