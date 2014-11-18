package org.dedda.games.scheisse.gui.cpu;

import org.dedda.games.scheisse.state.game.Game;

import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Container;

/**
 * Created by dedda on 10/5/14.
 */
public class Gui extends JFrame implements Runnable {

    private Graphics2D g2d;
    private MenuBar menuBar;
    private Game game;
    private Thread thread;
    private boolean running = false;
    private Container content;

    public Gui(final Dimension size) {
        setSize(size);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        g2d = (Graphics2D)getContentPane().getGraphics();
    }

    public void shutDown(final int exitCode) {
        setVisible(false);
        System.exit(exitCode);
    }

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

    public void start(final Game game) {
        if (!running) {
            this.game = game;
            this.thread = new Thread(this);
            running = true;
            thread.start();
        }
    }

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
