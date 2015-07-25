package org.dedda.games.scheisse_server.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dedda on 6/1/15.
 *
 * @author dedda
 */
public class ExtendedLogger extends Logger {

    protected ExtendedLogger(final String name, final String resourceBundleName) {
        super(name, resourceBundleName);
    }

    public void log(final Level level, final String msg, final ExtLoggingStrategy extStrategy) {
        super.log(level, msg);
        switch (extStrategy) {
            case NONE: return;
            case ELASTICS_SIMPLE: {
                logElasticsSimple(level, msg);
            }
        }
    }

    private void logElasticsSimple(final Level level, final String msg) {

    }

}
