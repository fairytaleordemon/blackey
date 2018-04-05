package com.blackey.bys.rest;

import com.blackey.bys.common.BaseRest;
import com.blackey.bys.common.Result;
import com.blackey.bys.common.config.Config;
import com.blackey.bys.components.service.BusinessService;
import com.blackey.bys.components.service.FileUploadService;
import com.blackey.bys.dto.BusinessForm;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RequestMapping("/server/business")
@RestController
public class BusinessRest extends BaseRest{

    @Resource
    private BusinessService businessService;

    @Resource
    private FileUploadService fileUploadService;


    @RequestMapping("/save")
    @PostMapping
    public Result save(@ModelAttribute  BusinessForm form,@RequestParam(value = "file",required = false) MultipartFile file){
        if (!(file == null)) {
            form.setImagePath(Config.domain + fileUploadService.uploadFile(request,file));
        }
        businessService.save(form);
        return success();
    }


    @RequestMapping("/page")
    @PostMapping
    public Result page(Pageable pageable){
        return success(businessService.page(pageable));
    }

    @RequestMapping("/list")
    @PostMapping
    public Object list(){
        return businessService.list();
    }

}
