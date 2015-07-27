package org.dedda.games.scheisse.game;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.dedda.games.scheisse.events.GameCommonEvent;
import org.dedda.games.scheisse.events.GameCommonEventListener;
import org.dedda.games.scheisse.events.item.ItemStoreEvent;
import org.dedda.games.scheisse.events.item.ItemStoreEventListener;
import org.dedda.games.scheisse.events.npc.NpcStoreEventListener;
import org.dedda.games.scheisse.events.user.UserStoreEventListener;
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
    private UserStoreEventListener userStoreEventListener;
    private boolean userStoreEventTriggered;

    @Before
    public void setUp() throws Exception {
        GameSession.init();
        gameCommonEventListener = event -> {gameCommenEventTriggered = true;};
        gameCommenEventTriggered = false;
        itemStoreEventListener = event -> {itemStoreEventTriggered = true;};
        itemStoreEventTriggered = false;
        npcStoreEventListener = event -> {npcStoreEventTriggered = true;};
        npcStoreEventTriggered = false;
        userStoreEventListener = event -> {userStoreEventTriggered = true;};
        userStoreEventTriggered = false;
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
    public void testAddUserStoreEventListener() throws Exception {
        GameSession.addUserStoreEventListener(userStoreEventListener);
        assertTrue(GameSession.getListeners().contains(userStoreEventListener));
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testRemoveUserStoreEventListener() throws Exception {
        GameSession.addUserStoreEventListener(userStoreEventListener);
        GameSession.removeUserStoreEventListener(userStoreEventListener);
        assertFalse(GameSession.getListeners().contains(userStoreEventListener));
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testAddListener() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.addListener(userStoreEventListener);
        assertTrue(GameSession.getGameCommonEventListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getGameCommonEventListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getGameCommonEventListeners().contains(npcStoreEventListener));
        assertFalse(GameSession.getGameCommonEventListeners().contains(userStoreEventListener));

        assertFalse(GameSession.getItemStoreEventListeners().contains(gameCommonEventListener));
        assertTrue(GameSession.getItemStoreEventListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getItemStoreEventListeners().contains(npcStoreEventListener));
        assertFalse(GameSession.getItemStoreEventListeners().contains(userStoreEventListener));

        assertFalse(GameSession.getNpcStoreEventListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getNpcStoreEventListeners().contains(itemStoreEventListener));
        assertTrue(GameSession.getNpcStoreEventListeners().contains(npcStoreEventListener));
        assertFalse(GameSession.getNpcStoreEventListeners().contains(userStoreEventListener));

        assertFalse(GameSession.getUserStoreEventListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getUserStoreEventListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getUserStoreEventListeners().contains(npcStoreEventListener));
        assertTrue(GameSession.getUserStoreEventListeners().contains(userStoreEventListener));
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testRemoveListener() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.addListener(userStoreEventListener);
        GameSession.removeListener(gameCommonEventListener);
        GameSession.removeListener(itemStoreEventListener);
        GameSession.removeListener(npcStoreEventListener);
        GameSession.removeListener(userStoreEventListener);
        assertFalse(GameSession.getListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getListeners().contains(npcStoreEventListener));
        assertFalse(GameSession.getListeners().contains(userStoreEventListener));
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testGameCommonEvent() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.addListener(userStoreEventListener);
        GameSession.gameCommonEvent(null);
        assertTrue(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testItemStoreEvent() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.addListener(userStoreEventListener);
        GameSession.itemStoreEvent(null);
        assertFalse(gameCommenEventTriggered);
        assertTrue(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testNpcStoreEvent() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.addListener(userStoreEventListener);
        GameSession.npcStoreEvent(null);
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertTrue(npcStoreEventTriggered);
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testUserStoreEvent() throws Exception {
        GameSession.addListener(gameCommonEventListener);
        GameSession.addListener(itemStoreEventListener);
        GameSession.addListener(npcStoreEventListener);
        GameSession.addListener(userStoreEventListener);
        GameSession.userStoreEvent(null);
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
        assertTrue(userStoreEventTriggered);
    }

}
