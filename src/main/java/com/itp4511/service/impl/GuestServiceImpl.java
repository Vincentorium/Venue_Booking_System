package com.itp4511.service.impl;

import com.itp4511.dao.GuestDAO;
import com.itp4511.dao.impl.GuestDAOImpl;
import com.itp4511.domain.Guest;
import com.itp4511.service.GuestService;
import com.itp4511.service.SessionService;

import java.util.List;

public class GuestServiceImpl implements GuestService {
    GuestDAO guestDAO = new GuestDAOImpl();
    ;

    @Override
    public boolean addGuest(Guest guest) {




        return guestDAO.addGuest(guest)>0;
    }

    @Override
    //check is the guest name add is duplicated
    public boolean isExistsGuestName(String guestName) {
        return guestDAO.queryGuestByGuestName(guestName) != null;
    }

    @Override
    public List<Guest> getRelevantGuestByMemberID(int guestFKmemberID) {
        return guestDAO.getRelevantGuestByMemberID(guestFKmemberID);
    }

    @Override
    public List<Guest> getGuestNotListedOnASessionByMemberID(int memberID, int sessionID) {

        return guestDAO.getGuestNotListedOnASessionByMemberID(memberID, sessionID);
    }

    @Override
    public boolean deleteGuest(int guestID) {
        return guestDAO.deleteGuest(guestID);
    }
}
