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
        GameSession.getInstance().addGameCommonEventListener(gameCommonEventListener);
        assertTrue(GameSession.getInstance().getListeners().contains(gameCommonEventListener));
        assertFalse(gameCommenEventTriggered);
    }

    @Test
    public void testRemoveGameCommonEventListener() throws Exception {
        GameSession.getInstance().addGameCommonEventListener(gameCommonEventListener);
        GameSession.getInstance().removeGameCommonEventListener(gameCommonEventListener);
        assertFalse(GameSession.getInstance().getListeners().contains(gameCommonEventListener));
        assertFalse(gameCommenEventTriggered);
    }

    @Test
    public void testAddItemStoreEventListener() throws Exception {
        GameSession.getInstance().addItemStoreEventListener(itemStoreEventListener);
        assertTrue(GameSession.getInstance().getListeners().contains(itemStoreEventListener));
        assertFalse(itemStoreEventTriggered);
    }

    @Test
    public void testRemoveItemStoreEventListener() throws Exception {
        GameSession.getInstance().addItemStoreEventListener(itemStoreEventListener);
        GameSession.getInstance().removeItemStoreEventListener(itemStoreEventListener);
        assertFalse(GameSession.getInstance().getListeners().contains(itemStoreEventListener));
        assertFalse(itemStoreEventTriggered);
    }

    @Test
    public void testAddNpcStoreEventListener() throws Exception {
        GameSession.getInstance().addNpcStoreEventListener(npcStoreEventListener);
        assertTrue(GameSession.getInstance().getListeners().contains(npcStoreEventListener));
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testRemoveNpcStoreEventListener() throws Exception {
        GameSession.getInstance().addNpcStoreEventListener(npcStoreEventListener);
        GameSession.getInstance().removeNpcStoreEventListener(npcStoreEventListener);
        assertFalse(GameSession.getInstance().getListeners().contains(npcStoreEventListener));
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testAddUserStoreEventListener() throws Exception {
        GameSession.getInstance().addUserStoreEventListener(userStoreEventListener);
        assertTrue(GameSession.getInstance().getListeners().contains(userStoreEventListener));
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testRemoveUserStoreEventListener() throws Exception {
        GameSession.getInstance().addUserStoreEventListener(userStoreEventListener);
        GameSession.getInstance().removeUserStoreEventListener(userStoreEventListener);
        assertFalse(GameSession.getInstance().getListeners().contains(userStoreEventListener));
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testAddListener() throws Exception {
        GameSession.getInstance().addListener(gameCommonEventListener);
        GameSession.getInstance().addListener(itemStoreEventListener);
        GameSession.getInstance().addListener(npcStoreEventListener);
        GameSession.getInstance().addListener(userStoreEventListener);
        assertTrue(GameSession.getInstance().getGameCommonEventListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getInstance().getGameCommonEventListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getInstance().getGameCommonEventListeners().contains(npcStoreEventListener));
        assertFalse(GameSession.getInstance().getGameCommonEventListeners().contains(userStoreEventListener));

        assertFalse(GameSession.getInstance().getItemStoreEventListeners().contains(gameCommonEventListener));
        assertTrue(GameSession.getInstance().getItemStoreEventListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getInstance().getItemStoreEventListeners().contains(npcStoreEventListener));
        assertFalse(GameSession.getInstance().getItemStoreEventListeners().contains(userStoreEventListener));

        assertFalse(GameSession.getInstance().getNpcStoreEventListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getInstance().getNpcStoreEventListeners().contains(itemStoreEventListener));
        assertTrue(GameSession.getInstance().getNpcStoreEventListeners().contains(npcStoreEventListener));
        assertFalse(GameSession.getInstance().getNpcStoreEventListeners().contains(userStoreEventListener));

        assertFalse(GameSession.getInstance().getUserStoreEventListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getInstance().getUserStoreEventListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getInstance().getUserStoreEventListeners().contains(npcStoreEventListener));
        assertTrue(GameSession.getInstance().getUserStoreEventListeners().contains(userStoreEventListener));
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
    }

    @Test
    public void testRemoveListener() throws Exception {
        GameSession.getInstance().addListener(gameCommonEventListener);
        GameSession.getInstance().addListener(itemStoreEventListener);
        GameSession.getInstance().addListener(npcStoreEventListener);
        GameSession.getInstance().addListener(userStoreEventListener);
        GameSession.getInstance().removeListener(gameCommonEventListener);
        GameSession.getInstance().removeListener(itemStoreEventListener);
        GameSession.getInstance().removeListener(npcStoreEventListener);
        GameSession.getInstance().removeListener(userStoreEventListener);
        assertFalse(GameSession.getInstance().getListeners().contains(gameCommonEventListener));
        assertFalse(GameSession.getInstance().getListeners().contains(itemStoreEventListener));
        assertFalse(GameSession.getInstance().getListeners().contains(npcStoreEventListener));
        assertFalse(GameSession.getInstance().getListeners().contains(userStoreEventListener));
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testGameCommonEvent() throws Exception {
        GameSession.getInstance().addListener(gameCommonEventListener);
        GameSession.getInstance().addListener(itemStoreEventListener);
        GameSession.getInstance().addListener(npcStoreEventListener);
        GameSession.getInstance().addListener(userStoreEventListener);
        GameSession.getInstance().gameCommonEvent(null);
        assertTrue(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testItemStoreEvent() throws Exception {
        GameSession.getInstance().addListener(gameCommonEventListener);
        GameSession.getInstance().addListener(itemStoreEventListener);
        GameSession.getInstance().addListener(npcStoreEventListener);
        GameSession.getInstance().addListener(userStoreEventListener);
        GameSession.getInstance().itemStoreEvent(null);
        assertFalse(gameCommenEventTriggered);
        assertTrue(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testNpcStoreEvent() throws Exception {
        GameSession.getInstance().addListener(gameCommonEventListener);
        GameSession.getInstance().addListener(itemStoreEventListener);
        GameSession.getInstance().addListener(npcStoreEventListener);
        GameSession.getInstance().addListener(userStoreEventListener);
        GameSession.getInstance().npcStoreEvent(null);
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertTrue(npcStoreEventTriggered);
        assertFalse(userStoreEventTriggered);
    }

    @Test
    public void testUserStoreEvent() throws Exception {
        GameSession.getInstance().addListener(gameCommonEventListener);
        GameSession.getInstance().addListener(itemStoreEventListener);
        GameSession.getInstance().addListener(npcStoreEventListener);
        GameSession.getInstance().addListener(userStoreEventListener);
        GameSession.getInstance().userStoreEvent(null);
        assertFalse(gameCommenEventTriggered);
        assertFalse(itemStoreEventTriggered);
        assertFalse(npcStoreEventTriggered);
        assertTrue(userStoreEventTriggered);
    }

}
