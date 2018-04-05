package com.blackey.bys.components.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.blackey.bys.components.model.Business;
import com.blackey.bys.components.repository.BusinessRepo;
import com.blackey.bys.components.service.BusinessService;
import com.blackey.bys.dto.BusinessForm;
import com.blackey.bys.dto.BusinessForm;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService{

    @Resource
    BusinessRepo businessRepo;



    public void save(BusinessForm form){
        Business challenge = new Business();
        BeanUtils.copyProperties(form,challenge);
        businessRepo.save(challenge);
    }

    @Override
    public void update(String id,String score, String confirm) {
        Business challenge = businessRepo.getOne(id);
        businessRepo.save(challenge);
    }

    @Override
    public Page<Business> page(Pageable pageable) {
        return businessRepo.findAll(pageable);
    }


}
