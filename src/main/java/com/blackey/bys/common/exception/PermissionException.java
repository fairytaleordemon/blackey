package com.blackey.bys.common.exception;

import com.blackey.bys.common.ResultCode;
import com.blackey.bys.common.ResultCodeEnum;


public class PermissionException extends BaseException {
    private static final long serialVersionUID = -4637150032764687275L;
    
    public PermissionException() {
        super(ResultCodeEnum.UNAUTHORIZED);
    }
    
    public PermissionException(ResultCode errorCode) {
        super(errorCode);
    }
    
    public PermissionException(Throwable cause) {
        super(cause);
    }
    
    public PermissionException(ResultCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
