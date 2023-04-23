package com.itp4511.domain;

import java.sql.Date;
import java.sql.Time;

public class Guestlistwithsessionandguestname_Multi {

  private int sessionId;
  private java.sql.Date sessionDate;
  private java.sql.Time sessionStartTime;
  private java.sql.Time sessionEndTime;
  private int sessionCampus;
  private int sessionStatus;
  private int sessionFKbookingRecord;
  private int sessionFkGuestlist;
  private int guestlistNGuestId;
  private int guestlistNGuestFKguestlistId;
  private int guestlistNGuestFKguestId;
  private int guestId;
  private String guestName;
  private String guestEmail;
  private int guestFKmemberId;

  public Guestlistwithsessionandguestname_Multi() {
  }

  public Guestlistwithsessionandguestname_Multi(int sessionId, Date sessionDate, Time sessionStartTime, Time sessionEndTime, int sessionCampus, int sessionStatus, int sessionFKbookingRecord, int sessionFkGuestlist, int guestlistNGuestId, int guestlistNGuestFKguestlistId, int guestlistNGuestFKguestId, int guestId, String guestName, String guestEmail, int guestFKmemberId) {
    this.sessionId = sessionId;
    this.sessionDate = sessionDate;
    this.sessionStartTime = sessionStartTime;
    this.sessionEndTime = sessionEndTime;
    this.sessionCampus = sessionCampus;
    this.sessionStatus = sessionStatus;
    this.sessionFKbookingRecord = sessionFKbookingRecord;
    this.sessionFkGuestlist = sessionFkGuestlist;
    this.guestlistNGuestId = guestlistNGuestId;
    this.guestlistNGuestFKguestlistId = guestlistNGuestFKguestlistId;
    this.guestlistNGuestFKguestId = guestlistNGuestFKguestId;
    this.guestId = guestId;
    this.guestName = guestName;
    this.guestEmail = guestEmail;
    this.guestFKmemberId = guestFKmemberId;
  }

  public int getSessionId() {
    return sessionId;
  }

  public void setSessionId(int sessionId) {
    this.sessionId = sessionId;
  }


  public java.sql.Date getSessionDate() {
    return sessionDate;
  }

  public void setSessionDate(java.sql.Date sessionDate) {
    this.sessionDate = sessionDate;
  }


  public java.sql.Time getSessionStartTime() {
    return sessionStartTime;
  }

  public void setSessionStartTime(java.sql.Time sessionStartTime) {
    this.sessionStartTime = sessionStartTime;
  }


  public java.sql.Time getSessionEndTime() {
    return sessionEndTime;
  }

  public void setSessionEndTime(java.sql.Time sessionEndTime) {
    this.sessionEndTime = sessionEndTime;
  }


  public int getSessionCampus() {
    return sessionCampus;
  }

  public void setSessionCampus(int sessionCampus) {
    this.sessionCampus = sessionCampus;
  }


  public int getSessionStatus() {
    return sessionStatus;
  }

  public void setSessionStatus(int sessionStatus) {
    this.sessionStatus = sessionStatus;
  }


  public int getSessionFKbookingRecord() {
    return sessionFKbookingRecord;
  }

  public void setSessionFKbookingRecord(int sessionFKbookingRecord) {
    this.sessionFKbookingRecord = sessionFKbookingRecord;
  }


  public int getSessionFkGuestlist() {
    return sessionFkGuestlist;
  }

  public void setSessionFkGuestlist(int sessionFkGuestlist) {
    this.sessionFkGuestlist = sessionFkGuestlist;
  }


  public int getGuestlistNGuestId() {
    return guestlistNGuestId;
  }

  public void setGuestlistNGuestId(int guestlistNGuestId) {
    this.guestlistNGuestId = guestlistNGuestId;
  }


  public int getGuestlistNGuestFKguestlistId() {
    return guestlistNGuestFKguestlistId;
  }

  public void setGuestlistNGuestFKguestlistId(int guestlistNGuestFKguestlistId) {
    this.guestlistNGuestFKguestlistId = guestlistNGuestFKguestlistId;
  }


  public int getGuestlistNGuestFKguestId() {
    return guestlistNGuestFKguestId;
  }

  public void setGuestlistNGuestFKguestId(int guestlistNGuestFKguestId) {
    this.guestlistNGuestFKguestId = guestlistNGuestFKguestId;
  }


  public int getGuestId() {
    return guestId;
  }

  public void setGuestId(int guestId) {
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
