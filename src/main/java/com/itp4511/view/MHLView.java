package com.itp4511.view;

import com.itp4511.domain.User;
import com.itp4511.service.UserService;
import com.itp4511.utils.Utility;
import org.junit.Test;

import java.util.Scanner;


public class MHLView {

    private  boolean loop=true;
    private UserService userService = new UserService();



    @Test
    public  void mainMenuw(){

        while(loop){

            System.out.println("=================MHL=================");
            System.out.println("\t\t 1 login MHL");
            System.out.println("\t\t 2 logout MHL");
            System.out.println("Please enter your choice");
            String key= Utility.readString(1);
            switch(key){


                case "1":
                    System.out.println("login");
                    System.out.println("id");
                    String acc=Utility.readString(20);
                    System.out.println("ps");
                    String pwd=Utility.readString(20);
                    User user=userService.getUserByIDAndPwd(acc,pwd);
                    if(user!=null){
                        System.out.println("ok, "+user.getUserName());
                    }
                    break;
                case "2":

                    break;
                default:
                    System.out.println(" wrong ");

            }
        }
    }
}
