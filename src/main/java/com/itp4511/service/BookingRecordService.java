package com.itp4511.service;
import com.itp4511.dao.BookingRecordDAO;
import com.itp4511.dao.Multi_BookingSessionDAO;
import com.itp4511.domain.BookingRecord;
import com.itp4511.domain.BookingSession_Multi;
import com.itp4511.service.*;


import java.util.List;

public class BookingRecordService {

    private BookingRecordDAO bookingRecordDAO = new BookingRecordDAO();
    private Multi_BookingSessionDAO multi_BookingSessionDAO = new Multi_BookingSessionDAO();
    private SessionService sessionService = new SessionService();

    public boolean insertBookingRecords(int bookingMemberID,Object[][] bachList ) {

        int input = 0;
        int bookingID;
        input= bookingRecordDAO.update("INSERT INTO `bookingRecord`(`bookID`, `bookDate`, `bookStatus`, `bookFKmemberID`)"
                + "VALUES (?,now(),?,?)",   null, 0, bookingMemberID);

        Object o=       bookingRecordDAO.queryScalar("SELECT `bookID`FROM `bookingrecord`  " +
                "ORDER BY bookID DESC " +
                "LIMIT 1;",BookingRecord.class, null);

        bookingID=(int)o;
        for(int i=0;i<bachList.length;i++){

            bachList[i][0]=bookingID;
        }



        if(sessionService.updateSession(bachList))
            System.out.println("ok");

        return input > 0;
    }

    public List<BookingSession_Multi> getBookingByID(int memberID){
        List<BookingSession_Multi> rs= multi_BookingSessionDAO.queryMulti("SELECT b.*, u.userName FROM `bookingrecord` as b \n" +
                "LEFT JOIN user as u\n" +
                "on b.bookFKmemberID=u.userID WHERE bookFKmemberID=? ", BookingSession_Multi.class,memberID);
        return rs;
    }




}
