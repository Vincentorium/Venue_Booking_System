package com.itp4511.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class C3p0Utils {
    static Logger logger = Logger.getLogger(C3p0Utils.class.getName());


    static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    /**
     * //
     * @return
     */

    public static Connection getConnection() {

        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            logger.error("Exception in C3p0Utils!", e);

        }
        return null;
    }

    public static DataSource getDataSource() {


        return dataSource;
    }

    /**
     *  
     */

    public static void closeAll(Connection conn, PreparedStatement pst, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);

            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);

            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);

            }
        }
    }
}

