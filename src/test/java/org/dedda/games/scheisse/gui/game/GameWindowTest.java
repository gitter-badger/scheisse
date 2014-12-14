package org.dedda.games.scheisse.gui.game;

import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.testInstances.TestArrowSelectableComponent;
import org.dedda.games.scheisse.testInstances.TestGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameWindowTest {

    GameWindow gameWindow;
    Game game;
    GameGuiComponent component;

    @Before
    public void setUp() throws Exception {
        game = new TestGame();
        gameWindow = new GameWindow(game);
        component = new TestArrowSelectableComponent(game, gameWindow);
        gameWindow.addComponent(component);
    }

    @After
    public void tearDown() throws Exception {
        gameWindow = null;
        game = null;
    }

    @Test
    public void testOpenGameMenu() throws Exception {
        gameWindow.openGameMenu();
        assertTrue(gameWindow.isGameMenuOpened());
    }

    @Test
    public void testCloseGameMenu() throws Exception {
        gameWindow.closeGameMenu();
        assertFalse(gameWindow.isGameMenuOpened());
    }

    @Test
    public void testAddComponent() throws Exception {
        assertSame(component, gameWindow.getFocusedComponent());
        assertSame(component, gameWindow.getFocusedArrowSelectable());
        assertTrue(component.isFocused());
        TestArrowSelectableComponent component1 = new TestArrowSelectableComponent(game, gameWindow);
        gameWindow.addComponent(component1);
        assertSame(component1, gameWindow.getFocusedComponent());
        assertSame(component1, gameWindow.getFocusedArrowSelectable());
        assertFalse(component.isFocused());
        assertTrue(component1.isFocused());
    }

    @Test
    public void testRemoveComponent() throws Exception {
        testAddComponent();
        GameGuiComponent component1 = gameWindow.getFocusedComponent();
        gameWindow.removeComponent(component1);
        assertTrue(component.isFocused());
        assertSame(component, gameWindow.getFocusedComponent());
    }

    @Test
    public void testSelection() throws Exception {
        TestArrowSelectableComponent component = (TestArrowSelectableComponent)gameWindow.getFocusedArrowSelectable();
        int ups =  component.getUp();
        int downs = component.getDown();
        int lefts = component.getLeft();
        int rights = component.getRight();
        gameWindow.selectionUp();
        assertEquals(ups+1, component.getUp());
        assertEquals(downs, component.getDown());
        assertEquals(lefts, component.getLeft());
        assertEquals(rights, component.getRight());
        gameWindow.selectionLeft();
        assertEquals(ups+1, component.getUp());
        assertEquals(downs, component.getDown());
        assertEquals(lefts+1, component.getLeft());
        assertEquals(rights, component.getRight());
        gameWindow.selectionDown();
        assertEquals(ups+1, component.getUp());
        assertEquals(downs+1, component.getDown());
        assertEquals(lefts+1, component.getLeft());
        assertEquals(rights, component.getRight());
        gameWindow.selectionRight();
        assertEquals(ups+1, component.getUp());
        assertEquals(downs+1, component.getDown());
        assertEquals(lefts+1, component.getLeft());
        assertEquals(rights+1, component.getRight());
    }
}
