package com.itp4511.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SessionObj {
    private String sessionID;
    private int[] guestList;

    public SessionObj(String sessionID, int[] guestList) {
        this.sessionID = sessionID;
        this.guestList = guestList;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public int[] getGuestList() {
        return guestList;
    }

    public void setGuestList(int[] guestList) {
        this.guestList = guestList;
    }
}
