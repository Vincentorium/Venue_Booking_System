package com.itp4511.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SessionObj {


    private int bookingID;
    private double totalPrie;
    private String sessionID;
    private int[] guestList;
    private double totalPrice;
    private int userID;



    private  int guestListID;

    public SessionObj(String sessionID, int[] guestList, double totalPrice, int userID) {
        this.sessionID = sessionID;
        this.guestList = guestList;
        this.totalPrice = totalPrice;
        this.userID = userID;
    }
    public int getGuestListID() {
        return guestListID;
    }

    public void setGuestListID(int guestListID) {
        this.guestListID = guestListID;
    }
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public double getTotalPrie() {
        return totalPrie;
    }

    public void setTotalPrie(double totalPrie) {
        this.totalPrie = totalPrie;
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

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getUserID() {
        return userID;
    }
}
