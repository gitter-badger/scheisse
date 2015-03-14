package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.service.transport.UserContainer;

import java.util.List;
import java.util.UUID;

/**
 * Created by dedda on 3/13/15.
 */
public interface UserService {

    public UUID login(final String username, final String password);

    public void logout(final UUID session);

    public UserContainer get(final long id, final UUID session);

    public List<UserContainer> search(final String name, final UUID session);

}
