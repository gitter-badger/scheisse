package org.dedda.games.scheisse.gui;

import org.dedda.games.scheisse.exception.gl.GLInitializationException;
import org.dedda.games.scheisse.gui.game.GameWindow;
import org.dedda.games.scheisse.state.game.Game;

/**
 * Created by dedda on 7/21/14.
 */
public class Gui implements Runnable {

    /**
     * Time in ms the {@link java.lang.Thread} shall sleep between
     * each update / redraw cycle.
     */
    private static final long THREAD_SLEEP = 5;
    /**
     * Flag to determine if the gui is currently running.
     */
    private boolean running = false;
    /**
     * Window to draw on.
     */
    private GameWindow gameWindow;
    /**
     * Game to be rendered.
     */
    private Game game;

    /**
     *
     * @param game {@link Game} to be rendered in this {@link Gui}
     */
    public Gui(final Game game) {
        this.game = game;
    }

    /**
     * starts the gui.
     */
    public final void start() {
        if (!running) {
            //Soil.init();
            new Thread(this).start();
        }
    }

    /**
     * stops the gui and waits for the game to stop.
     */
    public final void stop() {
        if (running) {
            running = false;
        }
        while (game.isRunning()) {
            try {
                Thread.sleep(THREAD_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * stops the gui and waits for the game to stop.
     * @param save Whether the game should be saved or not
     */
    public final void stop(final boolean save) {
        game.stop(save);
        stop();
    }

    /**
     * the run cycle for updating and rendering.
     */
    public final void run() {
        running = true;
        try {
            gameWindow = new GameWindow(game);
        } catch (GLInitializationException e) {
            e.printStackTrace();

        }
        gameWindow.setVisible(true);
        while (running) {
            gameWindow.update();
            gameWindow.render();
            try {
                Thread.sleep(THREAD_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
