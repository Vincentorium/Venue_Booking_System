package com.itp4511.dao;

import com.itp4511.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {


    private QueryRunner qr = new QueryRunner();


    public int update(String sql, Object... parameters){


            Connection con=null;
        try {
            con= C3p0Utils.getConnection();
            int update = qr.update(con,sql,parameters);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }finally {
            C3p0Utils.closeAll(con,null,null);
        }


    }




    public   int[]  updateBach(String sql, Object[][] bachList ) {

        Connection connection = C3p0Utils.getConnection();
        int affectedRow[]=new int[bachList.length];

        try {

            int result[] = qr.batch(connection, sql, bachList);
           affectedRow=result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils.closeAll(connection, null, null);
        }
        return affectedRow;
    }

// return a result with multi-line
/*
* sql
* clazz: Actor.class
*
* */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters){

        Connection con=null;
        try {
            con= C3p0Utils.getConnection();
            return qr.query(con,sql,new BeanListHandler<T>(clazz),parameters);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }finally {
            C3p0Utils.closeAll(con,null,null);
        }


    }

    public T querySingle(String sql, Class<T>clazz, Object... parameters){

        Connection con=null;
        try {
            con= C3p0Utils.getConnection();
            return qr.query(con,sql,new BeanHandler<T>(clazz),parameters);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }finally {
            C3p0Utils.closeAll(con,null,null);
        }


    }


    public Object queryScalar(String sql, Class<T>clazz, Object... parameters){

        Connection con=null;
        try {
            con= C3p0Utils.getConnection();
            return qr.query(con,sql,new ScalarHandler());

        } catch (Exception e) {
            throw new RuntimeException(e);

        }finally {
            C3p0Utils.closeAll(con,null,null);
        }

    }








}
