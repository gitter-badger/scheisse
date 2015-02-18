/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import org.dedda.games.scheisse_server.provider.LoginProvider;
import org.dedda.games.scheisse_server.provider.UserProvider;
import org.dedda.games.scheisse_server.util.Session;

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
