package org.dedda.games.scheisse.gui.game.io.action.keyboard;

import org.dedda.games.scheisse.gui.game.GameWindow;
import org.dedda.games.scheisse.gui.io.action.KeyAction;
import org.dedda.games.scheisse.gui.io.action.KeyActionInfo;

import java.awt.event.KeyEvent;

/**
 * Created by dedda on 7/3/14.
 */
public class ArrowKeyAction extends GameKeyAction implements KeyAction {

    public ArrowKeyAction(final GameWindow gameWindow) {
        super(gameWindow);
    }

    public void perform(final KeyActionInfo info) {
        if (info.getKeyCode() == KeyEvent.VK_UP) {
            gameWindow.selectionUp();
        } else if (info.getKeyCode() == KeyEvent.VK_LEFT) {
            gameWindow.selectionLeft();
        } else if (info.getKeyCode() == KeyEvent.VK_DOWN) {
            gameWindow.selectionDown();
        } else if (info.getKeyCode() == KeyEvent.VK_RIGHT) {
            gameWindow.selectionRight();
        }
    }
}
