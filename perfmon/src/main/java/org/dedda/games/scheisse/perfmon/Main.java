package org.dedda.games.scheisse.perfmon;

/**
 * Created by dedda on 3/7/15.
 * @author dedda
 */
public class Main {
    /**
     * Program args.
     */
    private static String[] args;
    /**
     * Start with gui.
     */
    private static boolean gui = false;
    /**
     * Print version to console on start up.
     */
    private static boolean printVersion = false;
    /**
     * Width of gui or console, depending on mode.
     */
    private static int width = 100;
    /**
     * Height of gui or console, depending on mode.
     */
    private static int height = 50;
    /**
     * Refresh interval.
     */
    private static int interval = 2;
    /**
     * Version of this client.
     */
    public static final String VERSION = "0.01a";


    /**
     * Main method.
     * @param args
     */
    public static void main(final String[] args) {
        Main.args = args;
        parseArgs();
    }

    /**
     * Parsing program args and setting variables.
     */
    private static void parseArgs() {
        for (int i = 0; i < args.length; i++) {
            String argument = args[i];
            if (argument.equals("--gui") || argument.equals("-g")) {
                gui = true;
            } else if (argument.equals("--VERSION") || argument.equals("-v")) {
                printVersion = true;
            } else if (argument.equals("--width") || argument.equals("-w")) {
                i++;
                width = Integer.parseInt(args[i]);
            } else if (argument.equals("--height") || argument.equals("-h")) {
                i++;
                height = Integer.parseInt(args[i]);
            } else if (argument.equals("--interval") || argument.equals("-i")) {
                i++;
                interval = Integer.parseInt(args[i]);
            }
        }
        if (printVersion) {
            System.out.println("Scheisse Performance Monitor VERSION " + VERSION);
        }
        System.out.println(gui ? "" : "no" + " gui");
        System.out.println("width: " + width);
        System.out.println("height: " + height);
        System.out.println("interval: " + interval + "s");
    }

}
