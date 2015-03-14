/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.service;

import org.dedda.games.scheisse.server_persistence.UserProvider;
import org.dedda.games.scheisse_server.transport.InventoryContainer;
import org.dedda.games.scheisse_server.transport.UserContainer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author dedda
 */
@WebService(serviceName = "UserService")
@Stateless
@Named
public class UserService {

    @Inject
    private UserProvider userProvider;
    
    @WebMethod(operationName = "getUser")
    public UserContainer getUser(@WebParam(name = "id") final long id) {
        UserContainer user = new UserContainer(userProvider.getUser(id));
        return user;
    }
    
    @WebMethod(operationName = "getUserWithPassword")
    public UserContainer getUserWithLogin(@WebParam(name = "id") final long id, @WebParam(name = "password") final String password) {
        return null;
    }
    
    @WebMethod(operationName = "changePassword")
    public boolean changePassword(@WebParam(name = "id") final long id, @WebParam(name = "oldPassword") final String oldPassword, @WebParam(name = "newPassword") final String password) {
        
        return false;
    }
    
    @WebMethod(operationName = "getContacts")
    public UserContainer[] getContacts(@WebParam(name = "id") final long id) {
        return null;
    }

    @WebMethod(operationName = "getInventoryFor")
    public InventoryContainer getInventoryFor(final long userId) {
        return null;
    }
    
    @WebMethod(exclude = true)
    public UserProvider getUserProvider() {
        return userProvider;
    }

    @WebMethod(exclude = true)
    public void setUserProvider(UserProvider userProvider) {
        this.userProvider = userProvider;
    }
    
}
