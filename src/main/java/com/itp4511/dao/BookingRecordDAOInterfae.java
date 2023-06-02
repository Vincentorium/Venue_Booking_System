package com.itp4511.dao;

import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.domain.BookingSession_Multi;

import java.util.List;

 public interface BookingRecordDAOInterfae {



     boolean addBookingRecords(int bookingMemberID, double bookingFee);

     Object getLatestBookingRecordID();

     List<BookingSession_Multi> getBookingByID(int memberID);


     List<BookingSession_Multi> getBookingByIDForNonUnapprovedRecord(int memberID);


     List<BookingInfo_MM> getBookingAllInfoByMemberID(int memberID);

     List<BookingInfo_MM> getBookingByMemberID(int memberID);


     List<BookingInfo_MM> getBookingAllInfoByBookingID(int BookingID);

     boolean updateBookingImgnfoByMemberID(int memberID, String imageName);

     boolean approveBooking(int memberID);


     boolean updateBookingAllInfoByMemberID(int memberID, String imageName);


}
