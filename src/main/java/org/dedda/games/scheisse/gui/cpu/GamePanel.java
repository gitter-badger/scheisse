package org.dedda.games.scheisse.gui.cpu;

import org.dedda.games.scheisse.state.game.Game;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * Created by dedda on 10/5/14.
 */
public class GamePanel extends JPanel {

    private TabbedGamePane tabbedGamePane;
    private Game game;

    public GamePanel(final TabbedGamePane tabbedGamePane) {
        this.tabbedGamePane = tabbedGamePane;
        this.game = tabbedGamePane.getGui().getGame();
        setBackground(Color.black);
    }
}
