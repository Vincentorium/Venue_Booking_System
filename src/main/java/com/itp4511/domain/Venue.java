
package com.itp4511.domain;


public class Venue {

  private long venID;
  private String venName;
  private String venType;
  private long venCapacity;
  private String venLocation;
  private String venDescription;
  private String venPersonInCharge;
  private double venBookingFee;
  private String venImage;
  private String venCampus;


  public Venue() {
  }

  public Venue(long venID, String venName, String venType, long venCapacity, String venLocation, String venDescription, String venPersonInCharge, double venBookingFee, String venImage, String venCampus) {
    this.venID = venID;
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

  public long getVenID() {
    return venID;
  }

  public void setVenID(long venID) {
    this.venID = venID;
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


  public long getVenCapacity() {
    return venCapacity;
  }

  public void setVenCapacity(long venCapacity) {
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
