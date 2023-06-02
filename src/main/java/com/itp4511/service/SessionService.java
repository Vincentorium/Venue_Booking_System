package com.itp4511.service;


import com.itp4511.dao.BookingInfo_MMDAO;
import com.itp4511.dao.Multi_BookingSessionDAO;
import com.itp4511.dao.SessionDAO;
import com.itp4511.dao.SessionbyguestidDAO;
import com.itp4511.domain.BookingSession_Multi;
import com.itp4511.domain.Session;
import com.itp4511.domain.Sessionbyguestid;
import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.service.impl.BookingRecordServiceImpl;
import org.jfree.util.Log;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.List;


public class SessionService {

    private SessionDAO sessionDAO = new SessionDAO();
    private Multi_BookingSessionDAO multi_BookingSessionDAO = new Multi_BookingSessionDAO();
    private SessionbyguestidDAO sessionbyguestidDAO = new SessionbyguestidDAO();
    BookingInfo_MMDAO bookingInfo_MMDAO = new BookingInfo_MMDAO();

    private static final Logger LOG = LoggerFactory.getLogger(BookingRecordServiceImpl.class);

    public boolean insertOneSession(java.sql.Time timeslotStart, java.sql.Time timeslotEnd) {

//
        // Date date = new Date(System.currentTimeMillis());
        int update = sessionDAO.update("INSERT INTO `session` (`sessionID`, `sessionDate`,`sessionStartTime`, `sessionEndTime`) VALUES (now(), ?, ?, ?)", null, timeslotStart, timeslotEnd);
        System.out.println(update);
        return update > 0;
    }

    public List<Session> displaySessionByDate(int campusID, String date) {

        return sessionDAO.queryMulti("SELECT * FROM `session` where sessionDate =(?) and sessionCampus=?", Session.class, Date.valueOf(date), campusID);

    }

    public List<BookingInfo_MM> displaySessionByID(int userID) {

        return bookingInfo_MMDAO.queryMulti("SELECT * FROM `session` as s " +
                "left join bookingrecord as b on s.sessionFKbookingRecord=b.bookID " +
                "left join venue as v on v.venID=sessionCampus " +
                "  left join user as u on u.userID=b.bookFKmemberID" +
                "  where u.userID=?  ", BookingInfo_MM.class, userID);

    }

    public List<BookingInfo_MM> displaySessionBookingID(int bookID) {
        List<BookingInfo_MM> result = null;
        try {
            result = bookingInfo_MMDAO.queryMulti("SELECT * FROM `session` as s " +
                    "left join bookingrecord as b on s.sessionFKbookingRecord=b.bookID " +
                    "left join venue as v on v.venID=sessionCampus " +
                    "  left join user as u on u.userID=b.bookFKmemberID" +
                    "  where s.sessionFKbookingRecord=?  ", BookingInfo_MM.class, bookID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }


    public List<BookingInfo_MM> displayBookingInfoNeedApproval(int memberUnapproved) {
        List<BookingInfo_MM> result = null;
        try {

            result = bookingInfo_MMDAO.queryMulti("SELECT * FROM `bookingrecord`   as b " +
                            " left join user on b.bookFKmemberID=user.userID " +
                            "  where bookStatus = 1 and bookFKmemberID = ?"
                            + " order by bookStatus ,bookDate Desc"
                    , BookingInfo_MM.class, memberUnapproved);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
//where b.bookStatus=1
    }


    public List<BookingInfo_MM> displayALLBookingInfoNeedApproval() {
        List<BookingInfo_MM> result = null;
        try {

            result = bookingInfo_MMDAO.queryMulti("SELECT * FROM `bookingrecord`  as b  "
                            + " left join user on b.bookFKmemberID=user.userID"
                            + " where bookStatus = 1 and bookFKmemberID LIKE '%' "
                            + " order by bookStatus ,bookDate Desc"
                    , BookingInfo_MM.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
//where b.bookStatus=1
    }


    public List<BookingInfo_MM> displayBookingInfoApproved(int memberID) {
        List<BookingInfo_MM> result = null;
        try {
            result = bookingInfo_MMDAO.queryMulti("SELECT * FROM `bookingrecord`    as b " +
                            " left join user on b.bookFKmemberID=user.userID " +
                            " where bookStatus !=1" +
                            " and bookFKmemberID = ? order by bookStatus ,bookDate Desc"

                    , BookingInfo_MM.class, memberID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
        return result;
//where b.bookStatus=1
    }

    public List<BookingInfo_MM> displayAllBookingInfoApproved() {
        List<BookingInfo_MM> result = null;
        try {
            result = bookingInfo_MMDAO.queryMulti("SELECT * FROM `bookingrecord` as b " +
                            " left join user on b.bookFKmemberID=user.userID " +
                            " where bookStatus !=1 and bookFKmemberID like '%' " +
                            "order by bookStatus ,bookDate Desc;"

                    , BookingInfo_MM.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
        return result;
//where b.bookStatus=1
    }

    public List<Session> displaySessionByDateAndCampus(int campus, String date) {

        return sessionDAO.queryMulti("SELECT * FROM `session` where sessionCampus=? and sessionDate =?", Session.class, campus, Date.valueOf(date));

    }

    public List<Sessionbyguestid> sessionbyGuestID(int guestID) {

        return sessionbyguestidDAO.queryMulti(
                " " +
                        "SELECT * FROM `guestlistenguest_mm` as gmm  " +
                        "left join session as s  on s.sessionFKGuestlist=gmm.guestlistNGuestFKguestlistID " +
                        "left join venue as v on s.sessionCampus=v.venID " +
                        "WHERE gmm.guestlistNGuestFKguestID=?", Sessionbyguestid.class, guestID);

    }


    //for the first time update session
    public boolean updateSession(Object[][] batchArrWithGuestList) {

        boolean isUpdate = false;

        isUpdate = sessionDAO.updateBach(
                "UPDATE `session` SET  `sessionFKbookingRecord`=? ,`sessionFKGuestlist`=?,`sessionStatus`= 1 " +
                        "where  `sessionID`=?", batchArrWithGuestList).length > 0;

        LOG.debug("Status of update session with Booking records.. : " + isUpdate);


        return isUpdate;
    }


    public boolean updateSessionSetBefore(int oldOneID, int newOneID
    ) {

        int input = 0;
        //
        //1.g get date from the empyt one
        //2. update the older one to empyt
        //3. update the one selected


        //1.g get date from the old one

        String sqlGetoldSession = "SELECT * FROM `session` WHERE sessionID=?";
        Session oldOne = sessionDAO.querySingle(sqlGetoldSession, Session.class, oldOneID);

        //2 update the new one with the old information

        input = sessionDAO.update(
                "UPDATE `session` SET  `sessionFKbookingRecord`=? ,`sessionFKGuestlist`=?,`sessionStatus`=? " +
                        "where  `sessionID`=?", oldOne.getSessionFKbookingRecord(), oldOne.getSessionFkGuestlist(), oldOne.getSessionStatus(), newOneID);
        //3. update the older one to default value
        input = sessionDAO.update(
                "UPDATE `session` SET  `sessionFKbookingRecord`=? ,`sessionFKGuestlist`=?,`sessionStatus`=? " +
                        "where  `sessionID`=?", null, null, 0, oldOneID);


        return input > 0;
    }


}
