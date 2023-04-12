package com.itp4511.service;


import com.itp4511.dao.SessionDAO;
import com.itp4511.domain.Session;
import org.junit.Test;

import java.sql.Date;
import java.util.List;


public class SessionService {

    private SessionDAO sessionDAO = new SessionDAO();




    @Test
    public boolean insertOneSession(java.sql.Time timeslotStart, java.sql.Time timeslotEnd) {

//
       // Date date = new Date(System.currentTimeMillis());
        int update = sessionDAO.update("INSERT INTO `session` (`sessionID`, `sessionDate`,`sessionStartTime`, `sessionEndTime`) VALUES (now(), ?, ?, ?)", null,  timeslotStart, timeslotEnd);
        System.out.println(update);
        return update > 0;
    }
    public List<Session> displaySessionByDate(String date) {

        return sessionDAO.queryMulti("SELECT * FROM `session` where sessionDate =(?)", Session.class, Date.valueOf(date));

    }
    public List<Session> displaySessionByDateAndCampus(int campus,String date) {

        return sessionDAO.queryMulti("SELECT * FROM `session` where sessionCampus=? and sessionDate =?", Session.class, campus,Date.valueOf(date));

    }
    //get the laest session id:   order=reorder
//    public List<Session> getSessionNotAvailableWithSelectedDay(){
//        return venueDAO.queryMulti("SELECT * FROM `session` ", Session.class);
//
//    }


}
