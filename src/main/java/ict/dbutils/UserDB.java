/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.dbutils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vincent
 */
public class UserDB {

    private String url = "";
    private String username = "";
    private String password = "";

    public UserDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
   
        
        
        try {
            //System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");  
            Class.forName("com.mysql.jdbc.Driver");
             
//反射機制，直接幫DriverManager完成了註冊driver的工作。更好的是放到xml配置文件來處理

//            String url = "jdbc:mysql://localhost:8889/ITP4511_DB";
//            String username = "root";
//            String password = "root";
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return DriverManager.getConnection(url, username, password);
        
        
        
        
        
    }

    public void createUserInfoTable() {
        Connection connection = null;
        Statement statement = null;
        String sql;
        try {
            connection = getConnection();
            statement = connection.createStatement();

            sql = "CREATE TABLE UserInfo("
                    + "id VARCHAR(5) PRIMARY KEY,"
                    + "username VARCHAR(25) unique,"
                    + "password VARCHAR(25)"
                    + ")";

            statement.execute(sql);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        } catch (IOException e) {
            System.out.print(e);
        }
    }

    public boolean isValidUser(String user, String pwd) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "";
        ResultSet rs = null;
        boolean result = false;
        try {

            connection = getConnection();

            sql = "SELECT * FROM UserInfo WHERE USERNAME = ? AND PASSWORD = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pwd);

            preparedStatement.execute();
            rs = preparedStatement.getResultSet();
 

            if (rs.next()) {
               
                result = true;
            } else {
           

            }

        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        } catch (IOException e) {
            System.out.print(e);
        }
        return result;
    }

    public boolean addUserInfo(String id, String user, String pwd) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "";
        ResultSet rs = null;
        boolean result = false;
        
        
        try {

            connection = getConnection();

            sql = "INSERT INTO USERINFO VALUES (?,?,?)";
            
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, id);
            
            preparedStatement.setString(2, user);
            
            preparedStatement.setString(3, pwd);

            preparedStatement.executeUpdate();
            
            preparedStatement.close();

            result = true;

        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

}
