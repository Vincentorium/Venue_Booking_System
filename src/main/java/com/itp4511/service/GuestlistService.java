package com.itp4511.service;

import com.itp4511.dao.*;
import com.itp4511.domain.*;

import java.util.List;

public class GuestlistService {

    private GuestlistDAO guestlistDAO = new GuestlistDAO();
    private Guestlistbybookingid_MultiDAO guestlistbybookingid_MultiDAO = new Guestlistbybookingid_MultiDAO();


    private Guestlistenguest_MmDAO guestlistenguest_MmDAO = new Guestlistenguest_MmDAO();
    private Guestlistwithsessionandguestname_MultiDAO guestlistwithsessionandguestname_MultiDAO = new Guestlistwithsessionandguestname_MultiDAO();


    public List<Guestlistwithsessionandguestname_Multi> getGeustlistBySessionID(int sessionID) {


        String sql="SELECT * FROM `session` as s " +
                "left join guestlistenguest_mm as mm on s.sessionFKGuestlist=mm.guestlistNGuestFKguestlistID " +
                "left join guest as g on mm.guestlistNGuestFKguestID=g.guestID " +
                "where sessionID=?;";
        return guestlistwithsessionandguestname_MultiDAO.queryMulti (sql, Guestlistwithsessionandguestname_Multi.class, sessionID);

    }

    public List<Guestlistwithsessionandguestname_Multi> getGeustlistWithGuestNameByGuestListID(int guestListID) {

        return guestlistwithsessionandguestname_MultiDAO.queryMulti(
                "SELECT * FROM `guestlistenguest_mm` as mm " +
                "left join guest as g on mm.guestlistNGuestFKguestID =？" +
                "where guestlistNGuestFKguestlistID=？;", Guestlistwithsessionandguestname_Multi.class, guestListID);

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
     //   Object[][] guestCollection = new Object[bachList.length][3];
        //Object[][] guestCollection = new Object[bachList.length][3];

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

            Object[][] guestCollection = new Object[((int[]) bachList[k][4]).length][3];
            try {
                for (int i = 0; i < ((int[]) bachList[k][4]).length; i++) {


                        guestCollection[i][0] = 0;
                        guestCollection[i][1] = guestListID;
                        guestCollection[i][2] = ((int[]) (bachList[k][4]))[i];


            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }


/*
            for (int i = 0; i < bachList.length; i++) {
                for (int j = 0; j < ((int[]) (bachList[i][4])).length; j++) {

                    guestCollection[i][0] = 0;
                    guestCollection[i][1] = guestListID;
                    guestCollection[i][2] = ((int[]) (bachList[i][4]))[j];

                }
            }
*/


/*
                for (int j = 0; j < ((int[]) (bachList[0][4])).length; j++) {

                    guestCollection[j][0] = 0;
                    guestCollection[j][1] = guestListID;
                    guestCollection[j][2] = ((int[]) (bachList[i][4]))[j];

                }*/


            isUpdateGuestList = guestlistenguest_MmDAO.updateBach("INSERT INTO `guestlistenguest_mm` (`guestlistNGuestID`, `guestlistNGuestFKguestlistID`, `guestlistNGuestFKguestID`) VALUES (?,?,?);", guestCollection);

        }
        return bachListAfterGuest;
    }

    public void addGustIntoList(int listID,int guestID) {

        String sql="INSERT INTO `guestlistenguest_mm`(`guestlistNGuestID`, `guestlistNGuestFKguestlistID`, `guestlistNGuestFKguestID`) VALUES (null,?,?)";

        guestlistenguest_MmDAO.update(sql,listID,guestID);

    }
    public void deleteGustIntoList( int listID,int guestID) {

            String sql="DELETE FROM `guestlistenguest_mm`  " +

                    "WHERE guestlistNGuestFKguestlistID=? and guestlistNGuestFKguestID=?";

            guestlistenguest_MmDAO.update(sql,listID,guestID);

    }



}
