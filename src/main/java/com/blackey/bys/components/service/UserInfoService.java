package com.blackey.bys.components.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.blackey.bys.common.Result;
import com.blackey.bys.components.model.UserInfo;
import com.blackey.bys.dto.UserInfoForm;
import org.apache.http.HttpRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;

public interface UserInfoService {

    void save(UserInfoForm form);

    void update(String id, String score, String confirm);

    Page<UserInfo> page(Pageable pageable);

    WxMaJscode2SessionResult login(HttpServletRequest request,UserInfoForm form);

    UserInfoForm saveWxUserForm(HttpServletRequest request,String encryptData,String vi);

    UserInfo selectByOpenId(String openId);
}
