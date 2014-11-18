package org.dedda.games.scheisse.gui;

import org.dedda.games.scheisse.exception.gl.GLInitializationException;
import org.dedda.games.scheisse.gui.game.GameWindow;
import org.dedda.games.scheisse.state.game.Game;

/**
 * Created by dedda on 7/21/14.
 */
public class Gui implements Runnable {

    private static final long THREAD_SLEEP = 100;
    private boolean running = false;
    private GameWindow gameWindow;
    private Game game;


    public Gui(Game game) {
        this.game = game;
    }

    public void start() {
        if (!running) {
            //Soil.init();
            new Thread(this).start();
        }
    }

    public void stop() {
        if (running) {
            running = false;
        }
        while (game.isRunning()) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(boolean save) {
        game.stop(save);
        stop();
    }

    public void run() {
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
