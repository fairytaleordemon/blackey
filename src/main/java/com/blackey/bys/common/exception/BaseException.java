package com.blackey.bys.common.exception;

import com.blackey.bys.common.ResultCode;
import com.blackey.bys.common.ResultCodeEnum;

/**
 * 异常父类，所有业务异常需要继承此类
 * @author CUIAIWEN118.
 * Date: 2017/12/12.
 */
public abstract class BaseException extends RuntimeException {
    
    private int errorCode;
    
    BaseException() {
        this(ResultCodeEnum.SYSTEM_ERROR);
    }
    
    BaseException(ResultCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode.getCode();
    }
    
    BaseException(Throwable cause) {
        this(ResultCodeEnum.SYSTEM_ERROR, cause);
    }
    
    BaseException(ResultCode errorCode, Throwable cause) {
        super(errorCode.getMsg(), cause);
        this.errorCode = errorCode.getCode();
    }
    
    BaseException(ResultCode errorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(errorCode.getMsg(), cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode.getCode();
    }
    
    public int getErrorCode() {
        return errorCode;
    }
}
