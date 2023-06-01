package com.itp4511.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.itp4511.domain.*;
import com.itp4511.service.*;
import com.itp4511.utils.Utility;
import com.itp4511.domain.SessionObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
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
@WebServlet(name = "BookingController", urlPatterns = {"/bookingController"})

public class BookingController extends HttpServlet {


    private boolean loop = true;
    private UserService userService = new UserService();
    private VenueService venueService = new VenueService();
    private SessionService sessionService = new SessionService();
    private BookingRecordService bookingRecordService = new BookingRecordService();
    private GuestService guestService = new GuestService();
    private GuestlistService guestlistService = new GuestlistService();

    public static final Logger LOG = LoggerFactory.getLogger(OtherController.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //for ajax to take successful json string.
        ObjectNode responseJson = JsonNodeFactory.instance.objectNode();
        responseJson.put("status", "ok");
        int type = 0;
        if (request.getParameter("type") == null)

            type = 2;
        else
            type = Integer.parseInt(request.getParameter("type"));
        //set insert type = others
        switch (type) {

            //region 1: display booking by id
            case 1:


                int memberID = Integer.parseInt(request.getParameter("memberID"));
                try {
                    // List<BookingInfo_MM> displaySessionByID = sessionService.displaySessionByID(id);

                    List<BookingSession_Multi> displaySessionByID = bookingRecordService.getBookingByID(memberID);
                    ObjectMapper mapper = new ObjectMapper();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    mapper.setDateFormat(dateFormat);
                    String json = mapper.writeValueAsString(displaySessionByID);

                    response.getWriter().write(json);
                } catch (IOException e) {
                    responseJson.put("message", "fail： " + e.getMessage());
                    response.getWriter().write(responseJson.toString());
                }

                break;

            //endregion

            //region 2: book a venue with session
            case 2:

                Object[][] bachList = null;
                Integer bookingMemberID = null;
                Double bookingFee = null;

                try {

                    BufferedReader reader = request.getReader();
                    StringBuilder sb = new StringBuilder();
                    String line;
                    //can check if a array?
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    reader.close();


                    ObjectMapper objectMapper = new ObjectMapper();
                    List<SessionObj> sessionObjs = objectMapper.readValue(sb.toString(), new TypeReference<List<SessionObj>>() {
                    });

                    bachList = new Object[sessionObjs.size()][5];

                    int i = 0;
                    for (SessionObj s : sessionObjs) {
                        bachList[i][0] = 0;
                        bachList[i][1] = 0;
                        bachList[i][2] = 1;
                        bachList[i][3] = Integer.parseInt(s.getSessionID());
                        bachList[i][4] = s.getGuestList();
                        bookingMemberID = s.getUserID();
                        bookingFee = s.getTotalPrice();
                        i++;

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }


                try {
                    boolean isUpdate = bookingRecordService.insertBookingRecords(bookingMemberID, bookingFee, bachList);
                    if (isUpdate) {
                        responseJson.put("message", "add ok");


                        response.getWriter().write(responseJson.toString());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }

                break;
            //endregion

            //region 3: Update all attributes including receipt
            case 3:


                LOG.debug("Enter case 3 ");

                int memberUnapproved = 0;
                try {
                    memberUnapproved = Integer.parseInt(request.getParameter("memberID"));
                } catch (NumberFormatException e) {
                    LOG.debug("err when parse para ID " + e.getMessage());
                }

                try {

                    List<BookingInfo_MM> displaySessionByID = null;
                    try {

                        // displaySessionByID = bookingRecordService.getBookingByID(memberUnapproved);

                        displaySessionByID = (memberUnapproved == 999 ? sessionService.displayALLBookingInfoNeedApproval() : sessionService.displayBookingInfoNeedApproval(memberUnapproved));


                    } catch (Exception e) {
                        LOG.debug(e.getMessage());
                    }

                    ObjectMapper mapper = new ObjectMapper();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    mapper.setDateFormat(dateFormat);
                    String json = mapper.writeValueAsString(displaySessionByID);

                    response.getWriter().write(json);
                } catch (IOException e) {
                    responseJson.put("message", "fail： " + e.getMessage());
                    response.getWriter().write(responseJson.toString());
                }

                break;


            //endregion


            //region 4: add or remove guest from guestlist within the booking record
            case 4:

                int idForAppr = Integer.parseInt(request.getParameter("id"));
                try {
                    boolean isApproved = bookingRecordService.approveBooking(idForAppr);
                    ObjectMapper mapper = new ObjectMapper();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    mapper.setDateFormat(dateFormat);
                    String json = mapper.writeValueAsString("OKOK");

                    response.getWriter().write(json);
                } catch (IOException e) {
                    responseJson.put("message", "fail： " + e.getMessage());
                    response.getWriter().write(responseJson.toString());
                }


                break;
            //endregion


            //region 5: get booking record approved with userID
            case 5:


                int memberForAppr = Integer.parseInt(request.getParameter("memberID"));


                try {

               //     displaySessionByID = (memberUnapproved == 999 ? sessionService.displayALLBookingInfoNeedApproval() : sessionService.displayBookingInfoNeedApproval(memberUnapproved));



                    List<BookingInfo_MM> displaySessionByID = (memberForAppr == 999 ? sessionService.displayAllBookingInfoApproved() :sessionService.displayBookingInfoApproved(memberForAppr));
                    ObjectMapper mapper = new ObjectMapper();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    mapper.setDateFormat(dateFormat);
                    String json = mapper.writeValueAsString(displaySessionByID);

                    response.getWriter().write(json);
                } catch (IOException e) {
                    responseJson.put("message", "fail： " + e.getMessage());
                    response.getWriter().write(responseJson.toString());
                }

                break;


            //endregion


            //region 6: display booking by id
            case 6:

                int memberIDForOthersRecords = Integer.parseInt(request.getParameter("memberID"));
                try {
                    // List<BookingInfo_MM> displaySessionByID = sessionService.displaySessionByID(id);

                    List<BookingSession_Multi> displaySessionByID = bookingRecordService.getBookingByIDForNonUnapprovedRecord(memberIDForOthersRecords);
                    ObjectMapper mapper = new ObjectMapper();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    mapper.setDateFormat(dateFormat);
                    String json = mapper.writeValueAsString(displaySessionByID);

                    response.getWriter().write(json);
                } catch (IOException e) {
                    responseJson.put("message", "fail： " + e.getMessage());
                    response.getWriter().write(responseJson.toString());
                }

                break;

            //endregion


        }
    }
}
