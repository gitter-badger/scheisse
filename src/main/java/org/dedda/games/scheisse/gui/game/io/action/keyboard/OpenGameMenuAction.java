package org.dedda.games.scheisse.gui.game.io.action.keyboard;

import org.dedda.games.scheisse.gui.game.GameWindow;
import org.dedda.games.scheisse.gui.io.action.KeyAction;
import org.dedda.games.scheisse.gui.io.action.KeyActionInfo;

import java.awt.event.KeyEvent;

/**
 * Created by dedda on 7/2/14.
 */
public class OpenGameMenuAction extends GameKeyAction implements KeyAction{

    private static final int[] KEYS = new int[]{KeyEvent.VK_ESCAPE};

    public OpenGameMenuAction(final GameWindow gameWindow) {
        super(gameWindow);
    }

    public void perform(final KeyActionInfo info) {
        boolean contained = false;
        for(int key : KEYS){
            if(info.getKeyCode() == key){
                contained = true;
                break;
            }
        }
        if(!contained){
            return;
        }
        if(gameWindow.isGameMenuOpened()){
            gameWindow.closeGameMenu();
        }else{
            gameWindow.openGameMenu();
        }
    }


}
