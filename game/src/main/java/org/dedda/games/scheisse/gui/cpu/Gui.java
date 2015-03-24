package org.dedda.games.scheisse.gui.cpu;

import org.dedda.games.scheisse.state.game.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dedda on 10/5/14.
 */
public class Gui extends JFrame implements Runnable {

    /**
     * {@link java.awt.Graphics2D} instance to draw with.
     */
    private Graphics2D g2d;
    /**
     * {@link MenuBar} of the game for controls and settings.
     */
    private MenuBar menuBar;
    /**
     * {@link Game} to be rendered.
     */
    private Game game;
    /**
     * {@link java.lang.Thread} to run in for updating / redrawing.
     */
    private Thread thread;
    /**
     * Indicates whether the instance is currently running or not.
     */
    private boolean running = false;
    /**
     * Container to put the contents in.
     */
    private Container content;

    /**
     *
     * @param size initial size of the window
     */
    public Gui(final Dimension size) {
        setSize(size);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        g2d = (Graphics2D) getContentPane().getGraphics();
    }

    /**
     * Closes the window and exits hard with the given code.
     * @param exitCode exit code to return
     */
    public void shutDown(final int exitCode) {
        setVisible(false);
        System.exit(exitCode);
    }

    /**
     * Main cycle of the gui.
     */
    public void run() {
        menuBar = new MenuBar(this);
        add(menuBar, BorderLayout.NORTH);
        content = new ContentContainer(this);
        add(content, BorderLayout.CENTER);
        setVisible(true);
        while (running) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        shutDown(0);
    }

    /**
     *
     * @param game {@link Game} to start the gui with
     */
    public void start(final Game game) {
        if (!running) {
            this.game = game;
            this.thread = new Thread(this);
            running = true;
            thread.start();
        }
    }

    /**
     * stops the gui after the next cycle.
     */
    public void stop() {
        running = false;
    }
    
    public MenuBar getGuiMenuBar() {
        return menuBar;
    }

    public Game getGame() {
        return game;
    }

    public Thread getThread() {
        return thread;
    }

    public boolean isRunning() {
        return running;
    }
}
