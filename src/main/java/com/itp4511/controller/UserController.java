package com.itp4511.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.domain.Session;
import com.itp4511.domain.User;
import com.itp4511.domain.Userinfo;
import com.itp4511.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.itp4511.domain.User;
import org.jfree.util.Log;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Vincent
 */
@WebServlet(name = "userControllerTest", urlPatterns = {"/userControllerTest"})

public class UserController extends HttpServlet {



    private UserService userService = new UserService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test");


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //for ajax to take successful json string.
        ObjectNode responseJson = JsonNodeFactory.instance.objectNode();
        responseJson.put("status", "ok");



        int type =  Integer.parseInt(request.getParameter("type"));

            //region Case : check user account

                switch (type) {

                    case 1:

                        String account=   request.getParameter("account");
                        String password =   request.getParameter("password");
                        Userinfo userInfo = userService.getUserByAccAndPwd(account,password);



                        if (userInfo!=null) {


                        request.setAttribute("u", userInfo);

                            HttpSession session = request.getSession();
                            session.setAttribute("authenticated", true);

                            session.setAttribute("username", userInfo.getUserName());
                            session.setAttribute("userID",String.valueOf( userInfo.getUserId()));
                            session.setAttribute("roleTitle", userInfo.getRoleTitle());//role of user
                            response.sendRedirect("/mainPage.jsp");


                        } else {
                            request.getSession().invalidate();
                            RequestDispatcher rd;
                            rd = getServletContext().getRequestDispatcher("/loginError.jsp");
                            rd.forward(request, response);

                        }
                        break;
                    case 2:

                        String userName=   request.getParameter("userName");
                        String userAcc =   request.getParameter("userAcc");

                        String userEmail=   request.getParameter("userEmail");
                        String userPassword =   request.getParameter("userPassword");
                        User userForCreate = userService.createAccount(userAcc,userPassword,userEmail,userName);


                        if (userForCreate!=null) {


                            request.setAttribute("u", userForCreate);

                            HttpSession session = request.getSession();
                            session.setAttribute("authenticated", true);

                            session.setAttribute("username", userForCreate.getUserName());
                            session.setAttribute("userID", userForCreate.getUserId());
                            session.setAttribute("role", userForCreate.getUserType());//role of user
                            response.sendRedirect("/mainPage.jsp");


                        } else {

                            RequestDispatcher rd;
                            rd = getServletContext().getRequestDispatcher("/signup.jsp");
                            rd.forward(request, response);

                        }
                        break;



                    case 3:





                        try {

                            List<Userinfo> getAllUserInfo = null;
                            try {
                                getAllUserInfo = userService.getMembers();
                            } catch (Exception e) {
                                Log.debug(e.getMessage());
                            }
                            ObjectMapper mapper = new ObjectMapper();

                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            mapper.setDateFormat(dateFormat);
                            String json = mapper.writeValueAsString(getAllUserInfo);

                            response.getWriter().write(json);
                        } catch (IOException e) {
                            responseJson.put("message", "fail： "+e.getMessage());
                            response.getWriter().write(responseJson.toString());
                        }

                        break;

                }



    }
}
