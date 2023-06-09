package com.itp4511.utils;

import com.itp4511.domain.Userinfo;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//practice
public class DBUtils_USE {


    //

    @Test  //BeanListHandler: return many rows
    public void testQueryMany() {
        //get result of many
        //1. get connection
        Connection connection =  C3p0Utils.getConnection();
        //2.
        //3.
        QueryRunner queryRunner = new QueryRunner();


        //4.執行相關方法，返回ArrayList resultset
        String sql = "select * from userinfo";
        try {

            List<Userinfo> list = queryRunner.query(connection, sql, new BeanListHandler<>(Userinfo.class));

            for (Userinfo user : list) {

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

            Userinfo list = queryRunner.query(connection, sql, new BeanHandler<>(Userinfo.class), 1);
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

        //3.
        QueryRunner queryRunner = new QueryRunner();

        //4.執行相關方法，返回ArrayList resultset
        String sql = "select username from userinfo where id = ?";
        try {

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




    @Test
    public void testDMLBach() {

        Connection connection = C3p0Utils.getConnection();
        String sqlInsert = "INSERT INTO `session` (`sessionID`, `sessionDate`,`sessionStartTime`, `sessionEndTime`,sessionStatus,sessionCampus) "
                + "VALUES (?,now(), ?, ?, ?,?)";


        Object[][] bachListInser = new Object[][]{
                {null, "10:11:00", "1:00:00", 1, 1},
                {null, "11:12:00", "1:00:00", 1, 1},
                {null, "12:13:00", "1:00:00", 1, 1},};


        String sql="UPDATE `session` SET  `sessionStatus`=?,`sessionFKbookingRecord`=?  where  `sessionID`=?";
        Object[][] bachList = new Object[][]{
                { 1, 1,9},
                { 1, 1,10},
                { 1, 1,11},};

        try {

            int affectedRow[] = qr.batch(connection, sql, bachList);
            System.out.println(affectedRow.length > 0 ? "做了" : "沒做");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils.closeAll(connection, null, null);
        }

    }

    private QueryRunner qr = new QueryRunner();

    //batch native
    public void testBatchupdate(ArrayList<String> dataArray, String sql) throws SQLException {
        Connection conn = C3p0Utils.getConnection();
        PreparedStatement ps = null;


        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);

            for (String data : dataArray) {
                String[] values = data.split(","); //Assuming the array contains strings delimited by semi-colon
                ps.setNull(1, java.sql.Types.NULL);
                ps.setString(2, values[0]);
                ps.setString(3, values[1]);
                ps.setString(4, values[2]);
                ps.setString(5, values[3]);
                ps.addBatch();
            }

            int isSuccess[] = ps.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            System.out.println(e);
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
                C3p0Utils.closeAll(conn, null, null);
            }
            conn.setAutoCommit(true);

        }
        C3p0Utils.closeAll(conn, null, null);
    }












}



