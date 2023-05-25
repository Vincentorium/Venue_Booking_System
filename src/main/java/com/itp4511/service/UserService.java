package com.itp4511.service;

import com.itp4511.dao.UserDAO;
import com.itp4511.dao.UserInfoDAO;
import com.itp4511.domain.BookingRecord;
import com.itp4511.domain.User;

import com.itp4511.domain.Userinfo;


import javax.servlet.http.HttpSession;
import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();
    private UserInfoDAO userInfoDAO = new UserInfoDAO();

    public UserService() {
    }

    public Userinfo getUserByAccAndPwd(String userAcc, String userPassword) {


        Userinfo user = null;
        try {

            user = userInfoDAO.querySingle("select * from user " +
                    "left join role on user.userType=role.roleID " +
                    "where userAcc=? and userPassword=?", Userinfo.class, userAcc, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;


    }

    public User createAccount(String userAcc, String userPassword, String userEmail, String userName) {


        User user = null;
        try {


            int isSuccess = userDAO.update("INSERT INTO `user` (  `userName`, `userAcc`, `userPassword`, `userType`, `userEmail`) VALUES ( ?, ?, ?,3,?);", User.class, userName, userAcc, userPassword, userEmail);

            if (isSuccess > 1) {

                Object o=       userDAO.queryScalar("SELECT `id`FROM `user`  " +
                        "ORDER BY bookID DESC " +
                        "LIMIT 1;", User.class);

                user=  getUserByUserID((int)o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;


    }



    public User getUserByUserID(int userID) {


        User user = null;
        try {

            user = userDAO.querySingle("SELECT * FROM `user` WHERE userID=?", User.class, userID);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;


    }


    public List<Userinfo> getMembers() {


        List<Userinfo>  user = null;
        try {

            user = userInfoDAO.queryMulti("SELECT * FROM `user`   left join role on userType = roleID where roleID=3;", Userinfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;


    }

}
