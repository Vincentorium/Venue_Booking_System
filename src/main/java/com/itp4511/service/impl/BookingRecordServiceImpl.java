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

    public static final Logger LOG = LoggerFactory.getLogger(BookingRecordServiceImpl.class);


    //<editor-fold desc=" service refined">
    public boolean insertBookingRecords(StringBuilder bookingSessionsJSArrayStr) {


        Object[][] bachList = null;
        Integer bookingMemberID = null;
        Double bookingFee = null;


        Gson gson = new Gson();

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


        return bookingRecordDAOImpl.insertBookingRecords(bookingMemberID, bookingFee, bachList);


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
