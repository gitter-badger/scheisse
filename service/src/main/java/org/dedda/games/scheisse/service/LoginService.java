package org.dedda.games.scheisse.service;

import java.util.UUID;

/**
 * Created by dedda on 3/14/15.
 */
public interface LoginService {

    public UUID login(final String username, final String password);

    public void logout(final UUID session);

}
