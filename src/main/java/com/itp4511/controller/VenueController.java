package com.itp4511.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itp4511.domain.BookingSession_Multi;
import com.itp4511.domain.User;
import com.itp4511.domain.Userinfo;
import com.itp4511.domain.Venue;
import com.itp4511.service.UserService;
import com.itp4511.service.VenueService;

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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Vincent
 */
@WebServlet(name = "venueController", urlPatterns = {"/venueController"})

public class VenueController extends HttpServlet {



    private UserService userService = new UserService();
    private VenueService venueService = new VenueService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        //for ajax to take successful json string.

        int type =  Integer.parseInt(request.getParameter("type"));

            //region Case : check user account

                switch (type) {

                    case 1:





                        Gson gsonHandleFloat = new GsonBuilder()
                                .serializeSpecialFloatingPointValues()
                                .create();

                        try {
                            // List<BookingInfo_MM> displaySessionByID = sessionService.displaySessionByID(id);


                            List<Venue> venueList = venueService.getAllVenue();

                            String json=gsonHandleFloat.toJson(venueList);

//                            ObjectMapper mapper = new ObjectMapper();
//                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                            mapper.setDateFormat(dateFormat);
//                            String json = mapper.writeValueAsString(venueList);

                               response.getWriter().write(json);

                        } catch (IOException e) {
                            e.printStackTrace();
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


                }



    }
}
