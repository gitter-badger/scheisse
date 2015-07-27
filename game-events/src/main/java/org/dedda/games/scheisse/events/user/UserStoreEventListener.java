package org.dedda.games.scheisse.events.user;

import org.dedda.games.scheisse.events.BaseListener;

/**
 * Created by dedda on 7/27/15.
 *
 * @author dedda
 */
public interface UserStoreEventListener extends BaseListener {

    void userStoreEvent(UserStoreEvent event);

}
