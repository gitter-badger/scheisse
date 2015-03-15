/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.service;

import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.server_persistence.UserProvider;
import org.dedda.games.scheisse_server.transport.LoginContainer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "LoginService")
@Stateless
@Named
public class LoginService {
    
    @Inject
    private UserProvider userProvider;
    
    @Inject
    private LoginCache loginCache;

    @WebMethod(operationName = "login")
    public String login(
            @WebParam(name = "loginContainer")final LoginContainer loginContainer){
        String username = loginContainer.name;
        String password = loginContainer.password;
        User user = userProvider.getUser(username);
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String passwordHash = new String(digest.digest(password.getBytes()));
        if (!user.getPasswordHash().equals(passwordHash)) {
            return "";
        }
        String toDigest = user.getName() + "Session" + System.currentTimeMillis();
        String digested = new String(digest.digest(toDigest.getBytes()));
        return digested;
    }
    
    @WebMethod(operationName = "register")
    public String register(
            @WebParam(name = "email") final String email, 
            @WebParam(name = "username") final String username, 
            @WebParam(name = "password") final String password) {
        return "";
    }
    
    @WebMethod(operationName = "logout")
    public void logout(@WebParam(name = "session") final String sessionId) {
        
    }

    @WebMethod(exclude = true)
    public UserProvider getUserProvider() {
        return userProvider;
    }

    @WebMethod(exclude = true)
    public void setUserProvider(final UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @WebMethod(exclude = true)
    public LoginCache getLoginCache() {
        return loginCache;
    }

    @WebMethod(exclude = true)
    public void setLoginCache(final LoginCache LoginCache) {
        this.loginCache = LoginCache;
    }
    
    
    
}
