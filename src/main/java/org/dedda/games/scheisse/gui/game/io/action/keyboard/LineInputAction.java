package org.dedda.games.scheisse.gui.game.io.action.keyboard;

import org.dedda.games.scheisse.gui.game.GameWindow;
import org.dedda.games.scheisse.gui.io.action.KeyActionInfo;

import java.awt.event.KeyEvent;

/**
 * Created by dedda on 7/3/14.
 */
public class LineInputAction extends GameKeyAction{

    private String text = "";

    public LineInputAction(final GameWindow gameWindow) {
        super(gameWindow);
    }

    public void perform(final KeyActionInfo info) {
        if(info.getKeyCode() != KeyEvent.VK_ENTER){
            text += (char)info.getKeyCode();
        }else{
            gameWindow.inputText(text);
            text = "";
        }
    }

}
