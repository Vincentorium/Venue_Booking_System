package com.itp4511.utils;

import ict.bean.UserInfo;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_USE {

    //

    @Test  //BeanListHandler: return many rows
    public void testQueryMany() {
        //get result of many
        //1. get connection
        Connection connection =  C3p0Utils.getConnection();
        //2.使用DUBTIL 的類和接口， 先引入UDBTILS jas， 加入到本Projec
        //3.
        QueryRunner queryRunner = new QueryRunner();

        //4.執行相關方法，返回ArrayList resultset
        String sql = "select * from userinfo";
        try {
            //(1) query方法就是執行sql語句，得到resultest --封裝到--> ArrayList集合中
            //(2) 返回集合
            //（3） connection: 連接
            //（4） sql: 執行的sql語句
            //（5） new BeanListHandler<>(Actor.class): 在將resultset - > Actor 對象 -> 封裝到 ArrayList
            // (6) 可變參數（object....params），根據sql的？決定，類似
            // (7) 底層得到的resulttest, h
            List<UserInfo> list = queryRunner.query(connection, sql, new BeanListHandler<>(UserInfo.class));

            for (UserInfo user : list) {

                System.out.println(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils.closeAll(connection, null, null);
        }

    }

    @Test  //BeanHandler: return a row
    public void testQuerySing() {

        Connection connection = C3p0Utils.getConnection();

        QueryRunner queryRunner = new QueryRunner();


        String sql = "select * from userinfo where id = ?";
        try {

            UserInfo list = queryRunner.query(connection, sql, new BeanHandler<>(UserInfo.class), 1);
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils.closeAll(connection, null, null);
        }

    }

    @Test
    public void testQueryAnObject() {
        //get result of many
        //1. get connection
        Connection connection = C3p0Utils.getConnection();
        //2.使用DUBTIL 的類和接口， 先引入UDBTILS jas， 加入到本Projec
        //3.
        QueryRunner queryRunner = new QueryRunner();

        //4.執行相關方法，返回ArrayList resultset
        String sql = "select username from userinfo where id = ?";
        try {
            //(1) query方法就是執行sql語句，得到resultest --封裝到--> ArrayList集合中
            //(2) 返回集合
            //（3） connection: 連接
            //（4） sql: 執行的sql語句
            //（5） new BeanListHandler<>(Actor.class): 在將resultset - > Actor 對象 -> 封裝到 ArrayList
            // (6) 可變參數（object....params），根據sql的？決定，類似
            // (7) 底層得到的resulttest, h
            Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 1);
            System.out.println(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils.closeAll(connection, null, null);
        }

    }

// dbutils - dml


    @Test
    public void testDML() {

        Connection connection = C3p0Utils.getConnection();
        QueryRunner queryRunner = new QueryRunner();

// Update        String sql = "update userinfo set username = ? where id = ?    ";
        //Insert:
        //String sql = "insert into userinfo values(?,?,?)";
//Delete:
        String sql = "delete from userinfo where id = ? ";

        try {

            int affectedRow = queryRunner.update(connection, sql,  2 );
            System.out.println(affectedRow>0?"做了":"沒做");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils.closeAll(connection, null, null);
        }

    }


}



