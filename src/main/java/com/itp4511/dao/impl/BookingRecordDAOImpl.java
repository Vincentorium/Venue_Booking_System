package com.itp4511.dao.impl;

import com.itp4511.dao.*;
import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.domain.BookingRecord;
import com.itp4511.domain.BookingSession_Multi;
import com.itp4511.domain.Guest;
import com.itp4511.service.BookingRecordServiceInterfae;
import com.itp4511.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookingRecordDAOImpl  extends BasicDAO<BookingRecord> implements BookingRecordDAOInterfae {


    private Multi_BookingSessionDAO multi_BookingSessionDAO = new Multi_BookingSessionDAO();
    private BookingInfo_MMDAO bokingInfo_MMDAO = new BookingInfo_MMDAO();



     public static final Logger LOG = LoggerFactory.getLogger(BookingRecordDAOImpl.class);


    @Override
    public boolean addBookingRecords(int bookingMemberID, double bookingFee) {

        return update("INSERT INTO `bookingRecord`(  `bookFKmemberID`, `bookFee`  )"
                + "VALUES ( ?,?)",      bookingMemberID,bookingFee)>0;
    }


    @Override
    public Object getLatestBookingRecordID() {
        return  queryScalar("SELECT `bookID` FROM `bookingrecord`  " +
                "ORDER BY bookID DESC " +
                "LIMIT 1;",BookingRecord.class);
    }

    public List<BookingSession_Multi> getBookingByID(int memberID){
        List<BookingSession_Multi> rs= multi_BookingSessionDAO.queryMulti("SELECT b.*, u.userName FROM `bookingrecord` as b  " +
                "LEFT JOIN user as u " +
                "on b.bookFKmemberID=u.userID WHERE bookFKmemberID=? and bookStatus in (0,1) "
                + " order by bookStatus ,bookDate Desc", BookingSession_Multi.class,memberID);
        return rs;
    }



    public List<BookingSession_Multi> getBookingByIDForNonUnapprovedRecord(int memberID){
        List<BookingSession_Multi> rs= multi_BookingSessionDAO.queryMulti("SELECT b.*, u.userName FROM `bookingrecord` as b  " +
                "LEFT JOIN user as u " +
                "on b.bookFKmemberID=u.userID WHERE bookFKmemberID=? and bookStatus not in (0) "
                +" order by bookStatus", BookingSession_Multi.class,memberID);
        return rs;
    }



    public List<BookingInfo_MM> getBookingAllInfoByMemberID(int memberID){

        String sql="SELECT *  " +
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

        List<BookingInfo_MM> bookingInfo_MM =    bokingInfo_MMDAO.queryMulti(sql, BookingInfo_MM.class,memberID);
        return bookingInfo_MM;
    }

        public List<BookingInfo_MM> getBookingByMemberID(int memberID){

        String sql="SELECT *  " +
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

        List<BookingInfo_MM> bookingInfo_MM =    bokingInfo_MMDAO.queryMulti(sql, BookingInfo_MM.class,memberID);
        return bookingInfo_MM;
    }


    public List<BookingInfo_MM> getBookingAllInfoByBookingID(int BookingID){

        String sql="SELECT *  " +
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

        List<BookingInfo_MM> bookingInfo_MM =    bokingInfo_MMDAO.queryMulti(sql, BookingInfo_MM.class,BookingID);
        return bookingInfo_MM;
    }

    public boolean updateBookingImgnfoByMemberID(int memberID,String imageName){
        int isSuccess=0;
        try {
            String sql="\n" +
                    "UPDATE `bookingrecord` SET `bookReceipt`=? , bookStatus=? WHERE `bookID`=?";

            isSuccess=    update(sql, imageName,1,memberID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess>0;
    }

    public boolean approveBooking(int memberID){
        int isSuccess=0;
        try {
            String sql="\n" +
                    "UPDATE `bookingrecord` SET bookStatus=2 WHERE `bookID`=?";

            isSuccess=    update(sql, memberID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess>0;
    }




    public boolean updateBookingAllInfoByMemberID(int memberID,String imageName){
        int isSuccess;
        String sql="\n" +
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



        isSuccess=    update(sql, imageName,memberID);

        return isSuccess>1;
    }


}
