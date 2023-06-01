package com.itp4511.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//AddImage.java (Servlet)

/**
 *
 * @author Vincent
 */
@MultipartConfig
@WebServlet(name = "LoginController", urlPatterns = {"/loginController"})
public class LoginController extends HttpServlet {


      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession(false);
        String username = "";
        String userID= "";
        String userType= "";

        boolean authenticated = false;

        if (session != null && session.getAttribute("authenticated") != null) {
            username = (String) session.getAttribute("username");
            userID = (String) session.getAttribute("userID");
            userType = (String) session.getAttribute("role");
            authenticated = true;






        }

        Map<String, Object> sessionData = new HashMap<>();
        sessionData.put("username", username);
        sessionData.put("userID", userID);
        sessionData.put("userType", userType);
        sessionData.put("authenticated", authenticated);

        // 将session数据转为JSON格式返回给客户端
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(sessionData));
        out.flush();


    }


}
