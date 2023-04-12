package com.itp4511.service;


import com.itp4511.dao.BookingRecordDAO;
import com.itp4511.dao.Multi_BookingSessionDAO;
import com.itp4511.domain.BookingSession_Multi;

import java.util.List;

public class BookingRecordService {

    private BookingRecordDAO bookingRecordDAO = new BookingRecordDAO();
    private Multi_BookingSessionDAO multi_BookingSessionDAO = new Multi_BookingSessionDAO();

    public boolean insertBookingRecords(int bookingMemberID, int bookingSessionID) {

        int input = 0;

        input= bookingRecordDAO.update("INSERT INTO `bookingRecord`(`bookID`, `bookDate`, `bookStatus`, `bookFKmemberID`,"
                + "`bookFKSession`)"
                + "VALUES (?,now(),?,?,?)",   null, 0, bookingMemberID, bookingSessionID);

        return input > 0;
    }

    public List<BookingSession_Multi> getBookingByID(int memberID){
        List<BookingSession_Multi> rs= multi_BookingSessionDAO.queryMulti("SELECT b.*, u.userName FROM `bookingrecord` as b \n" +
                "LEFT JOIN user as u\n" +
                "on b.bookFKmemberID=u.userID WHERE bookFKmemberID=? ", BookingSession_Multi.class,memberID);
        return rs;
    }
}
