package com.itp4511.service;

import com.itp4511.dao.BookingInfo_MMDAO;
import com.itp4511.dao.BookingRecordDAO;
import com.itp4511.dao.Multi_BookingSessionDAO;
import com.itp4511.domain.BookingInfo_MM;
import com.itp4511.domain.BookingRecord;
import com.itp4511.domain.BookingSession_Multi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface BookingRecordServiceInterfae {


    boolean insertBookingRecords(StringBuilder bookingSessionsJSArrayStr );







    List<BookingSession_Multi> getBookingByID(int memberID);


    List<BookingSession_Multi> getBookingByIDForNonUnapprovedRecord(int memberID);


    List<BookingInfo_MM> getBookingAllInfoByMemberID(int memberID);

    List<BookingInfo_MM> getBookingByMemberID(int memberID);


    List<BookingInfo_MM> getBookingAllInfoByBookingID(int BookingID);

    boolean updateBookingImgnfoByMemberID(int memberID, String imageName);

    boolean approveBooking(int memberID);


    boolean updateBookingAllInfoByMemberID(int memberID, String imageName);


}
