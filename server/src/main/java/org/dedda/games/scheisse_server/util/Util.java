/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dedda
 */
public abstract class Util {
 
    public static String MD5(final String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
    
    public static Connection getDatabaseConnection() throws SQLException {
        String connectionUrl = Config.getDatabaseUrl() + "?user=" + Config.getDatabaseUser() + "&password=" + Config.getDatabasePassword();
        Connection connection = DriverManager.getConnection(connectionUrl);
        return connection;
    }
    
}
