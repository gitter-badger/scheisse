package org.dedda.games.scheisse.gui.io;

import org.dedda.games.scheisse.gui.io.action.MouseAction;
import org.dedda.games.scheisse.gui.io.action.MouseActionInfo;

import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

/**
 * Created by dedda on 4/18/14.
 */
public class Mouse
        implements  MouseListener,
                    MouseMotionListener,
                    MouseWheelListener {

    public static final int CLICKED = 1;
    public static final int PRESSED = 2;
    public static final int RELEASED = 3;
    public static final int ENTERED = 4;
    public static final int EXITED = 5;
    public static final int DRAGGED = 6;
    public static final int MOVED = 7;
    public static final int WHEEL_MOVED = 8;

    private ArrayList<MouseAction> clickAction = new ArrayList<MouseAction>();
    private ArrayList<MouseAction> pressAction = new ArrayList<MouseAction>();
    private ArrayList<MouseAction> releaseAction = new ArrayList<MouseAction>();
    private ArrayList<MouseAction> enterAction = new ArrayList<MouseAction>();
    private ArrayList<MouseAction> exitAction = new ArrayList<MouseAction>();
    private ArrayList<MouseAction> dragAction = new ArrayList<MouseAction>();
    private ArrayList<MouseAction> moveAction = new ArrayList<MouseAction>();
    private ArrayList<MouseAction> wheelAction = new ArrayList<MouseAction>();

    public Mouse(final Frame frame) {
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
        frame.addMouseWheelListener(this);
    }

    public Mouse(final JFrame frame) {
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
        frame.addMouseWheelListener(this);
    }

    public void addAction(final MouseAction action, final int triggerMode) {
        if (triggerMode == CLICKED) {
            clickAction.add(action);
        } else if (triggerMode == PRESSED) {
            pressAction.add(action);
        } else if (triggerMode == RELEASED) {
            releaseAction.add(action);
        } else if (triggerMode == ENTERED) {
            enterAction.add(action);
        } else if (triggerMode == EXITED) {
            exitAction.add(action);
        } else if (triggerMode == DRAGGED) {
            dragAction.add(action);
        } else if (triggerMode == MOVED) {
            moveAction.add(action);
        } else if (triggerMode == WHEEL_MOVED) {
            wheelAction.add(action);
        }
    }

    public void mouseClicked(final MouseEvent mouseEvent) {
        for (MouseAction mouseAction : clickAction) {
            int button = mouseEvent.getButton();
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            mouseAction.perform(
                    new MouseActionInfo(button, 0, x, y)
            );
        }
    }

    public void mousePressed(final MouseEvent mouseEvent) {
        for (MouseAction mouseAction : pressAction) {
            mouseAction.perform(
                    new MouseActionInfo(mouseEvent.getButton(), 0, 0, 0)
            );
        }
    }

    public void mouseReleased(final MouseEvent mouseEvent) {
        for (MouseAction mouseAction : releaseAction) {
            mouseAction.perform(
                    new MouseActionInfo(mouseEvent.getButton(), 0, 0, 0)
            );
        }
    }

    public void mouseEntered(final MouseEvent mouseEvent) {
        for (MouseAction mouseAction : enterAction) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            mouseAction.perform(
                    new MouseActionInfo(0, 0, x, y)
            );
        }
    }

    public void mouseExited(final MouseEvent mouseEvent) {
        for (MouseAction mouseAction : exitAction) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            mouseAction.perform(
                    new MouseActionInfo(0, 0, x, y)
            );
        }
    }

    public void mouseDragged(final MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        for (MouseAction mouseAction : dragAction) {
            mouseAction.perform(
                    new MouseActionInfo(mouseEvent.getButton(), 0, x, y)
            );
        }
    }

    public void mouseMoved(final MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        for (MouseAction mouseAction : moveAction) {
            mouseAction.perform(
                    new MouseActionInfo(0, 0, x, y)
            );
        }
    }

    public void mouseWheelMoved(final MouseWheelEvent mouseWheelEvent) {
        int x = mouseWheelEvent.getX();
        int y = mouseWheelEvent.getY();
        int scrollAmount = mouseWheelEvent.getScrollAmount();
        for (MouseAction mouseAction : wheelAction) {
            mouseAction.perform(
                    new MouseActionInfo(0, scrollAmount, x, y)
            );
        }
    }

    public ArrayList<MouseAction> getClickAction() {
        return clickAction;
    }

    public ArrayList<MouseAction> getPressAction() {
        return pressAction;
    }

    public ArrayList<MouseAction> getReleaseAction() {
        return releaseAction;
    }

    public ArrayList<MouseAction> getEnterAction() {
        return enterAction;
    }

    public ArrayList<MouseAction> getExitAction() {
        return exitAction;
    }

    public ArrayList<MouseAction> getDragAction() {
        return dragAction;
    }

    public ArrayList<MouseAction> getMoveAction() {
        return moveAction;
    }

    public ArrayList<MouseAction> getWheelAction() {
        return wheelAction;
    }
}
