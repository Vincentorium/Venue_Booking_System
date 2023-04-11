package com.itp4511.domain;

import java.io.Serializable;

public class User implements Serializable{


  private long userId;
  private String userName;
  private String userAcc;
  private String userPassword;
  private byte userType;



  public User() {
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
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


  public long getUserType() {
    return userType;
  }

  public void setUserType(byte userType) {
    this.userType = userType;
  }

}
