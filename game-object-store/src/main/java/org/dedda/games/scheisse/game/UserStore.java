package org.dedda.games.scheisse.game;

import org.dedda.games.scheisse.entity.User;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
public class UserStore extends BasicStore<User> {

    private User loggedInUser;

    @Override
    protected void registerEvent(final long key, final User object) {

    }

    @Override
    protected void unregisterEvent(final long key, final User object) {

    }
}
