package com.blackey.bys.components.service.impl;

import com.blackey.bys.components.model.Record;
import com.blackey.bys.components.repository.RecordRepo;
import com.blackey.bys.components.service.RecordService;
import com.blackey.bys.dto.RecordForm;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService{

    @Resource
    RecordRepo recordRepo;

    public void save(RecordForm form){
        Record record = new Record();
        BeanUtils.copyProperties(form,record);
        recordRepo.save(record);
    }

    @Override
    public void update(String id,String score, String confirm) {
        Record record = recordRepo.getOne(id);
        recordRepo.save(record);
    }

    @Override
    public Page<Record> pagelist(Pageable pageable) {
        return recordRepo.findAll(pageable);
    }
}
