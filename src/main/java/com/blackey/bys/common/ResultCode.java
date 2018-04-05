package com.blackey.bys.common;

/**
 * 返回编码抽象接口，用于返回值统一处理.<p/>
 * 所有返回编码的枚举都需要实现该接口.
 * @author CUIAIWEN118.
 * Date: 2017/12/12.
 */
public interface ResultCode {
    /**
     * get编码
     * @return 编码值
     */
    int getCode();
    
    /**
     * get话术
     * @return 话术
     */
    String getMsg();
}
