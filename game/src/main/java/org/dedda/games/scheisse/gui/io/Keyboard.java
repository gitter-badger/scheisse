package org.dedda.games.scheisse.gui.io;

import org.dedda.games.scheisse.gui.io.action.KeyAction;
import org.dedda.games.scheisse.gui.io.action.KeyActionInfo;

import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by dedda on 4/26/14.
 */
public class Keyboard implements KeyListener {

    public static final int TYPED = 1;
    public static final int PRESSED = 2;
    public static final int RELEASED = 3;

    private ArrayList<KeyAction> typeAction = new ArrayList<KeyAction>();
    private ArrayList<KeyAction> pressAction = new ArrayList<KeyAction>();
    private ArrayList<KeyAction> releaseAction = new ArrayList<KeyAction>();

    public Keyboard(final Frame frame) {
        frame.addKeyListener(this);
    }

    public Keyboard(final JFrame frame) {
        frame.addKeyListener(this);
    }

    public void addAction(final KeyAction action, final int triggerMode) {
        if (triggerMode == TYPED) {
            typeAction.add(action);
        } else if (triggerMode == PRESSED) {
            pressAction.add(action);
        } else if (triggerMode == RELEASED) {
            releaseAction.add(action);
        }
    }

    public void removeAction(final KeyAction action, final int triggerMode) {
        if (triggerMode == TYPED) {
            typeAction.remove(action);
        } else if (triggerMode == PRESSED) {
            pressAction.remove(action);
        } else if (triggerMode == RELEASED) {
            releaseAction.remove(action);
        }
    }

    public void keyTyped(final KeyEvent keyEvent) {
        for (KeyAction keyAction : typeAction) {
            keyAction.perform(new KeyActionInfo(keyEvent.getKeyCode()));
        }
    }

    public void keyPressed(final KeyEvent keyEvent) {
        for (KeyAction keyAction : pressAction) {
            keyAction.perform(new KeyActionInfo(keyEvent.getKeyCode()));
        }
    }

    public void keyReleased(final KeyEvent keyEvent) {
        for (KeyAction keyAction : releaseAction) {
            keyAction.perform(new KeyActionInfo(keyEvent.getKeyCode()));
        }
    }

    public ArrayList<KeyAction> getTypeAction() {
        return typeAction;
    }

    public ArrayList<KeyAction> getPressAction() {
        return pressAction;
    }

    public ArrayList<KeyAction> getReleaseAction() {
        return releaseAction;
    }
}
