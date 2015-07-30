package org.dedda.games.scheisse.jmx;

/**
 * Created by dedda on 3/7/15.
 */
public class Main {

    private static String[] args;
    private static boolean gui = false;
    private static int width;
    private static int height;
    private static int interval;

    public static void main(final String[] args) {
        Main.args = args;
        parseArgs();
    }

    private static void parseArgs() {
        for (int i = 0; i < args.length; i++) {
            String argument = args[i];
            if (argument.equals("--gui") || argument.equals("-g")) {
                gui = true;
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
    }

    private Main() {}
}
