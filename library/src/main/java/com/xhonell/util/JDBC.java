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

    /**
     * 获取数据库连接
     *
     * @return 数据库连接对象
     */
    public Connection getConnect() {

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 获取一个预编译的 SQL 语句
     *
     * @param sql 要执行的 SQL 语句
     * @return PreparedStatement 对象，包含预编译的 SQL 语句
     * @throws SQLException 如果 SQL 语句预编译失败，则抛出 SQLException 异常
     */
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

    /**
     * 关闭资源。
     *
     * @return 如果所有资源成功关闭，则返回true；否则返回false。
     */
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
