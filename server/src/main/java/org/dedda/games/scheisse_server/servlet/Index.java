/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.servlet;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

/**
 *
 * @author dedda
 */
public class Index extends BasicServlet{

    private static final String TITLE = "Home";
    
    @Override
    protected final void printHead(final HttpServletRequest request, final PrintWriter out) {
        out.println("<TITLE>" + TITLE + "</TITLE>");
        out.println("<link rel=\"stylesheet\" type=\"test/css\" href=\"resources/css/base.css\"/>");
    }

    @Override
    protected final void printBody(final HttpServletRequest request, final PrintWriter out) {
        out.println("<h1>Test</h1>");
    }
    
}
