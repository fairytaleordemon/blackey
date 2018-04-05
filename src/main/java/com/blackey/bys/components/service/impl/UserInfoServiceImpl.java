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
import com.google.gson.JsonObject;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public WxMaJscode2SessionResult login(HttpServletRequest request,UserInfoForm form) throws WxErrorException {

        WxMaJscode2SessionResult result = this.wxMaService.getUserService().getSessionInfo(form.getCode());
        String sessionKey = result.getSessionKey();
        Gson gson = new Gson();
        String resultStr = WXUtils.decryptWxUser(form.getEncrypData(),sessionKey,form.getIv());

        String userJson = gson.fromJson(resultStr, JsonObject.class).get("userInfo").getAsString();
        UserInfo userInfo =  gson.fromJson(userJson,UserInfo.class);

        UserInfo userInfoDb = userInfoRepo.selectByOpenId(userInfo.getOpenId());

        if (userInfoDb == null){
            userInfoRepo.save(userInfo);
        }
        //TODO 空对象拷贝
        return result;

    }

    @Override
    public UserInfoForm saveWxUserForm(HttpServletRequest request,String encryptData,String vi) {
        Gson gson = new Gson();
        String sessionKey = (String) request.getSession().getAttribute("wxSessionKey");
        UserInfo userInfo =  gson.fromJson(WXUtils.decryptWxUser(sessionKey,encryptData,vi),UserInfo.class);
        userInfoRepo.save(userInfo);
        return null;
    }

    @Override
    public UserInfo selectByOpenId(String openId) {
        return userInfoRepo.selectByOpenId(openId);
    }

    public static void main(String[] args) {

        String usr = "{\"msg\":\"解密成功\",\"userInfo\":\"{\\\"openId\\\":\\\"o8krx5BY-W5sbaf7Nykm0lZ3EGVM\\\",\\\"nickName\\\":\\\"blackey\\\",\\\"gender\\\":1,\\\"language\\\":\\\"zh_CN\\\",\\\"city\\\":\\\"\\\",\\\"province\\\":\\\"Shanghai\\\",\\\"country\\\":\\\"China\\\",\\\"avatarUrl\\\":\\\"https://wx.qlogo.cn/mmopen/vi_32/5zqwzaLyg7aJAvCvvJ8wjicHq7ibVc9rMYNCkOwj9pjgRJmaOUdxSBf4uofgMOF8qNmW214ZxvDLydam7rg8L2fQ/0\\\",\\\"watermark\\\":{\\\"timestamp\\\":1522931773,\\\"appid\\\":\\\"wx7dc1e3b215af00d3\\\"}}\",\"status\":\"1\"}";
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(usr, JsonObject.class);
        String userJson = jsonObject.get("userInfo").getAsString();
        UserInfo userInfo  = gson.fromJson(userJson,UserInfo.class);
        System.out.println(userInfo);
    }


}
