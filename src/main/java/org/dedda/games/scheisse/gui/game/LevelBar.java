package org.dedda.games.scheisse.gui.game;

import org.dedda.games.scheisse.gui.Drawable;
import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.level.Level;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

/**
 * Class for indicating {@link Level} progress of the
 * {@link Player}in the {@link Game}.
 *
 * Created by dedda on 7/22/14.
 *
 * @author dedda
 */
public class LevelBar implements Drawable {

    /**
     * Location for rendering.
     */
    private Point location;

    /**
     * Size for rendering.
     */
    private Dimension size;

    /**
     * {@link Game} this bar belongs to for getting {@link Player} information.
     */
    private Game game;

    /**
     * {@link GameWindow} this bar belongs to.
     */
    private GameWindow gameWindow;

    /**
     * @param game {@link Game} this bar belongs to for getting
     *             {@link Player} information
     * @param gameWindow {@link GameWindow} this bar belongs to
     */
    public LevelBar(final Game game, final GameWindow gameWindow) {
        this.game = game;
        this.gameWindow = gameWindow;
        size = gameWindow.getHeaderToolbarSize();
        location = gameWindow.getHeaderToolbarLocation();
    }

    /**
     * Method for rendering this bar to the given {@link Graphics2D} canvas.
     *
     * @param g2d {@link Graphics2D} instance to draw on
     */
    public void render(final Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(0, 0, size.width, size.height);
        g2d.setColor(Color.GREEN);
        double filling = 0;
        long xp = game.getPlayer().getExperience();
        int level = Level.getLevel(xp);
        if (level == Level.MIN_XP_FOR_LEVELS.length-1) {
            filling = 1;
        } else {
            long xpOverLevel = xp - Level.MIN_XP_FOR_LEVELS[level];
            long minXPForNextLevel = Level.MIN_XP_FOR_LEVELS[level+1];
            filling = (double)xpOverLevel/minXPForNextLevel;
        }
        g2d.fillRect(0, 0, (int) (size.width * filling), size.height);
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Verdana", Font.BOLD, size.height - 2));
        g2d.drawString(xp + " exp", 3, size.height - 2);
    }
}
