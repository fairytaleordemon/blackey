package com.blackey.bys.common.exception;

import com.blackey.bys.common.ResultCode;
import com.blackey.bys.common.ResultCodeEnum;


public class TimeoutException extends BaseException {

    public TimeoutException() {
        super(ResultCodeEnum.SESSION_TIMEOUT);
    }
    
    public TimeoutException(ResultCode errorCode) {
        super(errorCode);
    }
    
    public TimeoutException(Throwable cause) {
        super(cause);
    }
    
    public TimeoutException(ResultCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
