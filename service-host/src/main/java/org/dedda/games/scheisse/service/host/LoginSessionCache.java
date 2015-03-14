package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.server_persistence.LoginProvider;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Named
@Singleton
public class LoginSessionCache {

    private Map<UUID, User> sessionMap;

    @Inject
    private LoginProvider provider;

    public LoginSessionCache() {
        sessionMap = new HashMap<>();
    }

    public UUID login(final String username, final String password) {
        if (!provider.checkLogin(username, password)) {
            return null;
        }
        UUID session;
        while (sessionMap.containsKey(session = UUID.randomUUID()));
        return session;
    }

    public void logout(final UUID session) {
        if (sessionMap.containsKey(session)) {
            sessionMap.remove(session);
        }
    }

    public LoginProvider getProvider() {
        return provider;
    }

    public void setProvider(LoginProvider provider) {
        this.provider = provider;
    }
}
