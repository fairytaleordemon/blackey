package com.blackey.bys.rest;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.blackey.bys.common.BaseRest;
import com.blackey.bys.common.Result;
import com.blackey.bys.components.service.UserInfoService;
import com.blackey.bys.components.service.FileUploadService;
import com.blackey.bys.dto.UserInfoForm;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/server/userInfo")
@RestController
public class UserInfoRest extends BaseRest{

    @Resource
    private UserInfoService userInfoService;



    @RequestMapping("/save")
    @PostMapping
    public Result save(HttpServletRequest request,@RequestParam String encryptData,@RequestParam String vi){
        userInfoService.saveWxUserForm(request,encryptData,vi);
        return success();
    }

    @RequestMapping("/login")
    @PostMapping
    public Result login(@ModelAttribute  UserInfoForm form,HttpServletRequest request){
        try {
            return success(userInfoService.login(request,form));
        } catch (WxErrorException e){
            return failure(e.getMessage());
        }
    }

}
