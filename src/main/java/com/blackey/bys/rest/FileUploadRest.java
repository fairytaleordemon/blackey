package com.blackey.bys.rest;


import com.blackey.bys.common.BaseRest;
import com.blackey.bys.common.Result;
import com.blackey.bys.components.service.FileUploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/server/file")
@RestController
public class FileUploadRest extends BaseRest{


    @Resource
    FileUploadService fileUploadService;

    @Resource
    HttpServletRequest request;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        try {
            String fileName = fileUploadService.uploadFile(request,file);
            return success("https://www.ssqushe.com" + fileName);
        } catch (Exception e)
        {
            return failure();
        }
    }

}
