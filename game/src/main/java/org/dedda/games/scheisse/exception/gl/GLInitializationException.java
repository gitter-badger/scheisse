package org.dedda.games.scheisse.exception.gl;

import org.dedda.games.scheisse.exception.ExceptionCode;

/**
 * Exception representing errors during initialization of OpenGL.
 *
 * @author dedda
 *         Created by dedda on 9/1/14.
 */
public class GLInitializationException extends Exception {

    /**
     * Standard constructor.
     */
    public GLInitializationException() {
        super("GL Initialization failed! (code: "
            + ExceptionCode.EXIT_GL_INITIALIZATION_FAILED + ")");
    }

    /**
     * Constructor with specific message.
     *
     * @param message Message to display in system output
     */
    public GLInitializationException(final String message) {
        super("GL Initialization failed: " + message + " (code: "
            + ExceptionCode.EXIT_GL_INITIALIZATION_FAILED + ")");
    }

    /**
     * Constructor with {@link java.lang.Throwable} that caused this exception.
     *
     * @param cause {@link java.lang.Throwable} that caused this exception
     */
    public GLInitializationException(final Throwable cause) {
        super("GL Initialization failed! (code: "
            + ExceptionCode.EXIT_GL_INITIALIZATION_FAILED + ")", cause);
    }

    /**
     * Constructor with specific message and
     * {@link java.lang.Throwable} that caused this exception.
     *
     * @param message Message to display in system output
     * @param cause   {@link java.lang.Throwable} that caused this exception
     */
    public GLInitializationException(
        final String message,
        final Throwable cause) {
        super("GL Initialization failed: " + message + " (code: "
            + ExceptionCode.EXIT_GL_INITIALIZATION_FAILED + ")", cause);
    }

}
