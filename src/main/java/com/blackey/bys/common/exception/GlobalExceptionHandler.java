package com.blackey.bys.common.exception;

import com.blackey.bys.common.Result;
import com.blackey.bys.common.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常统一处理 <p/>
 * 各module将此类配置到容器中，即可统一处理异常，不需要自定义
 * @author CUIAIWEN118.
 * Date: 2017/12/14.
 */
@ControllerAdvice({"com.blackey.bys"})
@Configuration
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    /**
     * 统一处理业务异常，返回异常code和message
     */
    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public Result baseExceptionHandler(HttpServletRequest req, BaseException ex) {
        LOG.error("ERROR！GET REQUEST URL :",req.getRequestURI());
        LOG.error("errorCode=" + ex.getErrorCode(), ex);
        return new Result(ex.getErrorCode(), ex.getMessage());
    }
    
    /**
     * 统一处理非业务异常，返回500 <ｐ/>
     * {"code":500,"message":"系统异常，请稍后再试！"}
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result otherExceptionHandler(HttpServletRequest req, Exception ex) {
        LOG.error("ERROR！GET REQUEST URL :", req.getRequestURI());
        LOG.error(ex.getMessage(), ex);
        return new Result(ResultCodeEnum.SYSTEM_ERROR);
    }

}
