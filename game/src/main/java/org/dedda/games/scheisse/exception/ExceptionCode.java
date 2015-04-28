package org.dedda.games.scheisse.exception;

/**
 * Class for central collection of all possible exit codes of the program.
 * <p/>
 * In this class, all possible exit codes ever used by the program except
 * exiting due to {@link java.lang.RuntimeException}s are collected. This
 * should prevent unknown or undefined status codes while coding and running
 * the program.
 * <p/>
 * Created by dedda on 4/24/14.
 *
 * @author dedda
 */
public abstract class ExceptionCode {

    /**
     * Everything went well. The program was stopped on purpose by the user.
     */
    public static final int EXIT_OK = 0;

    /**
     * The installation is not valid. Cause of this may be missing or
     * corrupt files.
     */
    public static final int EXIT_INSTALLATION_FAULT = 1;

    /**
     * An {@link java.lang.Exception} occurred where it wasn't clear how to
     * react or where it came from.
     */
    public static final int EXIT_UNKNOWN = 2;

    /**
     * OpenGL couldn't initialize. This might be caused by incompatible
     * graphics cards or wrong drivers.
     */
    public static final int EXIT_GL_INITIALIZATION_FAILED = 3;

}
