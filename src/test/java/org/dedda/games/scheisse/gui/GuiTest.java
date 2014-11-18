package org.dedda.games.scheisse.gui;

import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.map.Map;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GuiTest {

    private Map map;
    private Game game;
    private Gui gui;

    @Before
    public void setUp() throws Exception {
        map = new Map(new Dimension(0, 0));
        game = new Game();
        game.setMap(map);
        game.setPlayer(new Player(true));
        game.getPlayer().setExperience(5);
        gui = new Gui(game);
    }

    @Test
    public void testStop(){
        gui.start();
        game.start();
        assertTrue(game.isRunning());
        gui.stop(false);
        assertFalse(game.isRunning());
    }

}