package org.dedda.games.scheisse.debug;

import org.dedda.games.scheisse.main.Main;

/**
 * Created by dedda on 4/22/14.
 */
public abstract class SystemPrinter {

    /**
     * writes message to system output.
     * @param message Message to write to the system output
     */
    public static void write(final String message) {
        System.out.print(message);
    }

    /**
     * writes message to system output and appends a new line.
     * @param message Message to write to the system output
     */
    public static void writeln(final String message) {
        System.out.println(message);
    }

    /**
     * writes message to system output when debug mode is enabled.
     * @param message Message to write to the system output
     */
    public static void debug(final String message) {
        if (Main.isDebug()) {
            System.out.print(message);
        }
    }

    /**
     * writes message to system output and appends new
     * line when debug mode is enabled.
     * @param message Message to write to the system output
     */
    public static void debugln(final String message) {
        if (Main.isDebug()) {
            System.out.println(message);
        }
    }

}
