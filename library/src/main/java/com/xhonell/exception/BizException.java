package com.xhonell.exception;

import lombok.Data;

/**
 * businesss 业务
 * BizException 表示自定义的业务异常
 */
@Data
public class BizException extends Exception {
    private Integer code;

    public BizException(BizExceptionCode bizExceptionCode) {

        //从枚举中获得MSG
        super(bizExceptionCode.getMsg());
        this.code = bizExceptionCode.getCode();
    }
}
