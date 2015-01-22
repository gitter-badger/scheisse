package org.dedda.games.scheisse.exception.gui;

/**
 * Created by dedda on 11.01.15.
 */
public class ResourcePackException extends Exception {

    public static final int UNDEFINED = 0;
    public static final int ALREADY_REGISTERED = 1;
    public static final int NO_SUCH_SPRITE = 2;

    public final int code;

    public ResourcePackException() {
        code = UNDEFINED;
    }

    public ResourcePackException(final int code) {
        this.code = code;
    }

    public ResourcePackException(final String message) {
        super(message);
        code = UNDEFINED;
    }

    public ResourcePackException(final String message, final int code) {
        super(message);
        this.code = code;
    }

    public ResourcePackException(final Throwable cause) {
        super(cause);
        code = UNDEFINED;
    }

    public ResourcePackException(final Throwable cause, final int code) {
        super(cause);
        this.code = code;
    }

    public ResourcePackException(final String message, final Throwable cause) {
        super(message, cause);
        code = UNDEFINED;
    }

    public ResourcePackException(
            final String message,
            final Throwable cause,
            final int code
    ) {
        super(message, cause);
        this.code = code;
    }
}
