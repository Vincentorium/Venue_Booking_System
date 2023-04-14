package com.itp4511.domain;


import java.io.Serializable;

public class Guestlist implements Serializable {

  private long guestListId;


  public Guestlist() {
  }

  public Guestlist(long guestListId ) {
    this.guestListId = guestListId;

  }

  public long getGuestListId() {
    return guestListId;
  }

  public void setGuestListId(long guestListId) {
    this.guestListId = guestListId;
  }



}
