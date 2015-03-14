package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.service.UserService;
import org.dedda.games.scheisse.service.transport.UserContainer;

import java.util.List;
import java.util.UUID;

/**
 * Created by dedda on 3/13/15.
 */
public class UserServiceHost implements UserService {
    @Override
    public UUID login(String username, String password) {
        return null;
    }

    @Override
    public void logout(UUID session) {

    }

    @Override
    public UserContainer get(long id, UUID session) {
        return null;
    }

    @Override
    public List<UserContainer> search(String name, UUID session) {
        return null;
    }
}
