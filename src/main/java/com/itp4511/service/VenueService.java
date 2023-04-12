package com.itp4511.service;

import com.itp4511.dao.UserDAO;
import com.itp4511.dao.VenueDAO;
import com.itp4511.domain.User;
import com.itp4511.domain.Venue;

import java.util.List;

public class VenueService {

    private VenueDAO venueDAO=new VenueDAO();

    public List<Venue> getAllVenue(){
        return venueDAO.queryMulti("select * from Venue", Venue.class);

    }
}
