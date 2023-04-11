/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;
import ict.dbutils.UserDB;
/**
 *
 * @author Vincent
 */
public class TestCreateDB {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/ITP4511_DB";
        String username = "root";
        String password = "";

        UserDB userDB = new UserDB(url, username, password);
 
     //   userDB.createUserInfoTable();
       userDB.addUserInfo("4", "xyz", "123");
               
    }
}
