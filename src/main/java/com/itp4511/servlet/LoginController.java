package com.itp4511.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.mysql.jdbc.Connection;
import ict.bean.UserInfo;
import ict.dbutils.UserDB;
import javax.servlet.annotation.WebServlet;



//AddImage.java (Servlet)
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Vincent
 */
@MultipartConfig
@WebServlet(name = "LoginController", urlPatterns = {"/main"})
public class LoginController extends HttpServlet {

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



        System.out.println("In do post method of Add Image servlet.");
        Part file=request.getPart("image");

//        String imageFileName=file.getSubmittedFileName();  // get selected image file name

        String cd = file.getHeader("Content-Disposition");
//截取不同类型的文件需要自行判断
        String imageFileName = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);


        System.out.println("Selected Image File Name : "+imageFileName);

        String uploadPath="./"+imageFileName;  // upload path where we have to upload our actual image
        System.out.println("Upload Path : "+uploadPath);

        // Uploading our selected image into the images folder





        try
        {

            FileOutputStream fos=new FileOutputStream(uploadPath);
            InputStream is=file.getInputStream();

            byte[] data=new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();



        }

        catch(Exception e)
        {
            e.printStackTrace();
        }



        request.setAttribute("imageFileName","Successfully upload"  );

        request.setAttribute("url","login.jsp");
        RequestDispatcher rd;

        rd = getServletContext().getRequestDispatcher("/errMessage.jsp");

        rd.forward(request, response);
        //**********************

        //getting database connection (jdbc code)


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

}
