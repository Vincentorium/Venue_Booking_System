package com.itp4511.service;

import com.itp4511.dao.GuestDAO;
import com.itp4511.domain.Guest;
import com.itp4511.domain.Sessionbyguestid;

import java.util.List;

public class GuestService {

    private GuestDAO guestDAO=new GuestDAO ();
    private SessionService sessionService=new SessionService();

    public List<Guest> getRelevantGuestByMemberID(int guestFKmemberID){
        return guestDAO.queryMulti("select * from Guest where guestFKmemberID=?", Guest.class,guestFKmemberID);

    }

    public List<Guest> getGuestNotListedOnASessionByMemberID(int memberID,int sessionID){
        return guestDAO.queryMulti(
                "SELECT * FROM `guest`  " +
                        "WHERE guest.guestFKmemberID=?  " +
                        "and guest.guestID " +

                        "not in " +
                        "(select g.guestID from session as s  " +
                        " left join guestlistenguest_mm as mm on s.sessionFKGuestlist=mm.guestlistNGuestFKguestlistID " +
                        " left join guest as  g  on g.guestID=mm.guestlistNGuestFKguestID " +
                        " where s.sessionID=? " +
                        "); ", Guest.class,memberID,sessionID);

    }

    public boolean addGuest(int memberID,String name,String mail) {

        int isSucess = 0;
        int index;
        try {
            isSucess = guestDAO.update("INSERT INTO `guest`(`guestID`, `guestName`, `guestEmail`, `guestFKmemberID`) VALUES (?,?,?,?)", null, name, mail, memberID);

        } catch(Exception e) {

            System.out.println("Exception: " + e.getMessage());


        }

        return isSucess>0;
    }


    public boolean deleteGuest(int guestID) {

        /*
        * 1.check if the guest is in other session in other guest list
        * 2. if yese, ask your if want to delete it from the relevant session
        * 3.
        *
        * */

        int isSucess = 0;


        try {
            isSucess = guestDAO.update("DELETE FROM `guest` WHERE  guestID=?",
                    guestID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        return isSucess>0;
    }
}
