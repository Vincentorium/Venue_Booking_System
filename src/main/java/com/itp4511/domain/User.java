package com.itp4511.domain;

import java.io.Serializable;

public class User implements Serializable{


  private int userId;
  private String userName;
  private String userAcc;
  private String userPassword;
  private byte userType;

  public User(int userId, String userName, String userAcc, String userPassword, byte userType) {
    this.userId = userId;
    this.userName = userName;
    this.userAcc = userAcc;
    this.userPassword = userPassword;
    this.userType = userType;
  }

  public User() {
  }

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

  public void setUserType(byte userType) {
    this.userType = userType;
  }

}
