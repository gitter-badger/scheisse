package org.dedda.games.scheisse.game;

import org.dedda.games.scheisse.events.BaseListener;
import org.dedda.games.scheisse.events.GameCommonEvent;
import org.dedda.games.scheisse.events.GameCommonEventListener;
import org.dedda.games.scheisse.events.item.ItemStoreEvent;
import org.dedda.games.scheisse.events.item.ItemStoreEventListener;
import org.dedda.games.scheisse.events.npc.NpcStoreEvent;
import org.dedda.games.scheisse.events.npc.NpcStoreEventListener;
import org.dedda.games.scheisse.events.user.UserStoreEvent;
import org.dedda.games.scheisse.events.user.UserStoreEventListener;

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
    private static List<UserStoreEventListener> userStoreEventListeners;

    private static ItemStore itemStore;
    private static NpcStore npcStore;
    private static UserStore userStore;

    public static void init() {
        gameCommonEventListeners = new ArrayList<>();
        itemStoreEventListeners = new ArrayList<>();
        npcStoreEventListeners = new ArrayList<>();
        userStoreEventListeners = new ArrayList<>();
        itemStore = new ItemStore();
        npcStore = new NpcStore();
        userStore = new UserStore();
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

    public static void userStoreEvent(final UserStoreEvent event) {
        userStoreEventListeners.forEach(l -> l.userStoreEvent(event));
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

    public static void addUserStoreEventListener(UserStoreEventListener listener) {
        if (!userStoreEventListeners.contains(listener)) {
            userStoreEventListeners.add(listener);
        }
    }

    public static void removeUserStoreEventListener(UserStoreEventListener listener) {
        if (userStoreEventListeners.contains(listener)) {
            userStoreEventListeners.remove(listener);
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
        if (listener instanceof UserStoreEventListener) {
            addUserStoreEventListener((UserStoreEventListener) listener);
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
        if (listener instanceof UserStoreEventListener) {
            removeUserStoreEventListener((UserStoreEventListener) listener);
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

    public static List<UserStoreEventListener> getUserStoreEventListeners() {
        return userStoreEventListeners;
    }

    public static List<BaseListener> getListeners() {
        List<BaseListener> allListeners = new ArrayList<>();
        allListeners.addAll(gameCommonEventListeners);
        allListeners.addAll(itemStoreEventListeners);
        allListeners.addAll(npcStoreEventListeners);
        allListeners.addAll(userStoreEventListeners);
        return allListeners;
    }

}
