package org.dedda.games.scheisse.state.game;

import org.dedda.games.scheisse.state.State;
import org.dedda.games.scheisse.state.game.map.Map;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.io.File;

/**
 * Created by dedda on 4/17/14.
 */
public class Game implements State, Runnable {

    private static final long THREAD_SLEEP = 50;
    private Player player;
    private Map map;
    private boolean running = false;
    private boolean paused = false;
    private boolean save;

    public Game() {

    }

    public Game(final File saveGame) {
        throw new UnsupportedOperationException("opening games from savegame not supported yet!");
    }

    public void render(final Graphics2D g2d) {

    }

    public void run() {
        while (running) {
            if (!paused) {
                update();
            }
            try {
                Thread.sleep(THREAD_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(save){
            save();
        }
    }

    public void start() {
        running = true;
        if (!running) {
            new Thread(this).start();
        }
    }

    public void stop(final boolean save) {
        if (running) {
            this.save = save;
            running = false;
        }
    }

    public void save() {
        throw new UnsupportedOperationException("saving not supported yet!");
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    private void update() {
        map.update();
    }

    public void movePlayer(Point2D.Double location) {
        throw new UnsupportedOperationException("moving player not implemented yet");
    }

    public boolean isPaused() {
        return paused;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(final Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(final Map map) {
        this.map = map;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(final boolean running) {
        this.running = running;
    }

    public void setPaused(final boolean paused) {
        this.paused = paused;
    }

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }
}
