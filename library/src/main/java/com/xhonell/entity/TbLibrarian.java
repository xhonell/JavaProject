package com.xhonell.entity;


import com.xhonell.exception.BizException;
import com.xhonell.exception.BizExceptionCode;
import lombok.Data;


@Data
public class TbLibrarian {

  private long libId;
  private String libName;
  private long libAge;
  private long libPhone;
  private String libPassword;
  private String libRole;
  private java.sql.Timestamp libCreatTime;

  /**
   * TbLibrarian类的构造函数。
   * <p>
   * 该构造函数是一个无参构造函数，用于创建TbLibrarian类的实例。
   */
  public TbLibrarian() {
  }

  /**
   * TbLibrarian的构造函数
   *
   * @param libName    图书馆员姓名
   * @param libAge     图书馆员年龄
   * @param libPhone   图书馆员联系电话
   * @param libPasswod 图书馆员密码
   */
  public TbLibrarian(String libName, long libAge, long libPhone, String libPasswod) {
    this.libName = libName;
    this.libAge = libAge;
    this.libPhone = libPhone;
    this.libPassword = libPasswod;
  }

  /**
   * 设置库中的电话号码
   *
   * @param libPhone 要设置的电话号码
   * @return 如果电话号码格式不合法，则返回true；如果电话号码格式合法并已设置，则返回false
   * @throws BizException 如果电话号码格式不合法，则抛出BizException异常
   */
  public boolean setLibPhone(long libPhone) {
    if (!String.valueOf(libPhone).matches("^1[3-9]\\d{9}$")) {

      try {
        throw new BizException(BizExceptionCode.ILLLEGAL_PHONE_NUMBER);
      } catch (BizException e) {
        System.err.println(e.getMessage());
        return true;
      }

    } else {
      this.libPhone = libPhone;
      return false;
    }
  }


}

