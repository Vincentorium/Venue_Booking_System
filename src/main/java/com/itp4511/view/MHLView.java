package com.itp4511.view;

import com.itp4511.domain.*;
import com.itp4511.service.*;
import com.itp4511.utils.Utility;
import org.junit.Test;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;


public class MHLView {

    private boolean loop = true;
    private UserService userService = new UserService();
    private VenueService venueService = new VenueService();
    private SessionService sessionService = new SessionService();
    private BookingRecordService bookingRecordService = new BookingRecordService();
    //  private BookingRecordService bookingRecordService= new BookingRecordService();


    @Test
    public void mainMenuw() {

        while (loop) {

            System.out.println("=================MHL=================");
            System.out.println("\t\t 1 login ");
            System.out.println("\t\t 2  MHL");
            System.out.println("\t\t 3  display session by a date");
            System.out.println("\t\t 4  Booking Service");
            System.out.println("\t\t 9  exit ");
            System.out.println("Please enter your choice");
            String key = Utility.readString(1);
            switch (key) {


                case "1":
                    System.out.println("login");
                    System.out.println("id");
                    String acc = Utility.readString(20);
                    System.out.println("ps");
                    String pwd = Utility.readString(20);
                    User user = userService.getUserByIDAndPwd(acc, pwd);
                    if (user != null) {
                        System.out.println("ok, " + user.getUserName());
                    }
                    break;
                case "2":
                    System.out.println("=================Display Order=================");
                    List<Venue> venueList = venueService.getAllVenue();


                    for (Venue v : venueList) {
                        System.out.println(v.getVenName() + " is my favourite");
                    }
                    break;
                case "3":
                    System.out.println("=================Display=================");

                    System.out.println("\t\t 1 by id and campus");
                    System.out.println("\t\t 2  display session by a date");
                    System.out.println("Please enter your choice");
                    String keyForSession = Utility.readString(1);
                    switch (keyForSession) {

                        case "1":

                            List<Session> sessionList = sessionService.displaySessionByDate("2023-04-12");
                            System.out.println("=================Session available=================");
                            for (Session s : sessionList) {


                                System.out.print("Start: " + s.getSessionStartTime());
                                System.out.println(" ---  End: " + s.getSessionEndTime());
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

                    }
                    break;
                case "4":
                    System.out.println("=================Book=================");

                    System.out.println("\t\t 1  display campus by id");
                    System.out.println("\t\t 2  book a campus with a session");
                    System.out.println("Please enter your choice");
                    String keyForBooking = Utility.readString(1);
                    switch (keyForBooking) {

                        case "1":


                            List<BookingSession_Multi> bookingRecrodsByID= bookingRecordService.getBookingByID(1);
                            System.out.println("=================Session available=================");
                            for (BookingSession_Multi s : bookingRecrodsByID) {

                                System.out.println("Member ID: "+s.getBookFKmemberId());
                                System.out.println("Member Name: "+s.getUserName());
                                System.out.println("Session: "+s.getBookFkSession());
                            }

                            break;

                        case "2":

                            boolean isUpdate= bookingRecordService.insertBookingRecords(1,9);
                            if(isUpdate){
                                System.out.println("ok");
                            }

                            break;

                    }
                    break;
                case "9":
                    loop=false;
                default:
                    System.out.println(" wrong ");


            }
        }
    }
}
