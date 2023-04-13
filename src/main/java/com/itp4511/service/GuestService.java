package com.itp4511.service;

import com.itp4511.dao.GuestDAO;
import com.itp4511.domain.Guest;

import java.util.List;

public class GuestService {

    private GuestDAO guestDAO=new GuestDAO ();

    public List<Guest> getAllVenueByID(int guestFKmemberID){
        return guestDAO.queryMulti("select * from Guest where guestFKmemberID=?", Guest.class,guestFKmemberID);

    }


    public boolean addGuest(int memberID,String name,String mail) {

        int isSucess = 0;
        int index;
        isSucess = guestDAO.update("INSERT INTO `guest`(`guestID`, `guestName`, `guestEmail`, `guestFKmemberID`) VALUES (?,?,?,?)",
                null,name,mail,memberID);


        return isSucess>0;
    }
}
