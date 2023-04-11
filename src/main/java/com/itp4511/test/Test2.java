package com.itp4511.test;

import com.itp4511.utils.C3p0Utils;
import com.itp4511.utils.Utility;

import java.sql.Connection;

public class Test2 {
    public static void main(String[] args) {

        // test the utils

        System.out.println("Input a integer");
        int i= Utility.readInt();
        System.out.println("The result is: "+ i);
        Connection conn= C3p0Utils.getConnection();
        System.out.println("connection: "+conn);
    }

    public void test2() {

        System.out.println("twwet");
    }
}
