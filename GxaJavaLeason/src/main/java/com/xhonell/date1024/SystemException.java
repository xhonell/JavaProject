package com.xhonell.date1024;

/**
 * <p>Project:JavaProject - SystemException
 * <p>POWER by xhonell on 2024-10-24 14:06
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class SystemException extends Exception {
    public SystemException() {
        super("System Exception");
    }

    public SystemException(String message) {
        super(message);
    }
}
