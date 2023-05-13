package com.itp4511.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.domain.Guest;
import com.itp4511.domain.Session;
import com.itp4511.service.*;
import com.itp4511.utils.Utility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet(name = "sessionController", urlPatterns = {"/sessionController"})

public class sessionController extends HttpServlet {


    private boolean loop = true;
    private UserService userService = new UserService();
    private VenueService venueService = new VenueService();
    private SessionService sessionService = new SessionService();
    private BookingRecordService bookingRecordService = new BookingRecordService();
    private GuestService guestService = new GuestService();
    private GuestlistService guestlistService = new GuestlistService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //for ajax to take successful json string.
        ObjectNode responseJson = JsonNodeFactory.instance.objectNode();
        responseJson.put("status", "ok");



        int type =  Integer.parseInt(request.getParameter("type"));

            //region Case 3: Display session by date

                switch (type) {

                    case 1:
                        int campID =  Integer.parseInt(request.getParameter("campID"));
                        String date =   request.getParameter("date");
                        List<Session> sessionList = sessionService.displaySessionByDate(campID,date);

                        ObjectMapper mapper = new ObjectMapper();
                        String json = mapper.writeValueAsString(sessionList);


                        response.getWriter().write(json); //  convey json to client

                        break;
                    case 2:


                        List<Session> sessionListByIdandDate = sessionService.displaySessionByDateAndCampus(1, "2023-04-12");
                        System.out.println("=================Session available=================");
                        for (Session s : sessionListByIdandDate) {

                            System.out.print("Campus: " + s.getSessionCampus());
                            System.out.println("          Date: " + s.getSessionDate());
                            System.out.print("Start: " + s.getSessionStartTime());
                            System.out.println(" ---  End: " + s.getSessionEndTime());
                        }
                        break;


                    case 3:

                        int  bookID = Integer.parseInt(request.getParameter("bookID"));
                        try {
                            List<BookingInfo_MM>  displaySessionBookingID = sessionService.displaySessionBookingID(bookID);



                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


                        ObjectMapper mapper2 = new ObjectMapper();
                            mapper2.setDateFormat(dateFormat);
                        String json2 = mapper2.writeValueAsString(displaySessionBookingID);


                        response.getWriter().write(json2); //  convey json to client
                        } catch (NumberFormatException e) {
                            System.out.printf(e.getMessage());
                            e.printStackTrace();
                        }


                        break;

                }






    }
}
