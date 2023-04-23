package com.itp4511.domain;


import java.io.Serializable;
import java.util.ArrayList;

public class Guestlist implements Serializable {

  private int guestListId;


  public Guestlist() {
  }

  public Guestlist(int guestListId ) {
    this.guestListId = guestListId;

  }

  public long getGuestListId() {
    return guestListId;
  }

  public void setGuestListId(int guestListId) {
    this.guestListId = guestListId;
  }








//
//
//  //customer method  替代json
//
//
//  private ArrayList<Guest> guest;
//  // getter and setter of customers.
//  // default constructor
//
//  public Guestlist(Guest guest){
//    guest = new ArrayList<Guest>();
//  }
//
//
//  public ArrayList<CustomerBean> getCustomers() {
//    return customers;
//  }
//
//
//  public void setCustomers(ArrayList s){
//    customers = s;
//  }
//
//  public void addCustomer(CustomerBean customer) {
//    customers.add(customer);
//  }
//
//






}
