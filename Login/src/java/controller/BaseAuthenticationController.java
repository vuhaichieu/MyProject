/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author vuhai
 */
public abstract class BaseAuthenticationController extends HttpServlet {

    private boolean isAuthenticated(HttpServletRequest req) {
        return req.getSession().getAttribute("account") != null;
    }
    
    protected abstract void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    protected abstract void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isAuthenticated(req)) {
            //code business
            processPost(req, resp);
        } else {
            resp.getWriter().println("access denied!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isAuthenticated(req)) {
            //code business
            processGet(req, resp);
        } else {
            resp.getWriter().println("access denied!");
        }
    }

}
