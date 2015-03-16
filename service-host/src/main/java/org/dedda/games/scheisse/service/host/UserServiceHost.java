package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.entity.User;
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

    @Inject
    private LoginSessionCache loginSessionCache;

    @Override
    @WebMethod(operationName = "getById")
    public UserContainer get(@WebParam(name = "userId")final long id, @WebParam(name = "session")final UUID session) {
        User user = provider.getUser(id);
        User sessionUser = loginSessionCache.getForUUID(session);
        if (null == sessionUser || id != sessionUser.getId()) {
            String name = user.getName();
            user = new User();
            user.setId(id);
            user.setName(name);
        }
        return UserContainer.convert(user);
    }

    @Override
    @WebMethod(operationName = "searchByName")
    public List<UserContainer> search(@WebParam(name = "name")final String name, @WebParam(name = "session")final UUID session) {
        throw new UnsupportedOperationException("searching not implemented yet!");
    }

    @WebMethod(exclude = true)
    public UserProvider getProvider() {
        return provider;
    }

    @WebMethod(exclude = true)
    public void setProvider(final UserProvider provider) {
        this.provider = provider;
    }

    @WebMethod(exclude = true)
    public LoginSessionCache getLoginSessionCache() {
        return loginSessionCache;
    }

    @WebMethod(exclude = true)
    public void setLoginSessionCache(LoginSessionCache loginSessionCache) {
        this.loginSessionCache = loginSessionCache;
    }
}
