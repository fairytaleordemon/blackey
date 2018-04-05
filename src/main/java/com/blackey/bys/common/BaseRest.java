package com.blackey.bys.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * rest父类<p/>
 * 所有rest都继承此类，里面有log和一些返回值的封装，可以方便使用
 * @author CUIAIWEN118.
 * Date: 2017/12/15.
 */
public abstract class BaseRest {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 返回成功消息，{"code":200,"message":"操作成功！"}
     * @return Result
     */
    protected Result success() {
        return success(null);
    }
    
    /**
     * 返回成功消息，{"code":200,"message":"操作成功！","data":data}
     * @param data 具体要返回的数据
     * @return Result
     */
    protected Result success(Object data) {
        return new Result<>(ResultCodeEnum.SUCCESS, data);
    }
    
    /**
     * 返回失败消息，{"code":500,"message":"系统异常，请稍后再试！"}
     * @return Result
     */
    protected Result failure() {
        return failure(null);
    }
    
    /**
     * 返回失败消息，{"code":500,"message":"系统异常，请稍后再试！","data":data}
     * @param data 具体要返回的数据
     * @return Result
     */
    protected Result failure(Object data) {
        return failure(ResultCodeEnum.SYSTEM_ERROR, data);
    }
    
    /**
     * 返回失败消息，传入自定义ResultCode和data
     * @param resultCode 需要返回的code
     * @param data 需要返回的数据
     * @return Result
     */
    protected Result failure(ResultCode resultCode, Object data) {
        return new Result<>(resultCode, data);
    }

    /**
     * 返回失败消息，传入自定义的resultCode
     * @param resultCode 需要返回的code
     * @return Result
     */
    protected Result failure(ResultCode resultCode){
        return new Result<>(resultCode);
    }
}
