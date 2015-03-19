/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.util;

import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author dedda
 */
@Named
@Stateless
public class Redirect {
    
    public final String getUserList(){
        return "userList";
    }
    
}
