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

import static org.dedda.games.scheisse_server.util.Pages.INDEX;
import static org.dedda.games.scheisse_server.util.Pages.REGISTER;

@ManagedBean
@RequestScoped
public class Register implements Serializable{
    
    private String name;
    
    private String password;
    
    private String email;
    
    @Inject
    private UserProvider userProvider;
    
    @PostConstruct
    public void init() {
        reset();
    }
    
    public String register() {
        if (!checkName() || !checkEmail() || !checkPassword()) {
            reset();
            return REGISTER;
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPasswordHash(Util.MD5(password));
        userProvider.saveNewUser(user);
        return INDEX;
    }

    private boolean checkName() {
        System.out.println("name: " + name);
        if (name == null || "".equals(name)) {
            return false;
        }
        return true;
    }
    
    private boolean checkPassword() {
        System.out.println("password: " + password);
        if (password == null || "".equals(password)) {
            return false;
        }
        return false;
    }
    
    private boolean checkEmail() {
        System.out.println("email: " + email);
        if (email == null || "".equals(email)) {
            return false;
        }
        return false;
    }
    
    private void reset() {
        name = "";
        email = "";
        password = "";
    }
    
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
    
}
