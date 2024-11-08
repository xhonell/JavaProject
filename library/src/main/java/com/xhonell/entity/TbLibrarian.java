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

    public TbLibrarian() {
    }

    public TbLibrarian(String libName, long libAge, long libPhone, String libPasswod) {
        this.libName = libName;
        this.libAge = libAge;
        this.libPhone = libPhone;
        this.libPassword = libPasswod;
    }

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

