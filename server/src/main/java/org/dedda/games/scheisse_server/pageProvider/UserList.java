/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.pageProvider;

import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.server_persistence.UserProvider;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@RequestScoped
public class UserList {

    @Inject
    private UserProvider userProvider;

    public final List<String> getAllUserNames() {
        return userProvider.getAllUserNames();
    }

    public final List<User> getAllUsers() {
        return userProvider.getAllUsers();
    }

}
