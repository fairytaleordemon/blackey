package com.blackey.bys.components.service.impl;

import com.blackey.bys.components.model.Activity;
import com.blackey.bys.components.model.Business;
import com.blackey.bys.components.repository.ActivityRepo;
import com.blackey.bys.components.service.ActivityService;
import com.blackey.bys.dto.ActivityForm;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {


    @Resource
    private ActivityRepo activityRepo;

    @Override
    public Page<Activity> page(Pageable pageable) {
        return activityRepo.findAll(pageable);
    }

    @Override
    public Optional detail(String id) {
        Activity activity = new Activity();
        activity.setId(id);
        Example example = Example.of(activity);

        return activityRepo.findOne(example);
    }


    public void save(ActivityForm form){
        Activity activity = new Activity();
        Business business = new Business();

        business.setId(form.getBusiness_id());
        activity.setBusiness(business);
        BeanUtils.copyProperties(form,activity);
        activityRepo.save(activity);
    }
}
