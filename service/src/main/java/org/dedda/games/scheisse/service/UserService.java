package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.entity.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by dedda on 3/13/15.
 */
public interface UserService {

    public User get(final long id, final UUID session);

    public List<User> search(final String name, final UUID session);

}
