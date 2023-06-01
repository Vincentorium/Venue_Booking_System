package com.itp4511.service;

import com.itp4511.domain.Guest;

import java.util.List;

public interface GuestService {

    // add new guest for a member
    boolean addGuest(Guest guest);
    //
    boolean isExistsGuestName(String guestName);

    List<Guest> getRelevantGuestByMemberID(int guestFKmemberID);
    List<Guest> getGuestNotListedOnASessionByMemberID(int memberID, int sessionID);
    boolean deleteGuest(int guestID);

}
