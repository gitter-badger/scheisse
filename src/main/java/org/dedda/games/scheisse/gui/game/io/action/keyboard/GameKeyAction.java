package org.dedda.games.scheisse.gui.game.io.action.keyboard;

import org.dedda.games.scheisse.gui.game.GameWindow;
import org.dedda.games.scheisse.gui.io.action.KeyAction;

/**
 * Created by dedda on 7/3/14.
 */
public abstract class GameKeyAction implements KeyAction{

    protected GameWindow gameWindow;

    public GameKeyAction(final GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
}
