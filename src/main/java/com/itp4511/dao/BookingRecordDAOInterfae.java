package com.itp4511.dao;

import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.domain.BookingSession_Multi;

import java.util.List;

public interface BookingRecordDAOInterfae {


    public boolean insertBookingRecords(int bookingMemberID, double bookingFee, Object[][] bachList);


    public List<BookingSession_Multi> getBookingByID(int memberID);


    public List<BookingSession_Multi> getBookingByIDForNonUnapprovedRecord(int memberID);


    public List<BookingInfo_MM> getBookingAllInfoByMemberID(int memberID);

    public List<BookingInfo_MM> getBookingByMemberID(int memberID);


    public List<BookingInfo_MM> getBookingAllInfoByBookingID(int BookingID);

    public boolean updateBookingImgnfoByMemberID(int memberID, String imageName);

    public boolean approveBooking(int memberID);


    public boolean updateBookingAllInfoByMemberID(int memberID, String imageName);


}
