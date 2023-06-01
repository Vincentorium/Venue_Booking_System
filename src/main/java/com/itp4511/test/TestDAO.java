package com.itp4511.test;

//import com.itp4511.controller.OtherController;
import com.itp4511.dao.UserDAO;
import com.itp4511.dao.UserInfoDAO;
import com.itp4511.domain.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestDAO {
//    public static final Logger LOG = LoggerFactory.getLogger(OtherController.class);
    @Test
    public void testUserInfoDAO(){
       // LOG.debug("test log");
/*
        UserInfoDAO userInfoDAO=new UserInfoDAO();
        List<UserInfo> userInfoList= userInfoDAO.queryMulti("select * from user where id >= ?",UserInfo.class,1);
        System.out.println("Result-------");
        for(UserInfo userInfo:userInfoList){
            System.out.println(userInfo);
        }
*/
        UserDAO userDAO=new UserDAO();
              List<User> userInfoList= userDAO.queryMulti("select * from user where userId >= ?",User.class,1);
        System.out.println("Result-------");
        for(User User:userInfoList){
            System.out.println(User.getUserName());
        }



        User user2= userDAO.querySingle("select * from user where userId = ?",User.class,1);
        System.out.println("Result-------");

            System.out.println(user2.getUserName());


    }



}
