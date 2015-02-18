/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.util;

/**
 *
 * @author dedda
 */
public abstract class Config {
    
    private static String databaseUrl = "jdbc:mysql://192.168.2.115/scheisse";
    private static String databaseUser = "dedda";
    private static String databasePassword = "b3kj9e7";

    public static String getDatabaseUrl() {
        return databaseUrl;
    }

    public static String getDatabaseUser() {
        return databaseUser;
    }

    public static String getDatabasePassword() {
        return databasePassword;
    }
    
}
