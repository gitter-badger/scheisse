/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.pageProvider;

import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.server_persistence.UserProvider;
import org.dedda.games.scheisse_server.util.Util;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class Register implements Serializable {

    private String name;

    private String password;

    private String email;

    @Inject
    private UserProvider userProvider;

    @PostConstruct
    public final void init() {
        reset();
    }

    public final String register() {
        if (!checkName() || !checkEmail() || !checkPassword()) {
            reset();
            return "register";
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPasswordHash(Util.MD5(password));
        userProvider.saveNewUser(user);
        return "index";
    }

    private final boolean checkName() {
        System.out.println("name: " + name);
        if (name == null || "".equals(name)) {
            return false;
        }
        return true;
    }

    private final boolean checkPassword() {
        System.out.println("password: " + password);
        if (password == null || "".equals(password)) {
            return false;
        }
        return false;
    }

    private final boolean checkEmail() {
        System.out.println("email: " + email);
        if (email == null || "".equals(email)) {
            return false;
        }
        return false;
    }

    private final void reset() {
        name = "";
        email = "";
        password = "";
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    public final String getEmail() {
        return email;
    }

    public final void setEmail(final String email) {
        this.email = email;
    }

}
