package com.blackey.bys.components.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.blackey.bys.common.Result;
import com.blackey.bys.common.utils.WXUtils;
import com.blackey.bys.components.model.UserInfo;
import com.blackey.bys.components.repository.UserInfoRepo;
import com.blackey.bys.components.service.UserInfoService;
import com.blackey.bys.dto.UserInfoForm;
import com.google.gson.Gson;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoRepo userInfoRepo;

    @Resource
    private WxMaService wxMaService;


    public void save(UserInfoForm form){
        UserInfo challenge = new UserInfo();
        BeanUtils.copyProperties(form,challenge);
        userInfoRepo.save(challenge);
    }

    @Override
    public void update(String id,String score, String confirm) {
        UserInfo challenge = userInfoRepo.getOne(id);
        userInfoRepo.save(challenge);
    }

    @Override
    public Page<UserInfo> page(Pageable pageable) {
        return userInfoRepo.findAll(pageable);
    }

    @Override
    public WxMaJscode2SessionResult login(HttpServletRequest request,UserInfoForm form) {
        try {
            WxMaJscode2SessionResult result = this.wxMaService.getUserService().getSessionInfo(form.getCode());
            Gson gson = new Gson();
            String sessionKey = (String) request.getSession().getAttribute("wxSessionKey");
            UserInfo userInfo =  gson.fromJson(WXUtils.decryptWxUser(sessionKey,form.getEncrypData(),form.getVi()),UserInfo.class);
            userInfoRepo.save(userInfo);

            return result;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserInfoForm saveWxUserForm(HttpServletRequest request,String encryptData,String vi) {
        Gson gson = new Gson();

        String sessionKey = (String) request.getSession().getAttribute("wxSessionKey");
        UserInfo userInfo =  gson.fromJson(WXUtils.decryptWxUser(sessionKey,encryptData,vi),UserInfo.class);
        userInfoRepo.save(userInfo);

        System.out.println(userInfo);
        return null;
    }

    @Override
    public UserInfo selectByOpenId(String openId) {
        return userInfoRepo.selectByOpenId(openId);
    }
}
