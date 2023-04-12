package com.itp4511.domain;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Session implements Serializable {



  private long sessionId;
  private java.sql.Date sessionDate;
  private java.sql.Time sessionStartTime;
  private java.sql.Time sessionEndTime;
  private long sessionCampus;
  private long sessionStatus;

  public Session() {
  }

  public Session(long sessionId, Date sessionDate, Time sessionStartTime, Time sessionEndTime, long sessionCampus, long sessionStatus) {
    this.sessionId = sessionId;
    this.sessionDate = sessionDate;
    this.sessionStartTime = sessionStartTime;
    this.sessionEndTime = sessionEndTime;
    this.sessionCampus = sessionCampus;
    this.sessionStatus = sessionStatus;
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

}
