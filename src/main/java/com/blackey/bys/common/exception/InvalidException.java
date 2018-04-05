package com.blackey.bys.common.exception;

import com.blackey.bys.common.ResultCode;
import com.blackey.bys.common.ResultCodeEnum;


public class InvalidException extends BaseException{
    private static final long serialVersionUID = -8538088377317864836L;
    
    public InvalidException() {
        super(ResultCodeEnum.INVALID_REQUEST);
    }
    
    public InvalidException(ResultCode errorCode) {
        super(errorCode);
    }
    
    public InvalidException(Throwable cause) {
        super(cause);
    }
    
    public InvalidException(ResultCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
