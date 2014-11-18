package org.dedda.games.scheisse.gui.cpu;

import org.dedda.games.scheisse.state.game.Game;

import java.awt.Container;
import java.awt.BorderLayout;

/**
 * Created by dedda on 10/5/14.
 */
public class ContentContainer extends Container {

    private Gui gui;
    private Game game;
    private TabbedGamePane tabbedGamePane;

    public ContentContainer(final Gui gui) {
        this.gui = gui;
        this.game = gui.getGame();
        setLayout(new BorderLayout());
        this.tabbedGamePane = new TabbedGamePane(this);
        add(tabbedGamePane, BorderLayout.CENTER);
    }

    public Gui getGui() {
        return gui;
    }
}
