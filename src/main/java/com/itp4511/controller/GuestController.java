package com.itp4511.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.itp4511.domain.Guest;
import com.itp4511.domain.Guestlistwithsessionandguestname_Multi;
import com.itp4511.service.*;
import com.itp4511.utils.Utility;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Vincent
 */
@WebServlet(name = "getGeustsController", urlPatterns = {"/getGeustsController"})

public class GuestController extends HttpServlet {


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



        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        int type = Integer.parseInt(request.getParameter("type"));
        switch (type) {

            case 1://display guest
                int id = Integer.parseInt(request.getParameter("userID"));
                List<Guest> guestList = guestService.getRelevantGuestByMemberID(id);

                json = mapper.writeValueAsString(guestList);



                response.getWriter().write(json); //  convey json to client
                break;
            case 2: //add guest
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                int memberID=Integer.parseInt( request.getParameter("memberID"));

                boolean isInsertGuest = guestService.addGuest(memberID, name, email);


                if (isInsertGuest) {
                    responseJson.put("message", "add ok");


                    response.getWriter().write(responseJson.toString());

                }
                break;


            case 3://delete guest
                int idForDel = Integer.parseInt(request.getParameter("userID"));
                boolean isDelete = guestService.deleteGuest(idForDel);

                if (isDelete) {

                    responseJson.put("message", "delete ok");
                    response.getWriter().write(responseJson.toString());

                }

                break;



            case 4://display guestList
                int sessionID = Integer.parseInt(request.getParameter("sessionID"));

                try {
                    List<Guestlistwithsessionandguestname_Multi> guestlist = guestlistService.getGeustlistBySessionID(sessionID);


                    json = mapper.writeValueAsString(guestlist);


                    response.getWriter().write(json); //  convey json to client
                } catch (IOException e) {

                    responseJson.put("message", "fail： "+e.getMessage());


                    response.getWriter().write(responseJson.toString());
                }
                break;



        }



    }
}
