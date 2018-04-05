package com.blackey.bys;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WxUser {

    @Resource
    WxMaService wxMaService;

    @Test
    public void getUser(){
        try {
            WxMaJscode2SessionResult sessionResult = this.wxMaService.getUserService().getSessionInfo("0210944G0aSqXk2ErS0G0Epb4G00944-");
            System.out.println(sessionResult);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

}
