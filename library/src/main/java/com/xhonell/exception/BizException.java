package com.xhonell.exception;

import lombok.Data;

/**
 * businesss 业务
 * BizException 表示自定义的业务异常
 */
@Data
public class BizException extends Exception {
    private Integer code;

    /**
     * BizException 构造函数
     *
     * @param bizExceptionCode 异常代码枚举
     */
    public BizException(BizExceptionCode bizExceptionCode) {

        //从枚举中获得MSG
        super(bizExceptionCode.getMsg());
        this.code = bizExceptionCode.getCode();
    }
}
