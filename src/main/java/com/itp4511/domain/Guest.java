package com.itp4511.domain;


import java.io.Serializable;

public class Guest implements Serializable {

  private Integer guestId;
  private String guestName;
  private String guestEmail;
  private int guestFKmemberId;

  public Guest() {
  }

  public Guest(Integer guestId, String guestName, String guestEmail, int guestFKmemberId) {
    this.guestId = guestId;
    this.guestName = guestName;
    this.guestEmail = guestEmail;
    this.guestFKmemberId = guestFKmemberId;
  }

  public Integer getGuestId() {
    return guestId;
  }

  public void setGuestId(Integer guestId) {
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


  public int getGuestFKmemberId() {
    return guestFKmemberId;
  }

  public void setGuestFKmemberId(int guestFKmemberId) {
    this.guestFKmemberId = guestFKmemberId;
  }

}
