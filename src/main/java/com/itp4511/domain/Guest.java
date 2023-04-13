package com.itp4511.domain;


public class Guest {

  private long guestId;
  private String guestName;
  private String guestEmail;
  private long guestFKmemberId;

  public Guest() {
  }

  public Guest(long guestId, String guestName, String guestEmail, long guestFKmemberId) {
    this.guestId = guestId;
    this.guestName = guestName;
    this.guestEmail = guestEmail;
    this.guestFKmemberId = guestFKmemberId;
  }

  public long getGuestId() {
    return guestId;
  }

  public void setGuestId(long guestId) {
    this.guestId = guestId;
  }


  public String getGuestName() {
    return guestName;
  }

  public void setGuestName(String guestName) {
    this.guestName = guestName;
  }


  public String getGuestEmail() {
    return guestEmail;
  }

  public void setGuestEmail(String guestEmail) {
    this.guestEmail = guestEmail;
  }


  public long getGuestFKmemberId() {
    return guestFKmemberId;
  }

  public void setGuestFKmemberId(long guestFKmemberId) {
    this.guestFKmemberId = guestFKmemberId;
  }

}
