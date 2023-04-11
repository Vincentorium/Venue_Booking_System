package com.itp4511.service;

import com.itp4511.dao.UserDAO;
import com.itp4511.domain.User;

public class UserService {

    private UserDAO userDAO=new UserDAO();

    public User getUserByIDAndPwd(String userAcc,String userPassword){

       User user= userDAO.querySingle("select * from user where userAcc=? and userPassword=?",User.class,userAcc,userPassword);

        return user;




    }
}
