package com.itp4511.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ict.bean.UserInfo;
import ict.dbutils.UserDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Vincent
 */
@WebServlet(name = "LoginController", urlPatterns = {"/main"})
public class LoginController_BU extends HttpServlet {

    private UserDB db;

    //controlelr直接從配置文件當中拿到默認的db值
    
    
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB(dbUrl, dbUser, dbPassword);
    }

      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("to login");
        String action = request.getParameter("action");









//Now you can save the file URL to your database

























        if (!isAuthenticated(request) && !("authenticate".equals(action))) {
            doLogin(request, response);
            return;
        }

        if ("authenticate".equals(action)) {
            doAuthenticate(request, response);
        } else if ("logout".equals(action)) {
            doLogout(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
        }
 
    }

    public void doAuthenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String targetURL;
        
       /*  
                if ("abc".equals(username) && "123".equals(password)) {
                    HttpSession session = request.getSession(true);
                    UserInfo bean = new UserInfo();
                    bean.setUsername(username);
                    bean.setPassword(password);
                    session.setAttribute("userInfo", bean);
                    targetURL = "welcome.jsp";//view component to handle 
                } else {
                    targetURL = "loginError.jsp";
                }
        */ 
        
// replace above with  db

        if (db.isValidUser(username, password)) {
            //session.setAttribute(
            HttpSession session = request.getSession(true);
           // user bean
            UserInfo bean = new UserInfo();
            bean.setUsername(username);
            bean.setPassword(password);
            // session transfer data
    
            session.setAttribute("userInfo", bean);
        
            targetURL = "welcome.jsp";
        
        
        } else {
            targetURL = "loginError.jsp";
        }

        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);

    }

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //get the userinfo from session
        return (session.getAttribute("userInfo") != null);
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String targetURL = "login.jsp";
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("userInfo");
            session.invalidate();
        }

        doLogin(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1)
                        .trim()
                        .replace("\"", "");
            }
        }
        return null;
    }





















}
















 