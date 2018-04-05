package com.blackey.bys.rest;


import com.blackey.bys.common.BaseRest;
import com.blackey.bys.common.Result;
import com.blackey.bys.components.model.CutRecord;
import com.blackey.bys.components.service.CutRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/server/activity")
@RestController
public class CutRecordRest extends BaseRest{

    @Resource
    private CutRecordService cutRecordService;


    @RequestMapping("/save")
    @PostMapping
    public Result save(String openId,String firendId,String activity){
        cutRecordService.saveRelation(openId,firendId,activity);
        return success();
    }

    @RequestMapping("/list")
    @PostMapping
    public Result list(String openId,String activity){
        List<CutRecord> cutRecords =cutRecordService.findFirend(openId,activity);

        return success(cutRecords);
    }
}
