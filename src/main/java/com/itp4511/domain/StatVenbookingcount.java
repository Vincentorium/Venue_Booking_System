package com.itp4511.domain;


public class StatVenbookingcount {

  private int venId;
  private String venName;
  private java.sql.Date sessionDate;
  private int bookingCount;
  private double bookingRevenue;


  public int getVenId() {
    return venId;
  }

  public void setVenId(int venId) {
    this.venId = venId;
  }


  public String getVenName() {
    return venName;
  }

  public void setVenName(String venName) {
    this.venName = venName;
  }


  public java.sql.Date getSessionDate() {
    return sessionDate;
  }

  public void setSessionDate(java.sql.Date sessionDate) {
    this.sessionDate = sessionDate;
  }


  public int getBookingCount() {
    return bookingCount;
  }

  public void setBookingCount(int bookingCount) {
    this.bookingCount = bookingCount;
  }


  public double getBookingRevenue() {
    return bookingRevenue;
  }

  public void setBookingRevenue(double bookingRevenue) {
    this.bookingRevenue = bookingRevenue;
  }

}
