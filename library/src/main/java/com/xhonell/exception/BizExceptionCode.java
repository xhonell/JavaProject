package com.xhonell.exception;

/**
 * 声明一个枚举，构架标准的自定义异常所需的异常信息和状态码
 */
public enum BizExceptionCode {

    /*定义枚举常量
    * 设定常量的要求
    *   1、多个单词组成
    *   2、全英文、全大写
    *   3、核心问题在前，设计业务在后*/

    //手机号不合法
    ILLLEGAL_PHONE_NUMBER(1003, "手机号不合法"),
    //登录失败
    FAILED_LOGIN(1004, "登录失败"),
    //Id不合法
    FAILED_ID(1005, "Id不合法"),
    //添加失败
    FAILED_ADD(1006, "添加失败"),
    //手机号存在
    EXISTED_PHONE(1007, "手机号已存在");


    private Integer code;
    private String msg;

    BizExceptionCode() {
    }

    BizExceptionCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
