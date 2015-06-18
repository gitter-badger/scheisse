package scheisse.game_ai.nashorn.exception;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornClassNotFoundException extends RuntimeException {

    final String className;

    public NashornClassNotFoundException(String className) {
        super("class: " + className);
        this.className = className;
    }

    public NashornClassNotFoundException(String message, String className) {
        super(message + "\nclass: " + className);
        this.className = className;
    }

    public NashornClassNotFoundException(String message, Throwable cause, String className) {
        super(message + "\nclass: " + className, cause);
        this.className = className;
    }

    public NashornClassNotFoundException(Throwable cause, String className) {
        super("class: " + className, cause);
        this.className = className;
    }

    public NashornClassNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String className) {
        super(message + "\nclass: " + className, cause, enableSuppression, writableStackTrace);
        this.className = className;
    }
}
