package com.itp4511.domain;

import java.io.Serializable;

public class Guestlistwithguestsession_Multi implements Serializable {

  private long guestListId;
  private long guestListFkSession;
  private long guestListFKguestId;
  private long guestId;
  private String guestName;
  private String guestEmail;
  private long guestFKmemberId;
  private long sessionId;
  private java.sql.Date sessionDate;
  private java.sql.Time sessionStartTime;
  private java.sql.Time sessionEndTime;
  private long sessionCampus;
  private long sessionStatus;
  private long sessionFKbookingRecord;


  public long getGuestListId() {
    return guestListId;
  }

  public void setGuestListId(long guestListId) {
    this.guestListId = guestListId;
  }


  public long getGuestListFkSession() {
    return guestListFkSession;
  }

  public void setGuestListFkSession(long guestListFkSession) {
    this.guestListFkSession = guestListFkSession;
  }


  public long getGuestListFKguestId() {
    return guestListFKguestId;
  }

  public void setGuestListFKguestId(long guestListFKguestId) {
    this.guestListFKguestId = guestListFKguestId;
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


  public long getSessionId() {
    return sessionId;
  }

  public void setSessionId(long sessionId) {
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


  public long getSessionCampus() {
    return sessionCampus;
  }

  public void setSessionCampus(long sessionCampus) {
    this.sessionCampus = sessionCampus;
  }


  public long getSessionStatus() {
    return sessionStatus;
  }

  public void setSessionStatus(long sessionStatus) {
    this.sessionStatus = sessionStatus;
  }


  public long getSessionFKbookingRecord() {
    return sessionFKbookingRecord;
  }

  public void setSessionFKbookingRecord(long sessionFKbookingRecord) {
    this.sessionFKbookingRecord = sessionFKbookingRecord;
  }

}
