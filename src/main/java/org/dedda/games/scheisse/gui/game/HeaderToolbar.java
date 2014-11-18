package org.dedda.games.scheisse.gui.game;

import org.dedda.games.scheisse.state.game.Game;

import javax.media.opengl.GLAutoDrawable;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Created by dedda on 7/2/14.
 *
 * @author dedda
 */
public class HeaderToolbar extends GameGuiComponent {

    private LevelBar levelBar;

    public HeaderToolbar(final Game game, final GameWindow gameWindow) {
        super(game, gameWindow);
        levelBar = new LevelBar(game, gameWindow);
    }

    @Override
    public void relocate() {
        setLocation(gameWindow.getHeaderToolbarLocation());
    }

    @Override
    public void resize() {
        setSize(gameWindow.getHeaderToolbarSize());
    }

    @Override
    public void paintComponent(final Graphics g) {
        levelBar.render((Graphics2D)g);
        repaint();
    }

    public void update() {

    }

    public void render(final GLAutoDrawable glAutoDrawable) {

    }
}
