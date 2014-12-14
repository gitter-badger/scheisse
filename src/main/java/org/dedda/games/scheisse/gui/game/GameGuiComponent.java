package org.dedda.games.scheisse.gui.game;

import org.dedda.games.scheisse.state.game.Game;

import javax.media.opengl.awt.GLCanvas;
import java.awt.*;

/**
 * Created by dedda on 7/16/14.
 */
public abstract class GameGuiComponent extends GLCanvas {

    protected boolean focused;
    protected Game game;
    protected GameWindow gameWindow;

    public GameGuiComponent(final Game game, final GameWindow gameWindow) {
        this.game = game;
        this.gameWindow = gameWindow;
        focused = false;
    }

    public boolean isFocused() {
        return focused;
    }

    public void setFocused(final boolean focused) {
        this.focused = focused;
    }

    public abstract void relocate();

    public abstract void resize();

    public abstract void paintComponent(final Graphics g);

    public Game getGame() {
        return game;
    }

    public void setGame(final Game game) {
        this.game = game;
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public void setGameWindow(final GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
}
