package org.dedda.games.scheisse.gui.cpu;

import org.dedda.games.scheisse.state.game.Game;

import java.awt.*;

/**
 * Created by dedda on 10/5/14.
 */
public class ContentContainer extends Container {

    /**
     * {@link Gui} this container belongs to.
     */
    private Gui gui;
    /**
     * {@link Game} the gui belongs to.
     */
    private Game game;
    /**
     * {@link TabbedGamePane} to put the content on.
     */
    private TabbedGamePane tabbedGamePane;

    /**
     *
     * @param gui {@link Gui} this container belongs to
     */
    public ContentContainer(final Gui gui) {
        this.gui = gui;
        this.game = gui.getGame();
        setLayout(new BorderLayout());
        this.tabbedGamePane = new TabbedGamePane(this);
        add(tabbedGamePane, BorderLayout.CENTER);
    }

    /**
     *
     * @return {@link Gui} this container belongs to
     */
    public Gui getGui() {
        return gui;
    }
}
