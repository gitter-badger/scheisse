package org.dedda.games.scheisse.main;

import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.gui.cpu.Gui;
import org.dedda.games.scheisse.io.FileInput;
import org.dedda.games.scheisse.io.NetworkConfigWords;
import org.dedda.games.scheisse.io.net.HttpDownloader;
import org.dedda.games.scheisse.io.resource.Resource;
import org.dedda.games.scheisse.io.resource.SaveGameLoader;
import org.dedda.games.scheisse.io.resource.item.ItemLoader;
import org.dedda.games.scheisse.state.State;
import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.Slot;
import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.map.soil.Soil;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import static org.dedda.games.scheisse.exception.ExceptionCode.EXIT_INSTALLATION_FAULT;
import static org.dedda.games.scheisse.exception.ExceptionCode.EXIT_OK;

/**
 * {@link org.dedda.games.scheisse.main.Main} class containing the
 * {@link #main(String[])} method for starting and controlling
 * the program.
 *
 * Created by dedda on 4/17/14.
 *
 * @author dedda
 */
public class Main {

    /**
     * Version number of the program
     */
    public static final String VERSION = "00_01a";
    public static final String URLEXT_VERSION = "version.dgm";
    /**
     * Folder where all {@link #INSTALLATION_FILES} can be found if
     * everything is installed properly.
     */
    public static final String INSTALLATION_FOLDER = "game_files/";
    public static final String INSTALLATION_FILES[] = { "version.dgm",
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
    private static String args[];

    /**
     * Entry point of the program.
     *
     * @param args String[] - system args
     */
    public static void main(final String args[]) {

        new ItemLoader().loadAll(new File(Resource.ITEM_FOLDER));
        Game game = new Game();
        Player player = new Player(true);/*new SaveGameLoader(
                new File("src/test/test_files/classes/org/dedda/games/scheisse/io/resource/SaveGameLoader")
        ).load();*/
        //Inventory inventory = player.getInventory();
        Inventory inventory = new Inventory(0);
        for (int i = 4; i < 10; i++) {
            Slot slot = new Slot(inventory);
            slot.setDummy(Item.forId(i));
            slot.setNumberOfItems(i*2);
            inventory.addSlot(slot);
        }
        inventory.print();
        player.setInventory(inventory);
        game.setPlayer(player);
        /*
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        InventoryTable table = new InventoryTable(player.getInventory());
        frame.getContentPane().add(table);
        frame.setVisible(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        table.getModel().enableCategory(InventoryTableModel.SYMBOL);
        */
        Gui gui = new Gui(new Dimension(800, 600));
        gui.start(game);
    }

    /**
     * Parsing the program arguments
     */
    private static void parseArgs() {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d") || args[i].equals("--debug")) {
                debug = true;
            } else if (args[i].equals("--offline")){
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
     * cleanup and exiting
     * @param exitCode
     */
    private static void exit(final int exitCode) {
        System.exit(exitCode);
    }

    private static void readConfig() {
        FileInput fileInput = new FileInput();
        String filename = INSTALLATION_FOLDER + INSTALLATION_FILES[1];
        SystemPrinter.debugln("reading config file " + filename);
        String configLines[] = fileInput.getLines(new File(filename));
        for (String line : configLines) {
            if (line.startsWith(NetworkConfigWords.BASE_URL)) {
                piUrl = line.substring(NetworkConfigWords.BASE_URL.length());
                SystemPrinter.debugln("base url set to \"" + piUrl + "\"");
                continue;
            }
        }
    }

    /**
     *
     * @return State - current state of the program
     */
    public static State getCurrentState() {
        return currentState;
    }

    /**
     * switch state of the program
     * @param currentState State - state to switch to
     */
    public static void setCurrentState(final State currentState) {
        Main.currentState = currentState;
    }

    /**
     *
     * @return boolean
     */
    public static boolean isDebug() {
        return debug;
    }

    /**
     * enable / disable debug information
     * @param debug boolean - debug on / off
     */
    public static void setDebug(final boolean debug) {
        Main.debug = debug;
    }

    public static boolean isInstalled() {
        return installed;
    }

    public static boolean isOnline() {
        return online;
    }
}
