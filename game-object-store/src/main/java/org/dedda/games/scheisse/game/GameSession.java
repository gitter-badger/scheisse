package org.dedda.games.scheisse.game;

import org.dedda.games.scheisse.events.BaseListener;
import org.dedda.games.scheisse.events.GameCommonEvent;
import org.dedda.games.scheisse.events.GameCommonEventListener;
import org.dedda.games.scheisse.events.item.ItemStoreEvent;
import org.dedda.games.scheisse.events.item.ItemStoreEventListener;
import org.dedda.games.scheisse.events.npc.NpcStoreEvent;
import org.dedda.games.scheisse.events.npc.NpcStoreEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 7/24/15.
 *
 * @author dedda
 */
public final class GameSession {

    private static List<GameCommonEventListener> gameCommonEventListeners;
    private static List<ItemStoreEventListener> itemStoreEventListeners;
    private static List<NpcStoreEventListener> npcStoreEventListeners;

    public static void init() {
        gameCommonEventListeners = new ArrayList<>();
        itemStoreEventListeners = new ArrayList<>();
        npcStoreEventListeners = new ArrayList<>();
    }

    public static void gameCommonEvent(final GameCommonEvent event) {
        gameCommonEventListeners.forEach(l -> l.gameCommonEvent(event));
    }

    public static void itemStoreEvent(final ItemStoreEvent event) {
        itemStoreEventListeners.forEach(l -> l.itemStoreEvent(event));
    }

    public static void npcStoreEvent(final NpcStoreEvent event) {
        npcStoreEventListeners.forEach(l -> l.npcStoreEvent(event));
    }

    public static void addGameCommonEventListener(final GameCommonEventListener listener) {
        if (!gameCommonEventListeners.contains(listener)) {
            gameCommonEventListeners.add(listener);
        }
    }

    public static void removeGameCommonEventListener(final GameCommonEventListener listener) {
        if (gameCommonEventListeners.contains(listener)) {
            gameCommonEventListeners.remove(listener);
        }
    }

    public static void addItemStoreEventListener(final ItemStoreEventListener listener) {
        if (!itemStoreEventListeners.contains(listener)) {
            itemStoreEventListeners.add(listener);
        }
    }

    public static void removeItemStoreEventListener(final ItemStoreEventListener listener) {
        if (itemStoreEventListeners.contains(listener)) {
            itemStoreEventListeners.remove(listener);
        }
    }

    public static void addNpcStoreEventListener(NpcStoreEventListener listener) {
        if (!npcStoreEventListeners.contains(listener)) {
            npcStoreEventListeners.add(listener);
        }
    }

    public static void removeNpcStoreEventListener(NpcStoreEventListener listener) {
        if (npcStoreEventListeners.contains(listener)) {
            npcStoreEventListeners.remove(listener);
        }
    }

    public static void addListener(final BaseListener listener) {
        if (listener instanceof GameCommonEventListener) {
            addGameCommonEventListener((GameCommonEventListener) listener);
        }
        if (listener instanceof ItemStoreEventListener) {
            addItemStoreEventListener((ItemStoreEventListener) listener);
        }
        if (listener instanceof NpcStoreEventListener) {
            addNpcStoreEventListener((NpcStoreEventListener) listener);
        }
    }

    public static void removeListener(final BaseListener listener) {
        if (listener instanceof GameCommonEventListener) {
            removeGameCommonEventListener((GameCommonEventListener) listener);
        }
        if (listener instanceof ItemStoreEventListener) {
            removeItemStoreEventListener((ItemStoreEventListener) listener);
        }
        if (listener instanceof NpcStoreEventListener) {
            removeNpcStoreEventListener((NpcStoreEventListener) listener);
        }
    }

    private GameSession() {

    }

    public static List<GameCommonEventListener> getGameCommonEventListeners() {
        return gameCommonEventListeners;
    }

    public static List<ItemStoreEventListener> getItemStoreEventListeners() {
        return itemStoreEventListeners;
    }

    public static List<NpcStoreEventListener> getNpcStoreEventListeners() {
        return npcStoreEventListeners;
    }

    public static List<BaseListener> getListeners() {
        List<BaseListener> allListeners = new ArrayList<>();
        allListeners.addAll(gameCommonEventListeners);
        allListeners.addAll(itemStoreEventListeners);
        allListeners.addAll(npcStoreEventListeners);
        return allListeners;
    }

}
