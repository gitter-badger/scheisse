/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.transport;

import java.io.Serializable;

public class LoginContainer implements Serializable {
    
    public final String name;
    public final String password;

    public LoginContainer(final String name, final String password) {
        this.name = name;
        this.password = password;
    }
    
}
