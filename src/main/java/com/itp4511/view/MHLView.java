package com.itp4511.view;

import com.itp4511.domain.*;
import com.itp4511.service.*;
import com.itp4511.utils.C3p0Utils;
import com.itp4511.utils.Utility;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MHLView {

    private boolean loop = true;
    private UserService userService = new UserService();
    private VenueService venueService = new VenueService();
    private SessionService sessionService = new SessionService();
    private BookingRecordService bookingRecordService = new BookingRecordService();
    private GuestService guestService = new GuestService();
    private GuestlistService guestlistService = new GuestlistService();

    //  private BookingRecordService bookingRecordService= new BookingRecordService();


    @Test
    public void mainMenuw() {

        while (loop) {

            System.out.println("=================MHL=================");
            System.out.println("\t\t 1 login ");
            System.out.println("\t\t 2  dipslay avaiable venue");
            System.out.println("\t\t 3  display session by a date");
            System.out.println("\t\t 4  Booking Service");
            System.out.println("\t\t 5  Guest Serivce");
            System.out.println("\t\t 9  exit ");
            System.out.println("Please enter your choice");
            String key = Utility.readString(1);
            switch (key) {


                //region Case 1: Login
                case "1":
                    System.out.println("login");
                    System.out.println("id");
                    String acc = Utility.readString(20);
                    System.out.println("ps");
                    String pwd = Utility.readString(20);
                    Userinfo user = userService.getUserByAccAndPwd(acc, pwd);
                    if (user != null) {
                        System.out.println("ok, " + user.getUserName());
                    }
                    //endregion
                    //region Case2 dipslay avaiable venue"
                case "2":
                    System.out.println("=================Display Order=================");
                    List<Venue> venueList = venueService.getAllVenue();


                    for (Venue v : venueList) {
                        System.out.println(v.getVenName() + " is my favourite");
                    }
                    break;
                //endregion

                //region Case 3: Display session by date
                case "3":
                    System.out.println("=================Display=================");

                    System.out.println("\t\t 1 by id and campus");
                    System.out.println("\t\t 2  display session by a date");
                    System.out.println("Please enter your choice");
                    String keyForSession = Utility.readString(1);
                    switch (keyForSession) {

                        case "1":

                            List<Session> sessionList = sessionService.displaySessionByDate(1, "2023-04-12");
                            System.out.println("=================Session available=================");
                            for (Session s : sessionList) {


                                System.out.print("Name: " + s.getSessionStartTime());
                                System.out.println("Email: " + s.getSessionEndTime());
                            }

                            break;
                        case "2":


                            List<Session> sessionListByIdandDate = sessionService.displaySessionByDateAndCampus(1, "2023-04-12");
                            System.out.println("=================Session available=================");
                            for (Session s : sessionListByIdandDate) {

                                System.out.print("Campus: " + s.getSessionCampus());
                                System.out.println("          Date: " + s.getSessionDate());
                                System.out.print("Start: " + s.getSessionStartTime());
                                System.out.println(" ---  End: " + s.getSessionEndTime());
                            }
                            break;
                        case "3":


                            List<Session> sessionListByIdandDate2 = sessionService.displaySessionByDateAndCampus(1, "2023-04-12");
                            System.out.println("=================Session available=================");
                            for (Session s : sessionListByIdandDate2) {

                                System.out.print("Campus: " + s.getSessionCampus());
                                System.out.println("          Date: " + s.getSessionDate());
                                System.out.print("Start: " + s.getSessionStartTime());
                                System.out.println(" ---  End: " + s.getSessionEndTime());
                            }
                            break;

                    }
                    break;
                //endregion

                //region Case 4： Booking service

                case "4":
                    System.out.println("=================Book=================");

                    System.out.println("\t\t 1  display Booking by id");
                    System.out.println("\t\t 2  book a Venue with session(s)");
                    System.out.println("\t\t 3  Update all attributes including receipt");
                    System.out.println("\t\t 4  add or delete guest from guestlist");
                    System.out.println("\t\t 5  select a session to update ");
                    System.out.println("Please enter your choice");
                    String keyForBooking = Utility.readString(1);
                    switch (keyForBooking) {

                        //region 1: display booking by id
                        case "1":


                            List<BookingInfo_MM> bookingAllInfoByMemberID = bookingRecordService.getBookingAllInfoByMemberID(1);
                            System.out.println("=================Session available=================");
                            System.out.println("Booking No.:" + "Member Name: " + "Booking ID: " + "Session id: " + "Session Date: " + "Campus: " + "From: " + "To: " + "Guest:: ");
                            for (BookingInfo_MM s : bookingAllInfoByMemberID) {
                                System.out.print("  " + s.getBookId());
                                System.out.print("  " + s.getUserName());
                                System.out.print("  " + s.getBookId());
                                System.out.print("  " + s.getSessionId());
                                System.out.print("  " + s.getSessionDate());

                                System.out.print("  " + s.getSessionCampus());
                                System.out.print("  " + s.getSessionStartTime());
                                System.out.print("  " + s.getSessionEndTime());
                                System.out.println("  " + s.getGuestName());
                            }

                            break;
                        //endregion

                        //region 2: book a venue with session
                        case "2":

                            //剩下問題是：如何將jason導入object[][]，且將第一個設為0——作為之後新增id用，這些都可以直接寫到service內
                            /*
                             1.批處理的，的預sql方式
                             2.apach util實現批處理
                             3.設置array來處理批處理
                             4.未做
                                guestList+FK
                            */
                            /*
                             *1.createbooking, inser into JS
                             *2.sessionGuestList, create and insert into JS
                             *3.sessionStatus : specified by user
                             *4.sessionID: specified by user
                             *5.guestID
                             * bookingID,--,sessionStatus,sessionID
                             * */
                            int guestArray1[] = {1, 2};
                            int guestArray2[] = {2, 3};
                            int guestArray3[] = {3, 1};
                            Object[][] bachList = new Object[][]{
                                    {0, 0, 3, 52, guestArray1},
                                    {0, 0, 3, 53, guestArray2},
                                    {0, 0, 3, 54, guestArray3},};

                            Object[][] bachList1 = new Object[][]{
                                    {0, 2, 9}
                            };
                            boolean isUpdate =false;// bookingRecordService.insertBookingRecords(1, bachList);
                            if (isUpdate) {
                                System.out.println("ok");
                            }

                            break;
                        //endregion

                        //region 3: Update all attributes including receipt
                        case "3":
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
                        case "4":
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
                        case "5":

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
                    break;
                //endregion

                //region Case 5: Guest List Management
                case "5":
                    System.out.println("=================Display=================");

                    System.out.println("\t\t 1 by guest List By Member ID");
                    System.out.println("\t\t 2 add a new guest ");
                    System.out.println("\t\t 3 delete a guest list");
                    System.out.println("Please enter your choice");
                    String keyForList = Utility.readString(1);
                    switch (keyForList) {

                        case "1":

                            List<Guest> guestList = guestService.getRelevantGuestByMemberID(1);
                            System.out.println("=================Session available=================");
                            for (Guest s : guestList) {

                                System.out.println("ID: " + s.getGuestId());
                                System.out.print("Name: " + s.getGuestName());
                            }

                            break;
                        case "2":
//                            "\t\t 2 add a new guest "
                            List<Guest> guestList2 = guestService.getRelevantGuestByMemberID(1);
                            System.out.println("=================your guests=================");
                            for (Guest s : guestList2) {

                                System.out.println("ID: " + s.getGuestId());
                                System.out.print("Name: " + s.getGuestName());
                            }

                            System.out.println("=================add a new guest=================");

                            boolean isInsertGuest = guestService.addGuest(1, "Emil", "emil@gmail.com");

                            List<Guest> guest = guestService.getRelevantGuestByMemberID(1);

                            System.out.println("\n=================your guests=================");
                            for (Guest s : guest) {

                                System.out.println("ID: " + s.getGuestId());
                                System.out.print("Name: " + s.getGuestName());
                            }

                            System.out.println("=================add a new guest=================");


                            break;


                        case "3":

                            List<Guest> guests3 = guestService.getRelevantGuestByMemberID(1);
                            System.out.println("=================your guests=================");
                            for (Guest s : guests3) {

                                System.out.println("ID: " + s.getGuestId());
                                System.out.print("Name: " + s.getGuestName());
                            }

                            System.out.println("=================delete a guest=================");
                            int guestIDForDel = 0;
                            System.out.println("select your a guest to delete");
                            guestIDForDel = Utility.readInt();


                            boolean isInsertGuest3 = guestService.deleteGuest(guestIDForDel);

                            guests3 = guestService.getRelevantGuestByMemberID(guestIDForDel);

                            System.out.println("\n=================your guests=================");
                            for (Guest s : guests3) {

                                System.out.print("ID: " + s.getGuestId());
                                System.out.print("Name: " + s.getGuestName());
                            }

                            System.out.println("=================add a new guest=================");


                            break;
                    }
                    break;
                //endregion
            }
        }
    }

    @Test
    public void TestBach() {


    }


}
