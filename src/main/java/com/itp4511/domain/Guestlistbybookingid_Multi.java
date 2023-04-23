package com.itp4511.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Guestlistbybookingid_Multi implements Serializable {



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
    private int guestListId;
    private int guestListFkSession;
    private int guestListFKguestId;
    private int guestId;
    private String guestName;
    private String guestEmail;
    private int guestFKmemberId;


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


    public int getGuestListId() {
      return guestListId;
    }

    public void setGuestListId(int guestListId) {
      this.guestListId = guestListId;
    }


    public int getGuestListFkSession() {
      return guestListFkSession;
    }

    public void setGuestListFkSession(int guestListFkSession) {
      this.guestListFkSession = guestListFkSession;
    }


    public int getGuestListFKguestId() {
      return guestListFKguestId;
    }

    public void setGuestListFKguestId(int guestListFKguestId) {
      this.guestListFKguestId = guestListFKguestId;
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
