package com.itp4511.test;

import com.itp4511.domain.Guest;
import com.itp4511.service.GuestService;
import com.itp4511.service.impl.GuestServiceImpl;
import com.itp4511.utils.C3p0Utils;
import com.itp4511.utils.Utility;
import org.jfree.util.Log;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;

public class GuestDOA_Test {
    public static final Logger LOG = LoggerFactory.getLogger(GuestDOA_Test.class);
   @Test
    public void test() {



    Guest guest=new Guest(null, "Gancy","Aristotle@gmail.com",1);

       GuestService gs=new GuestServiceImpl();
       LOG.warn("Guest exist? "+gs.isExistsGuestName(guest.getGuestName()));

       gs.addGuest(guest);
       LOG.warn("Guest exist? "+gs.isExistsGuestName(guest.getGuestName()));
   }


    @Test
    public void testQuery() {



//        Guest guest=new Guest(null, "Gancy","Aristotle@gmail.com",1);

        GuestService gs=new GuestServiceImpl();


        List<Guest> gl= gs.getRelevantGuestByMemberID(1);
        for (Guest guest : gl) {
            System.out.println(guest.getGuestId());;

        }

    }
}