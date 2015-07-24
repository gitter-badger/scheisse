package org.dedda.games.scheisse.game;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.dedda.games.scheisse.events.GameCommonEvent;
import org.dedda.games.scheisse.events.GameCommonEventListener;
import org.dedda.games.scheisse.events.item.ItemStoreEvent;
import org.dedda.games.scheisse.events.item.ItemStoreEventListener;
import org.dedda.games.scheisse.events.npc.NpcStoreEventListener;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by dedda on 7/24/15.
 *
 * @author dedda
 */
public class GameSessionTest {

    private GameCommonEventListener gameCommonEventListener;
    private boolean gameCommenEventTriggered;
    private ItemStoreEventListener itemStoreEventListener;
    private boolean itemStoreEventTriggered;
    private NpcStoreEventListener npcStoreEventListener;
    private boolean npcStoreEventTriggered;

    @Before
    public void setUp() throws Exception {
        GameSession.init();
        gameCommonEventListener = event -> {gameCommenEventTriggered = true;};
        gameCommenEventTriggered = false;
        itemStoreEventListener = event -> {itemStoreEventTriggered = true;};
        itemStoreEventTriggered = false;
        npcStoreEventListener = event -> {npcStoreEventTriggered = true;};
        npcStoreEventTriggered = false;
    }

    @Test
    public void testAddGameCommonEventListener() throws Exception {
        GameSession.addGameCommonEventListener(gameCommonEventListener);
        assertTrue(GameSession.getListeners().contains(gameCommonEventListener));
        assertFalse(gameCommenEventTriggered);
    }

    @Test
    public void testRemoveGameCommonEventListener() throws Exception {
        GameSession.addGameCommonEventListener(gameCommonEventListener);
        GameSession.removeGameCommonEventListener(gameCommonEventListener);
        assertFalse(GameSession.getListeners().contains(gameCommonEventListener));
        assertFalse(gameCommenEventTriggered);
    }

    @Test
    public void testAddItemStoreEventListener() throws Exception {
        GameSession.addItemStoreEventListener(itemStoreEventListener);
        assertTrue(GameSession.getListeners().contains(itemStoreEventListener));
        assertFalse(itemStoreEventTriggered);
    }

    @Test
    public void testRemoveItemStoreEventListener() throws Exception {
        GameSession.addItemStoreEventListener(itemStoreEventListener);
        GameSession.removeItemStoreEventListener(itemStoreEventListener);
        assertFalse(GameSession.getListeners().contains(itemStoreEventListener));
        assertFalse(itemStoreEventTriggered);
    }

    @Test
    public void testAddNpcStoreEventListener() throws Exception {
        GameSession.addNpcStoreEventListener(npcStoreEventListener);
        assertTrue(GameSession.getListeners().contains(npcStoreEventListener));
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testRemoveNpcStoreEventListener() throws Exception {
        GameSession.addNpcStoreEventListener(npcStoreEventListener);
        GameSession.removeNpcStoreEventListener(npcStoreEventListener);
        assertFalse(GameSession.getListeners().contains(npcStoreEventListener));
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testAddListener() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        assertTrue(GameSession.getGameCommonEventListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getGameCommonEventListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getGameCommonEventListeners().contains(npcStoreEventListener));

        assertFalse(GameSession.getItemStoreEventListeners().contains(gameCommonEventListener));
        assertTrue(GameSession.getItemStoreEventListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getItemStoreEventListeners().contains(npcStoreEventListener));

        assertFalse(GameSession.getNpcStoreEventListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getNpcStoreEventListeners().contains(itemStoreEventListener));
        assertTrue(GameSession.getNpcStoreEventListeners().contains(npcStoreEventListener));
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testRemoveListener() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.removeListener(gameCommonEventListener);
        GameSession.removeListener(itemStoreEventListener);
        GameSession.removeListener(npcStoreEventListener);
        assertFalse(GameSession.getListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getListeners().contains(npcStoreEventListener));
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testGameCommonEvent() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.gameCommonEvent(null);
        assertTrue(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testItemStoreEvent() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.itemStoreEvent(null);
        assertFalse(gameCommenEventTriggered);
        assertTrue(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testNpcStoreEvent() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.npcStoreEvent(null);
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertTrue(npcStoreEventTriggered);
    }

}
