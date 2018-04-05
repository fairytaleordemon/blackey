package com.blackey.bys.common;

/**
 * 常用返回编码枚举.
 *
 * @author CUIAIWEN118.
 * @date 2017/12/12.
 */
public enum ResultCodeEnum implements ResultCode {
    /**
     * 成功的返回值
     */
    SUCCESS(200, "操作成功！"),
    
    /**
     * 参数校验失败的返回值
     */
    INVALID_REQUEST(400, "非法参数！"),
    
    /**
     * 权限不足的返回值
     */
    UNAUTHORIZED(401, "非法访问！"),
    
    /**
     * 找不到记录的返回值
     */
    NOT_FOUND(404, "记录不存在！"),
    
    /**
     * 系统异常的返回值
     */
    SYSTEM_ERROR(500, "系统异常，请稍后再试！"),
    
    /**
     * session超时的返回值
     */
    SESSION_TIMEOUT(504, "抱歉，您的页面超时了。为了您的安全，请验证手机后继续申请。"),
    /**
     * 解密失败的返回值
     */
    DECRYPT_ERROR(400001, "解密失败。"),
    /**
     * s签名失败的返回值
     */
    SIGN_ERROR(400002, "签名失败。")
    ;
    private int code;
    private String msg;
    
    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
