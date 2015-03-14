package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.User;

/**
 * Created by dedda on 3/12/15.
 */
public class UserContainer extends EntityContainer {
    public UserContainer(User user) {
        super(EntityType.USER, user);
    }
}
