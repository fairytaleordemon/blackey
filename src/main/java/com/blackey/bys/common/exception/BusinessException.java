package com.blackey.bys.common.exception;

import com.blackey.bys.common.ResultCode;




public class BusinessException extends BaseException {
    

    public BusinessException() {
        super();
    }

    public BusinessException(ResultCode errorCode) {
        super(errorCode);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(ResultCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
    
}
