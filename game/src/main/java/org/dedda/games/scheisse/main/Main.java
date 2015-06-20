package org.dedda.games.scheisse.main;

import org.dedda.games.scheisse.entity.item.ItemStore;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.tool.SystemPrinter;
import org.dedda.games.scheisse.gui.cpu.Gui;
import org.dedda.games.scheisse.fsloaders.resource.Resource;
import org.dedda.games.scheisse.fsloaders.resource.item.ItemLoader;
import org.dedda.games.scheisse.state.State;
import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;

import java.awt.Dimension;
import java.io.File;

/**
 * {@link org.dedda.games.scheisse.main.Main} class containing the
 * {@link #main(String[])} method for starting and controlling
 * the program.
 * <p/>
 * Created by dedda on 4/17/14.
 *
 * @author dedda
 */
public class Main {

    /**
     * Version number of the program.
     */
    public static final String VERSION = "00_01a";
    public static final String URLEXT_VERSION = "version.dgm";
    /**
     * Folder where all {@link #INSTALLATION_FILES} can be found if
     * everything is installed properly.
     */
    public static final String[] INSTALLATION_FILES = {"version.dgm",
        "conf.dgm"};
    /**
     * URL where to find the pi main server for downloading files and
     * comparing versions.
     */
    private static String piUrl = "http://192.168.2.113/games/scheisse/";
    private static boolean online = true;
    private static boolean debug = true;
    private static State currentState;
    private static boolean installed;
    private static boolean newestInstalled;
    private static String[] args;

    /**
     * Entry point of the program.
     *
     * @param args String[] - system args
     */
    public static void main(final String[] args) {

        new ItemLoader().loadAll(new File(Resource.ITEM_FOLDER));
        Game game = new Game();
        Player player = new Player(true);
        Inventory inventory = new Inventory(0);
        for (int i = 4; i < 10; i++) {
            Slot slot = new Slot(inventory);
            slot.setDummy(ItemStore.forId(i));
            slot.setNumberOfItems(i * 2);
            inventory.addSlot(slot);
        }
        inventory.print();
        player.setInventory(inventory);
        game.setPlayer(player);
        Gui gui = new Gui(new Dimension(800, 600));
        gui.start(game);
    }

    /**
     * Parsing the program arguments.
     */
    private static void parseArgs() {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d") || args[i].equals("--debug")) {
                debug = true;
            } else if (args[i].equals("--offline")) {
                Options.setCheckInternetConnection(false);
                online = false;
            }
        }
        SystemPrinter.writeln("starting in " + (
            debug ? "debug" : "normal"
        ) + " mode");
        SystemPrinter.debugln("online status: " + (
            online ? "online" : "offline"
        ));
    }

    /**
     * cleanup and exiting.
     *
     * @param exitCode
     */
    private static void exit(final int exitCode) {
        System.exit(exitCode);
    }

    /**
     * @return State - current state of the program
     */
    public static State getCurrentState() {
        return currentState;
    }

    /**
     * switch state of the program.
     *
     * @param currentState State - state to switch to
     */
    public static void setCurrentState(final State currentState) {
        Main.currentState = currentState;
    }

    /**
     * @return boolean
     */
    public static boolean isDebug() {
        return debug;
    }

    /**
     * enable / disable debug information.
     *
     * @param debug boolean - debug on / off
     */
    public static void setDebug(final boolean debug) {
        Main.debug = debug;
    }
}
