package com.blackey.bys.rest;


import com.blackey.bys.common.BaseRest;
import com.blackey.bys.common.Result;
import com.blackey.bys.common.config.Config;
import com.blackey.bys.components.model.Activity;
import com.blackey.bys.components.service.ActivityService;
import com.blackey.bys.components.service.FileUploadService;
import com.blackey.bys.dto.ActivityForm;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Optional;

@RequestMapping("/server/activity")
@RestController
public class ActivityRest extends BaseRest{

    @Resource
    private ActivityService activityService;

    @Resource
    private FileUploadService fileUploadService;


    @RequestMapping("/page")
    @PostMapping
    public Result page(Pageable pageable){
        return success(activityService.page(pageable));
    }

    @RequestMapping("/detail")
    @PostMapping
    public Result detail(String id){
        Optional activity = activityService.detail(id);
        System.out.println(activity);
        return success(activity);
    }

    @RequestMapping("/save")
    @PostMapping
    public Result save(ActivityForm form,@RequestParam(value = "file",required = false) MultipartFile file){
        if (!(file == null)){
            form.setMainPage(Config.domain + fileUploadService.uploadFile(request,file));
        }

        activityService.save(form);
        return success();
    }
}
