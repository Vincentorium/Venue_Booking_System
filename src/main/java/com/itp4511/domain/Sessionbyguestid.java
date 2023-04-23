package com.itp4511.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Sessionbyguestid implements Serializable {

  private int guestlistNGuestId;
  private int guestlistNGuestFKguestlistId;
  private int guestlistNGuestFKguestId;
  private int sessionId;
  private java.sql.Date sessionDate;
  private java.sql.Time sessionStartTime;
  private java.sql.Time sessionEndTime;
  private int sessionCampus;
  private int sessionStatus;
  private int sessionFKbookingRecord;
  private int sessionFkGuestlist;
  private int venId;
  private String venName;
  private String venType;
  private int venCapacity;
  private String venLocation;
  private String venDescription;
  private String venPersonInCharge;
  private double venBookingFee;
  private String venImage;
  private String venCampus;


  public Sessionbyguestid() {
  }

  public Sessionbyguestid(int guestlistNGuestId, int guestlistNGuestFKguestlistId, int guestlistNGuestFKguestId, int sessionId, Date sessionDate, Time sessionStartTime, Time sessionEndTime, int sessionCampus, int sessionStatus, int sessionFKbookingRecord, int sessionFkGuestlist, int venId, String venName, String venType, int venCapacity, String venLocation, String venDescription, String venPersonInCharge, double venBookingFee, String venImage, String venCampus) {
    this.guestlistNGuestId = guestlistNGuestId;
    this.guestlistNGuestFKguestlistId = guestlistNGuestFKguestlistId;
    this.guestlistNGuestFKguestId = guestlistNGuestFKguestId;
    this.sessionId = sessionId;
    this.sessionDate = sessionDate;
    this.sessionStartTime = sessionStartTime;
    this.sessionEndTime = sessionEndTime;
    this.sessionCampus = sessionCampus;
    this.sessionStatus = sessionStatus;
    this.sessionFKbookingRecord = sessionFKbookingRecord;
    this.sessionFkGuestlist = sessionFkGuestlist;
    this.venId = venId;
    this.venName = venName;
    this.venType = venType;
    this.venCapacity = venCapacity;
    this.venLocation = venLocation;
    this.venDescription = venDescription;
    this.venPersonInCharge = venPersonInCharge;
    this.venBookingFee = venBookingFee;
    this.venImage = venImage;
    this.venCampus = venCampus;
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


  public String getVenType() {
    return venType;
  }

  public void setVenType(String venType) {
    this.venType = venType;
  }


  public int getVenCapacity() {
    return venCapacity;
  }

  public void setVenCapacity(int venCapacity) {
    this.venCapacity = venCapacity;
  }


  public String getVenLocation() {
    return venLocation;
  }

  public void setVenLocation(String venLocation) {
    this.venLocation = venLocation;
  }


  public String getVenDescription() {
    return venDescription;
  }

  public void setVenDescription(String venDescription) {
    this.venDescription = venDescription;
  }


  public String getVenPersonInCharge() {
    return venPersonInCharge;
  }

  public void setVenPersonInCharge(String venPersonInCharge) {
    this.venPersonInCharge = venPersonInCharge;
  }


  public double getVenBookingFee() {
    return venBookingFee;
  }

  public void setVenBookingFee(double venBookingFee) {
    this.venBookingFee = venBookingFee;
  }


  public String getVenImage() {
    return venImage;
  }

  public void setVenImage(String venImage) {
    this.venImage = venImage;
  }


  public String getVenCampus() {
    return venCampus;
  }

  public void setVenCampus(String venCampus) {
    this.venCampus = venCampus;
  }

}
