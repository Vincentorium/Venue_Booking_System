package com.itp4511.service;

import com.itp4511.dao.*;
import com.itp4511.domain.*;
import com.itp4511.service.impl.BookingRecordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GuestlistService {

    private GuestlistDAO guestlistDAO = new GuestlistDAO();
    private Guestlistbybookingid_MultiDAO guestlistbybookingid_MultiDAO = new Guestlistbybookingid_MultiDAO();


    private Guestlistenguest_MmDAO guestlistenguest_MmDAO = new Guestlistenguest_MmDAO();
    private Guestlistwithsessionandguestname_MultiDAO guestlistwithsessionandguestname_MultiDAO = new Guestlistwithsessionandguestname_MultiDAO();

    private static final Logger LOG = LoggerFactory.getLogger(GuestlistService.class);

    public List<Guestlistwithsessionandguestname_Multi> getGeustlistBySessionID(int sessionID) {


        String sql = "SELECT * FROM `session` as s " +
                "left join guestlistenguest_mm as mm on s.sessionFKGuestlist=mm.guestlistNGuestFKguestlistID " +
                "left join guest as g on mm.guestlistNGuestFKguestID=g.guestID " +
                "where sessionID=?;";
        return guestlistwithsessionandguestname_MultiDAO.queryMulti(sql, Guestlistwithsessionandguestname_Multi.class, sessionID);

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

    public Object[][] addGuestlist(Object[][] batchArr) {
        int isUpdateGuestList[];
        int isUpdate = 0;
        final int indexOfGuesetIDArr = 3, attributesOfBatchArr = 3;
        Object[][] batchArrAfterRemoveGuestArr = new Object[batchArr.length][attributesOfBatchArr];
        /*
         * It seems redundant element in array will cause error when updating in data
         * so need to remove one array element from batchArr making its length from 5 to 4.
         *
         * So the guest array (index-4) of batchArr, which contain the guest IDs ,
         * will be removed after updating many to many relationship with guest list
         *
         * by doing this, a batchArrAfterRemoveGuestArr 2D array will replace  batchArr
         *
         * */

        LOG.debug("T");

        for (int k = 0; k < batchArr.length; k++) {


            //create guest list


            isUpdate = addGuestlistForSession();

            int guestListID = getLatestGuestListID();

            LOG.debug("Create Guest List: with ID: " + guestListID);

            //batchArr[k][1]= guestListID
            batchArrAfterRemoveGuestArr[k][0] = batchArr[k][0];
            batchArrAfterRemoveGuestArr[k][1] = guestListID;
            batchArrAfterRemoveGuestArr[k][2] = batchArr[k][2];
//            batchArrAfterRemoveGuestArr[k][3] =batchArr[k][3];


            //get guest data from batch

            Object[][] guestCollection = new Object[((int[]) batchArr[k][indexOfGuesetIDArr]).length][3];
            int i=0;
            try {
                for ( ; i < ((int[]) batchArr[k][indexOfGuesetIDArr]).length; i++) {


                    guestCollection[i][0] = null; //guestListNGuest_mm id
                    guestCollection[i][1] = guestListID; // GuestLisID
                    guestCollection[i][2] = ((int[]) (batchArr[k][indexOfGuesetIDArr]))[i]; //GuestID

                    LOG.debug("Guest List: " + guestListID + " Guest ID: " + ((int[]) (batchArr[k][indexOfGuesetIDArr]))[i]);
                }
            } catch (Exception e) {

                LOG.debug("Fail to create guestCollection array to update many-many table " + e.getMessage());
            }


            try {
                isUpdateGuestList = addGuestlistenguest_MMWithGuestListAndGuestID(guestCollection);
                LOG.debug("Succeed add record for guestList " +guestListID+ " with "+ i+" guest(s)" );
            } catch (Exception e) {
                LOG.debug("Fail to create  guestlistenguest_MmDAO : " + e.getMessage());
            }

        }
        return batchArrAfterRemoveGuestArr;
    }

    public int[] addGuestlistenguest_MMWithGuestListAndGuestID(Object[][] guestCollection) {

        return guestlistenguest_MmDAO.updateBach("INSERT INTO `guestlistenguest_mm` (`guestlistNGuestID`, `guestlistNGuestFKguestlistID`, `guestlistNGuestFKguestID`) VALUES (?,?,?);", guestCollection);

    }

    public int getLatestGuestListID() {
        return (int) guestlistDAO.queryScalar("SELECT `guestlistID`FROM `guestlist`  " +
                " ORDER BY guestlistID DESC " +
                " LIMIT 1;", Guestlist.class);

    }

    public int addGuestlistForSession() {
        return guestlistDAO.update("INSERT INTO `guestlist`(`guestListID`) VALUES (?)", 0);
    }

    public void addGustIntoList(int listID, int guestID) {

        String sql = "INSERT INTO `guestlistenguest_mm`(`guestlistNGuestID`, `guestlistNGuestFKguestlistID`, `guestlistNGuestFKguestID`) VALUES (null,?,?)";

        guestlistenguest_MmDAO.update(sql, listID, guestID);

    }

    public void deleteGustIntoList(int listID, int guestID) {

        String sql = "DELETE FROM `guestlistenguest_mm`  " +

                "WHERE guestlistNGuestFKguestlistID=? and guestlistNGuestFKguestID=?";

        guestlistenguest_MmDAO.update(sql, listID, guestID);

    }


}
