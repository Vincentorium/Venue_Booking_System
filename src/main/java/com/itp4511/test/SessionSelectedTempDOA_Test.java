package com.itp4511.test;

import com.itp4511.domain.Guest;
import com.itp4511.service.GuestService;
import com.itp4511.service.SessionselectedtempService;
import com.itp4511.service.impl.GuestServiceImpl;
import com.itp4511.service.impl.SessionselectedtempServiceImpl;
import org.jfree.util.Log;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SessionSelectedTempDOA_Test {
    public static final Logger LOG = LoggerFactory.getLogger(SessionSelectedTempDOA_Test.class);
   @Test
    public void test() {



       SessionselectedtempService s=new SessionselectedtempServiceImpl();
       Integer i =s. addSessionTemp( 1,143);
       Log.debug("Test add session selected to db");
        LOG.debug(String.valueOf((int)i));

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