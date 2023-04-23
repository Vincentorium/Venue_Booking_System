package com.itp4511.domain;


public class BookingInfo_MM {

  private int userId;
  private String userName;
  private String userAcc;
  private String userPassword;
  private int userType;
  private int bookId;
  private java.sql.Date bookDate;
  private String bookReceipt;
  private String bookReceiptName;
  private int bookStatus;
  private int bookFKmemberId;
  private int bookFkGuestList;
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
  private int guestListId;
  private int guestlistNGuestId;
  private int guestlistNGuestFKguestlistId;
  private int guestlistNGuestFKguestId;
  private int guestId;
  private String guestName;
  private String guestEmail;
  private int guestFKmemberId;


  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserAcc() {
    return userAcc;
  }

  public void setUserAcc(String userAcc) {
    this.userAcc = userAcc;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public int getUserType() {
    return userType;
  }

  public void setUserType(int userType) {
    this.userType = userType;
  }


  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }


  public java.sql.Date getBookDate() {
    return bookDate;
  }

  public void setBookDate(java.sql.Date bookDate) {
    this.bookDate = bookDate;
  }


  public String getBookReceipt() {
    return bookReceipt;
  }

  public void setBookReceipt(String bookReceipt) {
    this.bookReceipt = bookReceipt;
  }


  public String getBookReceiptName() {
    return bookReceiptName;
  }

  public void setBookReceiptName(String bookReceiptName) {
    this.bookReceiptName = bookReceiptName;
  }


  public int getBookStatus() {
    return bookStatus;
  }

  public void setBookStatus(int bookStatus) {
    this.bookStatus = bookStatus;
  }


  public int getBookFKmemberId() {
    return bookFKmemberId;
  }

  public void setBookFKmemberId(int bookFKmemberId) {
    this.bookFKmemberId = bookFKmemberId;
  }


  public int getBookFkGuestList() {
    return bookFkGuestList;
  }

  public void setBookFkGuestList(int bookFkGuestList) {
    this.bookFkGuestList = bookFkGuestList;
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


  public int getGuestListId() {
    return guestListId;
  }

  public void setGuestListId(int guestListId) {
    this.guestListId = guestListId;
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
