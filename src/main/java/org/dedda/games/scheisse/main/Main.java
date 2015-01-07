package org.dedda.games.scheisse.main;

import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.gui.cpu.Gui;
import org.dedda.games.scheisse.io.FileInput;
import org.dedda.games.scheisse.io.NetworkConfigWords;
import org.dedda.games.scheisse.io.net.HttpDownloader;
import org.dedda.games.scheisse.io.resource.SaveGameLoader;
import org.dedda.games.scheisse.io.resource.item.ItemLoader;
import org.dedda.games.scheisse.state.State;
import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.Slot;
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
    //public static final String INSTALLATION_FOLDER = System.getProperty("user.home") + "/.scheisse/";
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

        new ItemLoader().loadAll(new File("src/test/test_files/data/item"));
        Game game = new Game();
        Player player = new SaveGameLoader(new File("src/test/test_files/savegame/savegame.dsg")).load();
        Inventory inventory = player.getInventory();
        for (int i = 4; i < 10; i++) {
            Slot slot = new Slot(i, inventory);
            slot.setNumberOfItems(i*2);
            inventory.addSlot(slot);
        }
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

        /*
        Main.args = args;
        parseArgs();
        readConfig();
        if(Options.isCheckInternetConnection()){
            online = checkInternetConnection();
        }
        if(online){
            initOnline();
        }
        Game game = new Game();
        game.setPlayer(new Player(true));
        game.getPlayer().setExperience(170);
        Map map = new Map(new Dimension(1, 1));
        map.setSoil(new Point(0, 0), Soil.Type.DIRT);
        game.setMap(map);
        GLGameWindow glGameWindow = new GLGameWindow(game);
        /*
        int exitCode = startUp();
        if(exitCode != EXIT_OK){
            exit(exitCode);
        }
        exitCode = loadResources();
        if(exitCode != EXIT_OK){
            exit(exitCode);
        }
        exitCode = run();*/
        /*
        Player player = new Player(false);
        Map map = new Map(new Dimension(2, 2));
        Soil.Type soilType[][] = new Soil.Type[2][2];
        soilType[0][0] = Soil.Type.DIRT;    soilType[0][1] = Soil.Type.ROCK;
        soilType[1][0] = Soil.Type.GRASS;    soilType[1][1] = Soil.Type.WATER;
        map.setSoil(soilType);
        player.setExperience(123L);
        Game game = new Game();
        game.setMap(map);
        game.setPlayer(player);
        GLGui glGui = new GLGui(game);
        glGui.start();
        */
        //Soil.init();

        /*
        Player player = new Player(true);
        player.setExperience(12);
        Map map = new MapLoader("src/test/test_files/data/map/map.0_0.dm").load();
        Game game = new Game();
        game.setPlayer(player);
        game.setMap(map);
        Gui gui = new Gui(game);
        gui.start();
        game.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        game.stop(false);
        gui.stop();
        exit(EXIT_OK);
        */
    }

    /**
     * Checks if server can be reached
     *
     * @return boolean
     */
    public static boolean checkInternetConnection() {
        URL url = null;
        try {
            url = new URL(piUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
        Socket socket = null;
        InputStream in = null;
        try {
            socket = new Socket(url.getHost(), 80);
            socket.setSoTimeout(5);
            in = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        if (in != null) {
            try {
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * Initialization for online stuff
     */
    private static void initOnline() {
        newestInstalled = checkVersion();

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
        SystemPrinter.writeln("starting in " + (debug ? "debug" : "normal") + " mode");
        SystemPrinter.debugln("online status: " + (online ? "online" : "offline"));
    }

    /**
     * Checks for a newer version
     *
     * @return True if newest version is installed
     */
    private static boolean checkVersion() {
        String newestVersion = getNewestVersion();
        boolean newestInstalled = compareVersions(VERSION, newestVersion);
        SystemPrinter.debugln(newestInstalled ? "newest version is installed!" : "newer version " + newestVersion + " available");
        return newestInstalled;
    }

    /**
     * Initial checks / downloads
     *
     * @return Exit code
     * ({@value org.dedda.games.scheisse.exception.ExceptionCode#EXIT_OK} if
     * no errors occurred)
     */
    private static int startUp() {
        if (online) {
            SystemPrinter.debugln("trying to get new version...");
            readConfig();
            String newestVersion = getNewestVersion();
            if (newestVersion.equals("-1")) {
                SystemPrinter.debugln("couldn't reach file with newest version");
                online = false;
                newestInstalled = true;
            } else {
                if (!compareVersions(VERSION, newestVersion)) {
                    SystemPrinter.debugln("newer version found!");
                    newestInstalled = false;
                } else {
                    SystemPrinter.debugln("newest version installed");
                    newestInstalled = true;
                }
            }
        }
        SystemPrinter.debugln("checking installation files...");
        installed = checkInstallation();
        if (!installed) {
            SystemPrinter.debugln("installation incomplete, going to exit...");
            return EXIT_INSTALLATION_FAULT;
        }
        SystemPrinter.debugln("installation ok!");
        return 0;
    }

    /**
     * Loads the resources like items and images.
     */
    private static void loadResources() {
        SystemPrinter.debugln("loading resources...");
        SystemPrinter.debug("loading items... ");
        SystemPrinter.debugln(new ItemLoader().loadAll(new File(INSTALLATION_FOLDER + "data/item/")).size() + " OK!");
        SystemPrinter.debugln("initializing soil resources");
        Soil.init();
    }

    /**
     * Starts the gui and everything
     *
     * @return Exit code
     * ({@value org.dedda.games.scheisse.exception.ExceptionCode#EXIT_OK} if no
     * errors occurred)
     */
    private static int run() {
        //MenuFrame menuFrame = new MenuFrame();
        //return menuFrame.execute();
        return EXIT_OK;
    }

    /**
     * cleanup and exiting
     * @param exitCode
     */
    private static void exit(final int exitCode) {
        System.exit(exitCode);
    }

    /**
     *
     * @return boolean - installation complete
     */
    public static boolean checkInstallation() {
        for (String fileName : INSTALLATION_FILES) {
            if (!new File(INSTALLATION_FOLDER + fileName).exists()) {
                SystemPrinter.debugln("file " + fileName + " not installed!");
                return false;
            }
        }
        return true;
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
     * @return String - newest version directly from server in string representation
     */
    public static String getNewestVersion() {
        String version = "-1";
        URL versionUrl = null;
        try {
            versionUrl = new URL(piUrl + URLEXT_VERSION);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpDownloader downloader = new HttpDownloader(versionUrl);
        SystemPrinter.debugln("trying to get file \"" + versionUrl + "\"...");
        try {
            downloader.download(new File(INSTALLATION_FOLDER + INSTALLATION_FILES[0]));
        } catch (IOException e) {
            SystemPrinter.debugln("could not download file \"" + versionUrl + "\"!");
            return version;
        }
        FileInput fileInput = new FileInput();
        version = fileInput.read(new File(INSTALLATION_FOLDER + INSTALLATION_FILES[0]));
        return version;
    }

    /**
     *
     * @param older String
     * @param newer String
     * @return boolean - false ==> older version is obsolete, true ==> version is up to date
     */
    public static boolean compareVersions(final String older, final String newer) {
        if (older.charAt(0) < newer.charAt(0)) {
            return false;
        } else if (older.charAt(1) < newer.charAt(1)) {
            return false;
        } else if (older.charAt(3) < newer.charAt(3)) {
            return false;
        } else if (older.charAt(4) < newer.charAt(4)) {
            return false;
        } else if (older.charAt(5) < newer.charAt(5)) {
            return false;
        }
        return true;
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

    public static String getPiUrl() {
        return piUrl;
    }
}
