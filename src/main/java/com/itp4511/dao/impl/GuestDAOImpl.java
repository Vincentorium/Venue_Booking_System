package com.itp4511.dao.impl;

import com.itp4511.dao.BasicDAO;
import com.itp4511.dao.GuestDAO;
import com.itp4511.domain.Guest;

import java.util.List;

public  class GuestDAOImpl extends BasicDAO<Guest> implements GuestDAO {

    @Override
    public Guest queryGuestByGuestName(String name) {


        return querySingle("select * from Guest where guestName=?", Guest.class,name);

    }

    public List<Guest> getRelevantGuestByMemberID(int guestFKmemberID){

        List<Guest> gl=queryMulti("select * from Guest where guestFKmemberID=?", Guest.class,guestFKmemberID);;
        return gl;

    }

    public List<Guest> getGuestNotListedOnASessionByMemberID(int memberID, int sessionID){
        return queryMulti(
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
    public int addGuest(Guest guest) {

        int isSucess = 0;

        try {
            isSucess = update("INSERT INTO `guest`(`guestID`, `guestName`, `guestEmail`, `guestFKmemberID`) VALUES (?,?,?,?)",
                    null, guest.getGuestName(),guest.getGuestEmail(), guest.getGuestFKmemberId());

        } catch(Exception e) {

            System.out.println("Exception: " + e.getMessage());


        }

        return isSucess ;
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
            isSucess = update("DELETE FROM `guest` WHERE  guestID=?",
                    guestID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        return isSucess>0;
    }
}
