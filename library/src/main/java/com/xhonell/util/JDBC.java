package com.xhonell.util;


import java.sql.*;

/**
 * <p>Project:JavaProject - JDBC
 * <p>POWER by xhonell on 2024-11-08 09:37
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class JDBC {
    private String url = "jdbc:mysql://localhost:3306/db_library";
    private String user = "root";
    private String password = "@Hx1234568";
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnect() {

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public PreparedStatement getStatument(String sql) {
        try {
            if (conn == null || conn.isClosed())
                getConnect();
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public boolean getClose() {
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
