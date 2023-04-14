package com.itp4511.service;

import com.itp4511.dao.GuestlistDAO;
import com.itp4511.domain.Guestlist;
import com.itp4511.dao.Guestlistwithguestsession_MultiDAO;
import com.itp4511.domain.Guestlistwithguestsession_Multi;

import com.itp4511.dao.Guestlistbybookingid_MultiDAO;
import com.itp4511.domain.Guestlistbybookingid_Multi;

import com.itp4511.domain.Guestlistenguest_Mm;
import com.itp4511.dao.Guestlistenguest_MmDAO;

import java.util.List;

public class GuestlistService {

    private GuestlistDAO guestlistDAO = new GuestlistDAO();
    private Guestlistbybookingid_MultiDAO guestlistbybookingid_MultiDAO = new Guestlistbybookingid_MultiDAO();

    private Guestlistwithguestsession_MultiDAO guestlistwithguestsession_MultiDAO = new Guestlistwithguestsession_MultiDAO();

    private Guestlistenguest_MmDAO guestlistenguest_MmDAO = new Guestlistenguest_MmDAO();


    public List<Guestlistwithguestsession_Multi> getGeustlistBySessionID(int sessionID) {

        return guestlistwithguestsession_MultiDAO.queryMulti("SELECT * FROM `guestlist` as gl " +
                "left join guest as g " +
                "on gl.guestListFKguestID=g.guestID " +
                "left join session as s " +
                "on   gl.guestListFKSession=s.sessionID  " +
                "where gl.guestListFKSession=?;", Guestlistwithguestsession_Multi.class, sessionID);

    }


    public List<Guestlistbybookingid_Multi> getGeustlistByBookingID(int bookingID) {

        return guestlistbybookingid_MultiDAO.queryMulti("select *  " +
                "from bookingrecord as br " +
                "left join session as s " +
                "on br.bookID=s.sessionFKbookingRecord " +
                "left join `guestlist` as gl " +
                "on s.sessionID=gl.guestListFKSession " +
                " " +
                "left join guest as g   " +
                "on gl.guestListFKguestID=g.guestID   " +
                "where br.bookID=? ", Guestlistbybookingid_Multi.class, bookingID);

    }


    public List<Guestlist> getAllVenue() {
        return guestlistDAO.queryMulti("select * from Guestlist", Guestlist.class);

    }

    public Object[][] addGuestlist(Object[][] bachList) {
        int isUpdateGuestList[];
        int isUpdate = 0;
        Object[][] bachListAfterGuest = new Object[bachList.length][4];
        Object[][] guestCollection = new Object[bachList.length][3];

        for (int k = 0; k < bachList.length; k++) {

            isUpdate = guestlistDAO.update("INSERT INTO `guestlist`(`guestListID`) VALUES (?)", 0);
            //if(isUpdate!=0){}


            Object guestListIDObject = guestlistDAO.queryScalar("SELECT `guestlistID`FROM `guestlist`  " +
                    " ORDER BY guestlistID DESC " +
                    " LIMIT 1;", Guestlist.class);

            int guestListID = (int) guestListIDObject;


            bachListAfterGuest[k][0] = bachList[k][0];
            bachListAfterGuest[k][1] = guestListID;
            bachListAfterGuest[k][2] =bachList[k][2];
            bachListAfterGuest[k][3] =bachList[k][3];

            //get guest data from bach
            for (int i = 0; i < bachList.length; i++) {
                for (int j = 0; j < ((int[]) (bachList[i][4])).length; j++) {

                    guestCollection[i][0] = 0;
                    guestCollection[i][1] = guestListID;
                    guestCollection[i][2] = ((int[]) (bachList[i][4]))[j];

                }

            }


            isUpdateGuestList = guestlistenguest_MmDAO.updateBach("INSERT INTO `guestlistenguest_mm` (`guestlistNGuestID`, `guestlistNGuestFKguestlistID`, `guestlistNGuestFKguestID`) VALUES (?,?,?);", guestCollection);

        }
        return bachListAfterGuest;
    }

    public void tesArr() {

    }


}
