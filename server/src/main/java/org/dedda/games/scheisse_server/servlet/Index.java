/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.servlet;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dedda
 */
public class Index extends BasicServlet{

    private static final String title = "Home";
    
    @Override
    protected void printHead(HttpServletRequest request, PrintWriter out) {
        out.println("<title>" + title + "</title>");
        out.println("<link rel=\"stylesheet\" type=\"test/css\" href=\"resources/css/base.css\"/>");
    }

    @Override
    protected void printBody(HttpServletRequest request, PrintWriter out) {
        out.println("<h1>Test</h1>");
    }
    
}
