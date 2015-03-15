package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.server_persistence.UserProvider;
import org.dedda.games.scheisse.service.UserService;
import org.dedda.games.scheisse.service.transport.UserContainer;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.UUID;

@WebService(name = "UserService")
public class UserServiceHost implements UserService {

    @Inject
    private UserProvider provider;

    @Override
    @WebMethod(operationName = "login")
    public UUID login(@WebParam(name = "username")final String username, @WebParam(name = "password")final String password) {
        return null;
    }

    @Override
    @WebMethod(operationName = "logout")
    public void logout(@WebParam(name = "session")final UUID session) {

    }

    @Override
    @WebMethod(operationName = "getById")
    public UserContainer get(@WebParam(name = "userId")final long id, @WebParam(name = "session")final UUID session) {
        return null;
    }

    @Override
    @WebMethod(operationName = "searchByName")
    public List<UserContainer> search(@WebParam(name = "name")final String name, @WebParam(name = "session")final UUID session) {
        return null;
    }

    @WebMethod(exclude = true)
    public UserProvider getProvider() {
        return provider;
    }

    @WebMethod(exclude = true)
    public void setProvider(final UserProvider provider) {
        this.provider = provider;
    }
}
