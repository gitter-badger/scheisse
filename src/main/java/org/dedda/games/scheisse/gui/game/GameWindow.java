package org.dedda.games.scheisse.gui.game;

import org.dedda.games.scheisse.exception.gl.GLInitializationException;
import org.dedda.games.scheisse.gui.game.io.action.keyboard.OpenGameMenuAction;
import org.dedda.games.scheisse.gui.game.map.MapPanel;
import org.dedda.games.scheisse.gui.io.Keyboard;
import org.dedda.games.scheisse.gui.io.Mouse;
import org.dedda.games.scheisse.state.game.Game;

import javax.media.opengl.GLException;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dedda on 7/2/14.
 */
public class GameWindow extends JFrame {

    private Game game;
    private Mouse mouse;
    private Keyboard keyboard;
    private BottomToolbar bottomToolbar;
    private HeaderToolbar headerToolbar;
    private boolean gameMenuOpened = false;
    private ArrayList<GameGuiComponent> components;
    private GameGuiComponent focusedComponent;
    private ArrowSelectable focusedArrowSelectable;
    private MapPanel mapPanel;

    public GameWindow(final Game game) throws GLInitializationException {
        initMouse();
        initKeyboard();
        this.game = game;
        setSize(800, 600);
        setLocation(100, 100);
        setResizable(false);
        try {
            mapPanel = new MapPanel(game, this);
        } catch (GLException gle) {
            throw new GLInitializationException(gle);
        }
        headerToolbar = new HeaderToolbar(game, this);
        components = new ArrayList<GameGuiComponent>();

        addComponents();
        render();
    }

    private void initMouse() {
        mouse = new Mouse(this);
    }

    private void initKeyboard() {
        keyboard = new Keyboard(this);
        keyboard.addAction(new OpenGameMenuAction(this), Keyboard.RELEASED);
    }

    private void addComponents() {
        Container contentPane = getContentPane();
        contentPane.add(mapPanel);
        contentPane.add(headerToolbar);
    }

    public void update() {
        mapPanel.update();
    }

    public void render() {
        mapPanel.repaint();
        headerToolbar.repaint();
        getContentPane().repaint();
    }

    public void openGameMenu() {
        game.pause();
        gameMenuOpened = true;
    }

    public void closeGameMenu() {
        game.resume();
        gameMenuOpened = false;
    }

    public void addComponent(final GameGuiComponent component) {
        components.add(component);
        focusComponent(component);
    }

    public void removeComponent(final GameGuiComponent component) {
        if (components.contains(component)) {
            if (focusedComponent == component) {
                focusComponent(components.get(components.indexOf(component)-1));
            }
            components.remove(component);
        }

    }

    public void focusComponent(final GameGuiComponent component) {
        if (focusedComponent != null) {
            focusedComponent.setFocused(false);
        }
        focusedComponent = component;
        focusedComponent.setFocused(true);
        if (component instanceof ArrowSelectable) {
            focusedArrowSelectable = (ArrowSelectable) component;
        } else {
            focusedArrowSelectable = null;
        }
    }

    public void selectionUp() {
        if (!(focusedArrowSelectable == null)) {
           focusedArrowSelectable.up();
        }
    }

    public void selectionDown() {
        if (!(focusedArrowSelectable == null)) {
            focusedArrowSelectable.down();
        }
    }

    public void selectionLeft() {
        if (!(focusedArrowSelectable == null)) {
            focusedArrowSelectable.left();
        }
    }

    public void selectionRight() {
        if (!(focusedArrowSelectable == null)) {
            focusedArrowSelectable.right();
        }
    }

    public void inputText(final String text) {

    }

    public GameGuiComponent getFocusedComponent() {
        return focusedComponent;
    }

    public void setFocusedComponent(final GameGuiComponent focusedComponent) {
        this.focusedComponent = focusedComponent;
    }

    public ArrowSelectable getFocusedArrowSelectable() {
        return focusedArrowSelectable;
    }

    public void setFocusedArrowSelectable(final ArrowSelectable focusedArrowSelectable) {
        this.focusedArrowSelectable = focusedArrowSelectable;
    }

    public Game getGame() {
        return game;
    }

    public HeaderToolbar getHeaderToolbar() {
        return headerToolbar;
    }

    public BottomToolbar getBottomToolbar() {
        return bottomToolbar;
    }

    public boolean isGameMenuOpened() {
        return gameMenuOpened;
    }

    public Dimension getMapSize(){
        return new Dimension(getWidth(), getHeight()-20);
    }

    public Point getMapLocation(){
        return new Point(0, 20);
    }

    public Dimension getHeaderToolbarSize(){
        return new Dimension(getWidth(), 20);
    }

    public Point getHeaderToolbarLocation(){
        return new Point(0, 0);
    }

    public Dimension getBottomToolbarSize(){
        return new Dimension(0, 0);
    }

    public Point getBottomToolbarLocation(){
        return new Point(0, 0);
    }

}
