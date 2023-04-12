package com.itp4511.dao;

import com.itp4511.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class BasicDAO<T> {


    private QueryRunner qr = new QueryRunner();

    //開發通用的dml方法，針對任意的表

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
