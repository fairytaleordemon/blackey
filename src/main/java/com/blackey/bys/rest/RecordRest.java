package com.blackey.bys.rest;

import com.blackey.bys.common.BaseRest;
import com.blackey.bys.common.Result;
import com.blackey.bys.common.exception.BusinessException;
import com.blackey.bys.components.service.RecordService;
import com.blackey.bys.dto.RecordForm;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/server/record")
@RestController
public class RecordRest extends BaseRest{

    @Resource
    private RecordService recordService;

    @RequestMapping("/save")
    @PostMapping
    public Result save(@ModelAttribute  RecordForm form){
        recordService.save(form);
        return success();
    }

    @RequestMapping("/blackey/update")
    @PostMapping
    public Result update(String id,String code){
        recordService.update(id, code);
        return success();
    }

    @RequestMapping("/blackey/list")
    @PostMapping
    public Result list(Pageable pageable){
        return success(recordService.pagelist(pageable));
    }

}
