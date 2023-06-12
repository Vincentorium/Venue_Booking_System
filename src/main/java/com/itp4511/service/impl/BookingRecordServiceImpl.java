package com.itp4511.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.itp4511.dao.BookingInfo_MMDAO;
import com.itp4511.dao.BookingRecordDAO;
import com.itp4511.dao.Multi_BookingSessionDAO;
import com.itp4511.dao.impl.BookingRecordDAOImpl;
import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.domain.BookingRecord;
import com.itp4511.domain.BookingSession_Multi;
import com.itp4511.domain.SessionObj;
import com.itp4511.service.BookingRecordService;
import com.itp4511.service.BookingRecordServiceInterfae;
import com.itp4511.service.GuestlistService;
import com.itp4511.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class BookingRecordServiceImpl implements BookingRecordServiceInterfae {

    private BookingRecordDAOImpl bookingRecordDAOImpl = new BookingRecordDAOImpl();

    private BookingRecordDAO bookingRecordDAO = new BookingRecordDAO();

    private Multi_BookingSessionDAO multi_BookingSessionDAO = new Multi_BookingSessionDAO();
    private BookingInfo_MMDAO bokingInfo_MMDAO = new BookingInfo_MMDAO();

    private SessionService sessionService = new SessionService();

    private GuestlistService guestlistService = new GuestlistService();
    private static final Logger LOG = LoggerFactory.getLogger(BookingRecordServiceImpl.class);
    private Gson gson = new Gson();

    //<editor-fold desc=" service refined">


    public boolean insertBookingRecords(StringBuilder bookingSessionsJSArrayStr) {


        Object[][] batchArrForGuestList_MM;// array for the batch update of  guestList
        Object[][] batchArrForSession; // array for batch update of sessions
        List<SessionObj> sessionObjs; //Object List to store the data from front side


        sessionObjs = parseIntoObjects(bookingSessionsJSArrayStr);
        // create bookingID and add the id into object in session list
        createAndaddBookingIDintoSessionObj(sessionObjs);


// create guest list for each sessions selected
        for (SessionObj sessionObj : sessionObjs) {
            /*
             * the relationship between guest and guest list is many to many
             *
             * 1.create guestlist and get id of the one
             * 2.attach id in step 1 to the session and and guest
             * 3.create the many to many table for guest and guest list form data get in step 2
             *
             * */

            //1.
            guestlistService.addGuestlistForSession();
            int guestListID = guestlistService.getLatestGuestListID();

            sessionObj.setGuestListID(guestListID);

            LOG.debug("Create Guest List: with ID: " + guestListID);
            //2.
            batchArrForGuestList_MM = parseGuestBatchForUpdateObj(sessionObj, guestListID);

            //3.
            try {
                int isUpdate[] = guestlistService.addGuestlistenguest_MMWithGuestListAndGuestID(batchArrForGuestList_MM);
                if (isUpdate.length > 0)
                    LOG.debug("Successfully insert " + isUpdate.length + " record(s)");
            } catch (Exception e) {
                LOG.debug("Fail to create  guestlistenguest_MmDAO : " + e.getMessage());
            }
        }
//update session with booking ID and GuestList_MM
        batchArrForSession = parseObjectIntoArr(sessionObjs);
        return sessionService.updateSession(batchArrForSession);

    }

    private Object[][] parseObjectIntoArr(List<SessionObj> sessionObjs) {
        int i = 0;


        int attributesOfBatchArr = 3;

        int noOfSessionSelected = sessionObjs.size();

//        batchArrAfterRemoveGuestArr = new Object[batchArr.length][attributesOfBatchArr];


        Object[][] batchArrAfterRemoveGuestArr = new Object[noOfSessionSelected][attributesOfBatchArr];
        LOG.debug("Begin parsing session object into 2D array to do batch update");

        for (SessionObj obj : sessionObjs) {

            batchArrAfterRemoveGuestArr[i][0] = obj.getBookingID();
            batchArrAfterRemoveGuestArr[i][1] = obj.getGuestListID();
            batchArrAfterRemoveGuestArr[i][2] = obj.getSessionID();
            i++;
            LOG.debug("The session with ID " + obj.getSessionID() + " will be update  with guest List ID: " + obj.getGuestListID());
        }

        return batchArrAfterRemoveGuestArr;
    }


    private Object[][] parseGuestBatchForUpdateObj(SessionObj sessionObj, int guestListID) {
        //final int indexOfGuesetIDArr = 3;

        int noOfguestInSessionSelected = sessionObj.getGuestList().length;

        Object[][] guestCollection = new Object[noOfguestInSessionSelected][3];


        int i = 0;
        try {
            for (; i < noOfguestInSessionSelected; i++) {


                guestCollection[i][0] = null; //guestListNGuest_mm id
                guestCollection[i][1] = guestListID; // GuestLisID
                guestCollection[i][2] = sessionObj.getGuestList()[i]; //GuestID

                LOG.debug("A guest with ID " + sessionObj.getGuestList()[i] + " is under Guest List ID " + guestListID);
            }
        } catch (Exception e) {

            LOG.debug("Fail to create guestCollection array to update many-many table " + e.getMessage());
        }
        return guestCollection;
    }


    private List<SessionObj> parseIntoObjects(StringBuilder bookingSessionsJSArrayStr) {


        Integer bookingMemberID = null;
        Double bookingFee = null;
        Object[][] batchArr;


        //parse bookingSessionsJSArrayStr into SessionObj JavaBean
        List<SessionObj> sessionObjs = null;
        try {
            //   JsonObject jsonObject = gson.fromJson(sb.toString() , JsonObject.class);
            sessionObjs = gson.fromJson(bookingSessionsJSArrayStr.toString(), new TypeToken<List<SessionObj>>() {
            });
        } catch (JsonSyntaxException e) {
            LOG.debug(e.getMessage());
        } catch (Exception e) {
            LOG.debug(e.getMessage());

        }


        return sessionObjs;
    }

    private List<SessionObj> createAndaddBookingIDintoSessionObj(List<SessionObj> sessionObjs) {

        int bookingMemberID = 0;
        double bookingFee = 0;
        for (SessionObj sessionObj : sessionObjs) {
            bookingMemberID = sessionObj.getUserID();
            bookingFee = sessionObj.getTotalPrice();
        }


        //update booking Record
        boolean isAdd = bookingRecordDAOImpl.addBookingRecords(bookingMemberID, bookingFee);
        LOG.debug("Status of add new booking record is " + isAdd);


        Integer bookingID = (Integer) bookingRecordDAOImpl.getLatestBookingRecordID();
        LOG.debug("The latest BookingID is " + bookingID);

        for (SessionObj sessionObj : sessionObjs) {
            sessionObj.setBookingID(bookingID);
        }

        LOG.debug("Attach booking records ID to  " + sessionObjs.size() + " session(s)");
        return sessionObjs;
    }

    //</editor-fold>


    public List<BookingSession_Multi> getBookingByID(int memberID) {
        List<BookingSession_Multi> rs = multi_BookingSessionDAO.queryMulti("SELECT b.*, u.userName FROM `bookingrecord` as b  " +
                "LEFT JOIN user as u " +
                "on b.bookFKmemberID=u.userID WHERE bookFKmemberID=? and bookStatus in (0,1) "
                + " order by bookStatus ,bookDate Desc", BookingSession_Multi.class, memberID);
        return rs;
    }


    public List<BookingSession_Multi> getBookingByIDForNonUnapprovedRecord(int memberID) {
        List<BookingSession_Multi> rs = multi_BookingSessionDAO.queryMulti("SELECT b.*, u.userName FROM `bookingrecord` as b  " +
                "LEFT JOIN user as u " +
                "on b.bookFKmemberID=u.userID WHERE bookFKmemberID=? and bookStatus not in (0) "
                + " order by bookStatus", BookingSession_Multi.class, memberID);
        return rs;
    }


    public List<BookingInfo_MM> getBookingAllInfoByMemberID(int memberID) {

        String sql = "SELECT *  " +
                "   FROM  bookingrecord as b  " +
                "   left join user as u  " +
                "   on b.bookFKmemberID=u.userID " +
                "                        left join session as s   " +
                "                        on b.bookID=s.sessionFKbookingRecord  " +
                "                        left join venue as v " +
                "                        on s.sessionCampus=v.venID " +
                "                        left join guestlist as gl  " +
                "                        on s.sessionFKGuestlist=gl.guestListID  " +
                "                        left join guestlistenguest_mm as glmm  " +
                "                        on gl.guestListID=glmm.guestlistNGuestFKguestlistID  " +
                "                        left join guest as g  " +
                "                        on glmm.guestlistNGuestFKguestID=g.guestID   " +
                "                        WHERE bookFKmemberID=? " +
                "                        ORDER BY `b`.`bookID` DESC;";

        List<BookingInfo_MM> bookingInfo_MM = bokingInfo_MMDAO.queryMulti(sql, BookingInfo_MM.class, memberID);
        return bookingInfo_MM;
    }

    public List<BookingInfo_MM> getBookingByMemberID(int memberID) {

        String sql = "SELECT *  " +
                "   FROM  bookingrecord as b  " +
                "   left join user as u  " +
                "   on b.bookFKmemberID=u.userID " +
                "                        left join session as s   " +
                "                        on b.bookID=s.sessionFKbookingRecord  " +
                "                        left join venue as v " +
                "                        on s.sessionCampus=v.venID " +
                "                        left join guestlist as gl  " +
                "                        on s.sessionFKGuestlist=gl.guestListID  " +
                "                        left join guestlistenguest_mm as glmm  " +
                "                        on gl.guestListID=glmm.guestlistNGuestFKguestlistID  " +
                "                        left join guest as g  " +
                "                        on glmm.guestlistNGuestFKguestID=g.guestID   " +
                "                        WHERE bookFKmemberID=? " +
                "                        ORDER BY `b`.`bookID` DESC;";

        List<BookingInfo_MM> bookingInfo_MM = bokingInfo_MMDAO.queryMulti(sql, BookingInfo_MM.class, memberID);
        return bookingInfo_MM;
    }


    public List<BookingInfo_MM> getBookingAllInfoByBookingID(int BookingID) {

        String sql = "SELECT *  " +
                "   FROM  bookingrecord as b  " +
                "   left join user as u  " +
                "   on b.bookFKmemberID=u.userID " +
                "                        left join session as s   " +
                "                        on b.bookID=s.sessionFKbookingRecord  " +
                "                        left join venue as v " +
                "                        on s.sessionCampus=v.venID " +
                "                        left join guestlist as gl  " +
                "                        on s.sessionFKGuestlist=gl.guestListID  " +
                "                        left join guestlistenguest_mm as glmm  " +
                "                        on gl.guestListID=glmm.guestlistNGuestFKguestlistID  " +
                "                        left join guest as g  " +
                "                        on glmm.guestlistNGuestFKguestID=g.guestID   " +
                "                        WHERE bookFKmemberID=? " +
                "                        ORDER BY `b`.`bookID` DESC;";

        List<BookingInfo_MM> bookingInfo_MM = bokingInfo_MMDAO.queryMulti(sql, BookingInfo_MM.class, BookingID);
        return bookingInfo_MM;
    }

    public boolean updateBookingImgnfoByMemberID(int memberID, String imageName) {
        int isSuccess = 0;
        try {
            String sql = "\n" +
                    "UPDATE `bookingrecord` SET `bookReceipt`=? , bookStatus=? WHERE `bookID`=?";

            isSuccess = bookingRecordDAO.update(sql, imageName, 1, memberID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess > 0;
    }

    public boolean approveBooking(int memberID) {
        int isSuccess = 0;
        try {
            String sql = "\n" +
                    "UPDATE `bookingrecord` SET bookStatus=2 WHERE `bookID`=?";

            isSuccess = bookingRecordDAO.update(sql, memberID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess > 0;
    }


    public boolean updateBookingAllInfoByMemberID(int memberID, String imageName) {
        int isSuccess;
        String sql = "\n" +
                "update  bookingrecord as b  \n" +
                "                   left join user as u  \n" +
                "                   on b.bookFKmemberID=u.userID \n" +
                "                                        left join session as s   \n" +
                "                                        on b.bookID=s.sessionFKbookingRecord  \n" +
                "                                        left join venue as v \n" +
                "                                        on s.sessionCampus=v.venID \n" +
                "                                        left join guestlist as gl  \n" +
                "                                        on s.sessionFKGuestlist=gl.guestListID  \n" +
                "                                        left join guestlistenguest_mm as glmm  \n" +
                "                                        on gl.guestListID=glmm.guestlistNGuestFKguestlistID  \n" +
                "                                        left join guest as g  \n" +
                "                                        on glmm.guestlistNGuestFKguestID=g.guestID   \n" +
                "                                      \n" +
                "                                        set b.bookReceiptName=\"tetttttst\",b.bookStatus=\"test\",\n" +
                "                                            v.venName\n" +
                "                                        \n" +
                "                                          WHERE b.bookID=1\n";


        isSuccess = bookingRecordDAO.update(sql, imageName, memberID);

        return isSuccess > 1;
    }


}
