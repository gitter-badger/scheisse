package scheisse.game_ai.nashorn.exception;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornClassNotFoundException extends RuntimeException {

    public final String className;

    public NashornClassNotFoundException(final String className) {
        super("class: " + className);
        this.className = className;
    }

    public NashornClassNotFoundException(final String message, final String className) {
        super(message + "\nclass: " + className);
        this.className = className;
    }

    public NashornClassNotFoundException(final String message, final Throwable cause, final String className) {
        super(message + "\nclass: " + className, cause);
        this.className = className;
    }

    public NashornClassNotFoundException(final Throwable cause, final String className) {
        super("class: " + className, cause);
        this.className = className;
    }

    public NashornClassNotFoundException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace, final String className) {
        super(message + "\nclass: " + className, cause, enableSuppression, writableStackTrace);
        this.className = className;
    }
}
