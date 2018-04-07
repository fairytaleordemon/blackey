package com.blackey.bys.components.service.impl;

import com.blackey.bys.common.ResultCodeEnum;
import com.blackey.bys.common.exception.BusinessException;
import com.blackey.bys.components.model.Activity;
import com.blackey.bys.components.model.Record;
import com.blackey.bys.components.model.UserInfo;
import com.blackey.bys.components.repository.ActivityRepo;
import com.blackey.bys.components.repository.RecordRepo;
import com.blackey.bys.components.service.ActivityService;
import com.blackey.bys.components.service.RecordService;
import com.blackey.bys.components.service.UserInfoService;
import com.blackey.bys.dto.RecordForm;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static com.blackey.bys.common.ResultCodeEnum.SALECODE_INCORRECT;

@Service
public class RecordServiceImpl implements RecordService{

    @Resource
    RecordRepo recordRepo;

    @Resource
    UserInfoService userInfoService;

    @Resource
    ActivityRepo activityRepo;

    public void save(RecordForm form){
        Record record = new Record();
        UserInfo userInfo = userInfoService.selectByOpenId(form.getOpenId());
        Activity activity = activityRepo.getOne(form.getActivityNo());
        record.setActivity(activity);
        record.setUser(userInfo);
        record.setStatus("待使用");
        recordRepo.save(record);
    }

    @Override
    public void update(String id,String code) throws BusinessException{
        Record record = recordRepo.getOne(id);

        if (!record.getActivity().getBusiness().getSaleCode().equals(code)){
            throw new BusinessException(ResultCodeEnum.SALECODE_INCORRECT);
        }
        record.setStatus("已使用");
        recordRepo.save(record);
    }

    @Override
    public Page<Record> pagelist(Pageable pageable) {
        return recordRepo.findAll(pageable);
    }
}
