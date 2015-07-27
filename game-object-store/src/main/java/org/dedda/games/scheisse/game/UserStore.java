package org.dedda.games.scheisse.game;

import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.events.user.UserStoreEvent;

import static org.dedda.games.scheisse.events.user.UserStoreEvent.CODE_USER_REGISTERED;
import static org.dedda.games.scheisse.events.user.UserStoreEvent.CODE_USER_UNREGISTERED;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
public class UserStore extends BasicStore<User> {

    private User loggedInUser;

    @Override
    protected void registerEvent(final long key, final User object) {
        GameSession.getInstance().userStoreEvent(new UserStoreEvent(CODE_USER_REGISTERED, object));
    }

    @Override
    protected void unregisterEvent(final long key, final User object) {
        GameSession.getInstance().userStoreEvent(new UserStoreEvent(CODE_USER_UNREGISTERED, object));
    }
}
