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


                boolean isInsertGuest = guestService.addGuest(1, name, email);


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
                int sessionSelected = Integer.parseInt(request.getParameter("sessionSelected"));

                try {
                    List<Guestlistwithsessionandguestname_Multi> guestlist = guestlistService.getGeustlistBySessionID(sessionSelected);


                    json = mapper.writeValueAsString(guestlist);


                    response.getWriter().write(json); //  convey json to client
                } catch (IOException e) {

                    responseJson.put("message", "fail： "+e.getMessage());


                    response.getWriter().write(responseJson.toString());
                }
                break;


//
//            case 4://display guestList
//                int idForGest = Integer.parseInt(request.getParameter("userID"));
//                 isDelete = guestService.deleteGuest(idForDel);
//
//                if (isDelete) {
//
//                    responseJson.put("message", "delete ok");
//                    response.getWriter().write(responseJson.toString());
//
//                }
//
//                break;
//
//
//
//
//            case 5:
//
//                List<Guest> guestList1 = guestService.getRelevantGuestByMemberID(1);
//                System.out.println("=================Session available=================");
//                for (Guest s : guestList1) {
//
//                    System.out.println("ID: " + s.getGuestId());
//                    System.out.print("Name: " + s.getGuestName());
//                }
//
//                break;
//            case 6:
////                            "\t\t 2 add a new guest "
//                List<Guest> guestList2 = guestService.getRelevantGuestByMemberID(1);
//                System.out.println("=================your guests=================");
//                for (Guest s : guestList2) {
//
//                    System.out.println("ID: " + s.getGuestId());
//                    System.out.print("Name: " + s.getGuestName());
//                }
//
//                System.out.println("=================add a new guest=================");
//
//                boolean isInsertGuest1=guestService.addGuest(1,"Emil","emil@gmail.com");
//
//                List<Guest> guest = guestService.getRelevantGuestByMemberID(1);
//
//                System.out.println("\n=================your guests=================");
//                for (Guest s : guest) {
//
//                    System.out.println("ID: " + s.getGuestId());
//                    System.out.print("Name: " + s.getGuestName());
//                }
//
//                System.out.println("=================add a new guest=================");
//
//
//
//
//
//
//                break;
//
//
//            case 7:
//
//                List<Guest> guests3 = guestService.getRelevantGuestByMemberID(1);
//                System.out.println("=================your guests=================");
//                for (Guest s : guests3) {
//
//                    System.out.println("ID: " + s.getGuestId());
//                    System.out.print("Name: " + s.getGuestName());
//                }
//
//                System.out.println("=================delete a guest=================");
//                int guestIDForDel = 0;
//                System.out.println("select your a guest to delete");
//                guestIDForDel  = Utility.readInt();
//
//
//                boolean isInsertGuest3=guestService.deleteGuest (guestIDForDel );
//
//                guests3 = guestService.getRelevantGuestByMemberID(guestIDForDel );
//
//                System.out.println("\n=================your guests=================");
//                for (Guest s : guests3) {
//
//                    System.out.print("ID: " + s.getGuestId());
//                    System.out.print("Name: " + s.getGuestName());
//                }
//
//                System.out.println("=================add a new guest=================");
//
//
//
//
//
//
//                break;
//
//
//














        }



    }
}
