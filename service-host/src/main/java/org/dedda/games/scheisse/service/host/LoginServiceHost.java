package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.service.LoginService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.UUID;

@WebService(name = "LoginService")
public class LoginServiceHost implements LoginService {

    @Inject
    private LoginSessionCache cache;

    @Override
    @WebMethod(operationName = "login")
    public UUID login(@WebParam(name = "username")final String username, @WebParam(name = "username")final String password) {
        return cache.login(username, password);
    }

    @Override
    @WebMethod(operationName = "logout")
    public void logout(@WebParam(name = "session")final UUID session) {
        cache.logout(session);
    }

    @WebMethod(exclude = true)
    public LoginSessionCache getCache() {
        return cache;
    }

    @WebMethod(exclude = true)
    public void setCache(LoginSessionCache cache) {
        this.cache = cache;
    }
}
