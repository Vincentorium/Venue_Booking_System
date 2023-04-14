package com.itp4511.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Guestlistbybookingid_Multi implements Serializable {



    private long bookId;
    private java.sql.Date bookDate;
    private String bookReceipt;
    private String bookReceiptName;
    private long bookStatus;
    private long bookFKmemberId;
    private long bookFkGuestList;
    private long sessionId;
    private java.sql.Date sessionDate;
    private java.sql.Time sessionStartTime;
    private java.sql.Time sessionEndTime;
    private long sessionCampus;
    private long sessionStatus;
    private long sessionFKbookingRecord;
    private long guestListId;
    private long guestListFkSession;
    private long guestListFKguestId;
    private long guestId;
    private String guestName;
    private String guestEmail;
    private long guestFKmemberId;


    public long getBookId() {
      return bookId;
    }

    public void setBookId(long bookId) {
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


    public long getBookStatus() {
      return bookStatus;
    }

    public void setBookStatus(long bookStatus) {
      this.bookStatus = bookStatus;
    }


    public long getBookFKmemberId() {
      return bookFKmemberId;
    }

    public void setBookFKmemberId(long bookFKmemberId) {
      this.bookFKmemberId = bookFKmemberId;
    }


    public long getBookFkGuestList() {
      return bookFkGuestList;
    }

    public void setBookFkGuestList(long bookFkGuestList) {
      this.bookFkGuestList = bookFkGuestList;
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

  }
