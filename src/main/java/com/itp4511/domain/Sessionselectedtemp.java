package com.itp4511.domain;


public class Sessionselectedtemp {

  private Integer tempId;
  private Integer tempMemberId;
  private Integer tempSessionId;

  public Sessionselectedtemp() {
  }

  public Sessionselectedtemp(Integer tempId, Integer tempMemberId, Integer tempSessionId) {
    this.tempId = tempId;
    this.tempMemberId = tempMemberId;
    this.tempSessionId = tempSessionId;
  }

  public Integer getTempId() {
    return tempId;
  }

  public void setTempId(Integer tempId) {
    this.tempId = tempId;
  }


  public Integer getTempMemberId() {
    return tempMemberId;
  }

  public void setTempMemberId(Integer tempMemberId) {
    this.tempMemberId = tempMemberId;
  }


  public Integer getTempSessionId() {
    return tempSessionId;
  }

  public void setTempSessionId(Integer tempSessionId) {
    this.tempSessionId = tempSessionId;
  }

}
