package com.itp4511.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.domain.Guest;
import com.itp4511.domain.Guestlistwithsessionandguestname_Multi;
import com.itp4511.domain.Session;
import com.itp4511.service.*;
import com.itp4511.utils.Utility;
import lombok.NoArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //for ajax to take successful json string.
        ObjectNode responseJson = JsonNodeFactory.instance.objectNode();
        responseJson.put("status", "ok");


        int type = Integer.parseInt(request.getParameter("type"));

        //set insert type = others
        switch (type) {

            //region 1: display booking by id
            case 1:



                int id = Integer.parseInt(request.getParameter("userID"));
                try {
                    List<BookingInfo_MM> displaySessionByID = sessionService.displaySessionByID(id);
                    ObjectMapper mapper = new ObjectMapper();
                    // 在此處將日期格式化
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    mapper.setDateFormat(dateFormat);
                    String json = mapper.writeValueAsString(displaySessionByID);

                    response.getWriter().write(json); // 將 JSON 傳遞給客戶端
                } catch (IOException e) {
                    responseJson.put("message", "fail： "+e.getMessage());
                    response.getWriter().write(responseJson.toString());
                }

                break;

            //endregion

            //region 2: book a venue with session
            case 2:


                /*
                 *1.createbooking, inser into JS
                 *2.sessionGuestList, create and insert into JS
                 *3.sessionStatus : specified by user = chagne to by default
                 *4.sessionID: specified by user
                 *5.array with selected guestID
                 * bookingID,--,sessionStatus,sessionID
                 * id,status,sessionID,Guest array
                 * */
                Object[][] bachList=null;


                try {
                    // 讀取 POST 請求中名為 'result' 的數據
                    BufferedReader reader = request.getReader();
                    StringBuilder sb = new StringBuilder();
                    String line;
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
                        bachList[i][2] = 3;
                        bachList[i][3] = Integer.parseInt(s.getSessionID());
                        bachList[i][4] =   s.getGuestList();
                        i++;

                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }




                try {
                    boolean isUpdate = bookingRecordService.insertBookingRecords(1, bachList);
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
                System.out.println("=================Update receipt=================");


                boolean isSuccess = bookingRecordService.updateBookingAllInfoByMemberID(1, "testImagePath");
                System.out.println("=================Session available=================");


                //DMLBach
                //"UPDATE `session` SET  `sessionFKbookingRecord`=? ,`sessionStatus`=? where  `sessionID`=?"
                //1.create book
                //2.create session


                break;
            //endregion


            //region 4: add or remove guest from guestlist within the booking record
            case 4:
                System.out.println("=================Update receipt=================");



                            /*
                              原則，區分一對多的，單個的，一堆多的，單獨來出來熱處理
                                   1.輸入id——或選中
                                    2.彈出值
                                    3.進行修改
                                    4.查驗是否更改，進行更新
*/
                                 /*    1.輸入id——或選中
                                        1.直接展示table*/

                List<BookingInfo_MM> bookingObject = bookingRecordService.getBookingAllInfoByMemberID(1);
                System.out.println("=================select booking to modif available=================");
                System.out.println("Booking No.:" + "Member Name: " + "Session id: " + "Session Date: " + "Campus: " + "From: " + "To: " + "Guest:: ");
                for (BookingInfo_MM s : bookingObject) {
                    System.out.print("  " + s.getBookId());
                    System.out.print("         " + s.getUserName());

                    System.out.print("  " + s.getSessionId());
                    System.out.print("  " + s.getSessionDate());

                    System.out.print("  " + s.getSessionCampus());
                    System.out.print("  " + s.getSessionStartTime());
                    System.out.print("  " + s.getSessionEndTime());
                    System.out.println("  " + s.getGuestName());
                }


/* handle session and image
                            BookingInfo_MM targetObject=null;
                              int sessionSelected=0;
                            System.out.println("select your a session");
                            sessionSelected=Utility.readInt();
                            for (BookingInfo_MM s : bookingObject) {

                                if(s.getBookId()==1){
                                    targetObject=s;
                                    sessionSelected=s.getSessionId();
                                System.out.println("Booking No.:" + s.getBookId() + "_______________________________");
                                System.out.println("Member Name: " + s.getUserName());
                                System.out.println("Booking ID: " + s.getBookId());
                                System.out.println("Session Date: " + s.getSessionDate());

                                System.out.println("Campus: " + s.getSessionCampus());
                                System.out.println("From: " + s.getSessionStartTime());
                                System.out.println("To: " + s.getSessionEndTime());
                                System.out.println("Guest:: " + s.getGuestName());
                                }
                            }

                            targetObject.setBookReceiptName("eee");
*/

                System.out.println("handle a guest list");
                int sessionSelected = 0;
                System.out.println("select your a session");
                sessionSelected = Utility.readInt();
                //是用一個獲得的javean好，還是新的？。  一用全局，一對多用service獲得
                List<Guestlistwithsessionandguestname_Multi> guestlist = guestlistService.getGeustlistBySessionID(sessionSelected);

                System.out.println("Session:" + sessionSelected + " guest");
                System.out.println("Guest ID  " + "   guest name");
                for (Guestlistwithsessionandguestname_Multi s : guestlist) {

                    System.out.print(s.getGuestId() + "   ");
                    System.out.println(s.getGuestName() + "  ");

                }
                System.out.println("Guest not list on sesion");

                List<Guest> guetCollectionOfMember = guestService.getGuestNotListedOnASessionByMemberID(1, sessionSelected);
                System.out.println("Guest of user_____________________");
                for (Guest s : guetCollectionOfMember) {

                    System.out.print(s.getGuestId() + "   ");
                    System.out.println(s.getGuestName() + "  ");

                }

                int guestListID = guestlist.get(0).getGuestlistNGuestFKguestlistId();


                int guestID = 0;
                System.out.println("select your a guest to add");
                guestID = Utility.readInt();

                guestlistService.addGustIntoList(guestListID, guestID);


                List<Guestlistwithsessionandguestname_Multi> guestlistBySession = guestlistService.getGeustlistBySessionID(sessionSelected);

                System.out.println(guestlistBySession.size() + "guest is selected");


                for (Guestlistwithsessionandguestname_Multi l : guestlistBySession) {

                    System.out.print("name: " + l.getGuestName());
                    System.out.print("  " + l.getSessionStartTime());
                    System.out.println(" ~ " + l.getSessionEndTime());

                }

//


                guestID = 0;
                System.out.println("select your a guest to delete");
                guestID = Utility.readInt();

                guestlistService.deleteGustIntoList(guestListID, guestID);


                guestlistBySession = guestlistService.getGeustlistBySessionID(sessionSelected);

                System.out.println(guestlistBySession.size() + "guest is selected");
                System.out.println("After delete ");

                for (Guestlistwithsessionandguestname_Multi l : guestlistBySession) {

                    System.out.print("name: " + l.getGuestName());
                    System.out.print("  " + l.getSessionStartTime());
                    System.out.println(" ~ " + l.getSessionEndTime());

                }


                        /*
                                    2.彈出值

                                    3.進行修改
                                    4.查驗是否更改，進行更新


                                    1.獲得這個javabeans-arraylist的guest

                                    2.刪除，添加

                            *
                            * */


                //  boolean isSuccess=bookingRecordService.updateBookingAllInfoByMemberID(1,"testImagePath");
                System.out.println("=================Session available=================");


                //DMLBach
                //"UPDATE `session` SET  `sessionFKbookingRecord`=? ,`sessionStatus`=? where  `sessionID`=?"
                //1.create book
                //2.create session


                break;
            //endregion


            //region 5: Update session
            case 5:

                System.out.println("=================Session update=================");
                System.out.println("=================Display Session available=================");

                List<BookingInfo_MM> bookingObjectForEditSession = bookingRecordService.getBookingAllInfoByMemberID(1);
                System.out.println("=================select booking to modif available=================");
                System.out.println("Booking No.:" + "Member Name: " + "Session id: " + "Session Date: " + "Campus: " + "From: " + "To: " + "Guest:: ");
                for (BookingInfo_MM s : bookingObjectForEditSession) {
                    System.out.print("  " + s.getBookId());
                    System.out.print("         " + s.getUserName());

                    System.out.print("  " + s.getSessionId());
                    System.out.print("  " + s.getSessionDate());

                    System.out.print("  " + s.getSessionCampus());
                    System.out.print("  " + s.getSessionStartTime());
                    System.out.print("  " + s.getSessionEndTime());
                    System.out.println("  " + s.getGuestName());
                }

                System.out.println("Select a session to modify");
                sessionSelected = 0;
                sessionSelected = Utility.readInt();

                System.out.println("Display avaialbe venue and date");


                List<Session> sessionListByIdandDate = sessionService.displaySessionByDateAndCampus(1, "2023-04-12");
                System.out.println("=================Session available=================");
                for (Session s : sessionListByIdandDate) {
                    System.out.println("Session ID" + s.getSessionId());
                    System.out.print("Campus: " + s.getSessionCampus());
                    System.out.println("          Date: " + s.getSessionDate());
                    System.out.print("Start: " + s.getSessionStartTime());
                    System.out.println(" ---  End: " + s.getSessionEndTime());
                }
                System.out.println("Select a session as lastest one");
                int sessionSelectedAsnewOne = 0;
                sessionSelectedAsnewOne = Utility.readInt();

                boolean updateSuccesss = sessionService.updateSessionSetBefore(sessionSelected, sessionSelectedAsnewOne);

                if (updateSuccesss) {


                    bookingObjectForEditSession = bookingRecordService.getBookingAllInfoByMemberID(1);
                    System.out.println("=================display session after modification=================");
                    System.out.println("Booking No.:" + "Member Name: " + "Session id: " + "Session Date: " + "Campus: " + "From: " + "To: " + "Guest:: ");
                    for (BookingInfo_MM s : bookingObjectForEditSession) {
                        System.out.print("  " + s.getBookId());
                        System.out.print("         " + s.getUserName());

                        System.out.print("         " + s.getSessionId());
                        System.out.print("  " + s.getSessionDate());

                        System.out.print("  " + s.getSessionCampus());
                        System.out.print("  " + s.getSessionStartTime());
                        System.out.print("  " + s.getSessionEndTime());
                        System.out.println("  " + s.getGuestName());
                    }


                }


                break;
            //endregion w w w


        }
    }
}
@NoArgsConstructor
class SessionObj {
    private String sessionID;
    private int[] guestList;

    public SessionObj(String sessionID, int[] guestList) {
        this.sessionID = sessionID;
        this.guestList = guestList;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public int[] getGuestList() {
        return guestList;
    }

    public void setGuestList(int[] guestList) {
        this.guestList = guestList;
    }
}
