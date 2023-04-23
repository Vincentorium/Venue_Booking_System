package com.itp4511.service;
import com.itp4511.dao.BookingRecordDAO;
import com.itp4511.dao.Multi_BookingSessionDAO;
import com.itp4511.dao.BookingInfo_MMDAO;
import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.domain.BookingRecord;
import com.itp4511.domain.BookingSession_Multi;


import java.util.List;

public class BookingRecordService {

    private BookingRecordDAO bookingRecordDAO = new BookingRecordDAO();
    private Multi_BookingSessionDAO multi_BookingSessionDAO = new Multi_BookingSessionDAO();
    private BookingInfo_MMDAO bokingInfo_MMDAO = new BookingInfo_MMDAO();

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
        List<BookingSession_Multi> rs= multi_BookingSessionDAO.queryMulti("SELECT b.*, u.userName FROM `bookingrecord` as b  " +
                "LEFT JOIN user as u " +
                "on b.bookFKmemberID=u.userID WHERE bookFKmemberID=? ", BookingSession_Multi.class,memberID);
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

        isSuccess=    bookingRecordDAO.update(sql, imageName,memberID);
        return isSuccess>1;
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

        //已經處理好uopload picture
        //如何update guestlist是一個問題。涉及到刪除就有的，弄新
        /*
        之前用arraylist放數據，是不是應該用javabean來放嗯好？
        1.對於需要edit的對象，用query獲取對象
        2.再雜講值輸出當默認值，若不更改空值，便保留默認

        ————————
        1.輸入id——或選中
        2.彈出值
        3.進行修改
        4.查驗是否更改，進行更新

        1.輸入id——或選中
            1.直接展示table
        2.彈出值

        3.進行修改
        4.查驗是否更改，進行更新


        1.獲得這個javabeans-arraylist的guest

        2.刪除，添加
*/


        isSuccess=    bookingRecordDAO.update(sql, imageName,memberID);

        return isSuccess>1;
    }


}
