package com.xhonell.util;

import com.xhonell.entity.TbLibrarian;
import com.xhonell.exception.BizException;
import com.xhonell.exception.BizExceptionCode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.xhonell.MainApp.jdbc;

/**
 * <p>Project:JavaProject - JDBCMethod
 * <p>POWER by xhonell on 2024-11-08 14:22
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class JDBCMethod {
    public boolean add(Object o) {
        if (o instanceof TbLibrarian) {
            TbLibrarian tbLibrarian = (TbLibrarian) o;

            String sql = "insert into tb_librarian(lib_phone,lib_password,lib_age,lib_name) values(?,?,?,?)";
            PreparedStatement statument = jdbc.getStatument(sql);

            try {
                statument.setLong(1, tbLibrarian.getLibPhone());
                statument.setString(2, tbLibrarian.getLibPassword());
                statument.setLong(3, tbLibrarian.getLibAge());
                statument.setString(4, tbLibrarian.getLibName());

                int i = statument.executeUpdate();
                if (i > 0) {
                    jdbc.getClose();
                    return true;
                } else {
                    try {
                        throw new BizException(BizExceptionCode.FAILED_ADD);
                    } catch (BizException e) {
                        System.err.println(e.getMessage());
                        return false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                jdbc.getClose();
            }
        }
        return false;

    }

    public boolean update(Object o) {
        if (o instanceof TbLibrarian) {
            TbLibrarian tbLibrarian = (TbLibrarian) o;
            String sql = "update tb_librarian set lib_phone=?,lib_password=?,lib_age=?,lib_name=? where lib_id=?";
            PreparedStatement statument = jdbc.getStatument(sql);

            try {
                statument.setLong(1, tbLibrarian.getLibPhone());
                statument.setString(2, tbLibrarian.getLibPassword());
                statument.setLong(3, tbLibrarian.getLibAge());
                statument.setString(4, tbLibrarian.getLibName());
                statument.setLong(5, tbLibrarian.getLibId());


            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

            try {
                int i = statument.executeUpdate();
                if (i > 0) {
                    jdbc.getClose();
                    return true;
                } else {
                    try {
                        throw new BizException(BizExceptionCode.FAILED_ADD);
                    } catch (BizException e) {
                        System.err.println(e.getMessage());
                        return false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                jdbc.getClose();
            }
        }
        return false;
    }

    public boolean delete(Object o) {
        if (o instanceof TbLibrarian) {
            TbLibrarian tbLibrarian = (TbLibrarian) o;
            String sql = "delete from tb_librarian where lib_id=?";
            PreparedStatement statument = jdbc.getStatument(sql);
            try {
                statument.setLong(1, tbLibrarian.getLibId());
                int i = statument.executeUpdate();
                if (i > 0) {
                    jdbc.getClose();
                    return true;
                } else {
                    try {
                        throw new BizException(BizExceptionCode.FAILED_ADD);
                    } catch (BizException e) {
                        System.err.println(e.getMessage());
                        return false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                jdbc.getClose();
            }
        }
        return false;
    }

    public Object selectById(Object o) {
        if (o instanceof TbLibrarian) {
            TbLibrarian tbLibrarian = (TbLibrarian) o;
            String sql = "select * from tb_librarian where lib_id=?";
            PreparedStatement statument = jdbc.getStatument(sql);
            try {
                statument.setLong(1, tbLibrarian.getLibId());
                ResultSet resultSet = statument.executeQuery();
                while (resultSet.next()) {
                    tbLibrarian.setLibId(resultSet.getLong("lib_id"));
                    tbLibrarian.setLibName(resultSet.getString("lib_name"));
                    tbLibrarian.setLibAge(resultSet.getLong("lib_age"));
                    tbLibrarian.setLibPhone(resultSet.getLong("lib_phone"));
                    tbLibrarian.setLibPassword(resultSet.getString("lib_password"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                jdbc.getClose();
            }
        }
        return false;
    }
}
