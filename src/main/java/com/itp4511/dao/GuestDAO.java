package com.itp4511.dao;

import com.itp4511.dao.BasicDAO;
import com.itp4511.domain.Guest;

import java.util.List;

public interface GuestDAO {

    int addGuest(Guest guest);

    Guest queryGuestByGuestName(String name);

    List<Guest> getRelevantGuestByMemberID(int guestFKmemberID);

    List<Guest> getGuestNotListedOnASessionByMemberID(int memberID, int sessionID);


    boolean deleteGuest(int guestID);
}
