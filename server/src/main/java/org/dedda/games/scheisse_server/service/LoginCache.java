/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.service;

import org.dedda.games.scheisse.server_persistence.LoginProvider;
import org.dedda.games.scheisse.server_persistence.UserProvider;
import org.dedda.games.scheisse_server.util.Session;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Named
@Singleton
public class LoginCache {
    
    @Inject
    private UserProvider userProvider;
    @Inject
    private LoginProvider loginProvider;
    
    private Map<Long, Session> sessionMap;
    
    @PostConstruct
    public void init() {
        sessionMap = new HashMap<>();
    }
    
    
    
}
