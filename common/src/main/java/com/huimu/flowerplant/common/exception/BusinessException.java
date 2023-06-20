package com.huimu.flowerplant.common.exception;

public class BusinessException extends RuntimeException {

    private final Integer code;

    private final String msg;

    public BusinessException(HmExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
