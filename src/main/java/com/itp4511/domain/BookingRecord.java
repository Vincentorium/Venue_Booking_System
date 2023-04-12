package com.itp4511.domain;


import java.io.Serializable;
import java.sql.Date;

public class BookingRecord implements Serializable {

  private long bookId;
  private java.sql.Date bookDate;
  private String bookReceipt;
  private String bookReceiptName;
  private long bookStatus;
  private long bookFKmemberId;
  private long bookFkSession;
  private long bookFkGuestList;


  public BookingRecord() {
  }

  public BookingRecord(long bookId, Date bookDate, String bookReceipt, String bookReceiptName, long bookStatus, long bookFKmemberId, long bookFkSession, long bookFkGuestList) {
    this.bookId = bookId;
    this.bookDate = bookDate;
    this.bookReceipt = bookReceipt;
    this.bookReceiptName = bookReceiptName;
    this.bookStatus = bookStatus;
    this.bookFKmemberId = bookFKmemberId;
    this.bookFkSession = bookFkSession;
    this.bookFkGuestList = bookFkGuestList;
  }

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


  public long getBookFkSession() {
    return bookFkSession;
  }

  public void setBookFkSession(long bookFkSession) {
    this.bookFkSession = bookFkSession;
  }


  public long getBookFkGuestList() {
    return bookFkGuestList;
  }

  public void setBookFkGuestList(long bookFkGuestList) {
    this.bookFkGuestList = bookFkGuestList;
  }

}
