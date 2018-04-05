package com.blackey.bys.components.service.impl;

import com.blackey.bys.common.ResultCodeEnum;
import com.blackey.bys.common.exception.BusinessException;
import com.blackey.bys.components.model.Activity;
import com.blackey.bys.components.model.CutRecord;
import com.blackey.bys.components.model.UserInfo;
import com.blackey.bys.components.repository.ActivityRepo;
import com.blackey.bys.components.repository.CutRecordRepo;
import com.blackey.bys.components.repository.UserInfoRepo;
import com.blackey.bys.components.service.CutRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CutRecordServiceImpl implements CutRecordService{

    @Resource
    private CutRecordRepo cutRecordRepo;

    @Resource
    private UserInfoRepo userInfoRepo;

    @Resource
    private ActivityRepo activityRepo;


    @Override
    public void saveRelation(String openId, String friendId,String activityId) throws BusinessException {
        if (cutRecordRepo.selectRepeat(openId, friendId, activityId) != null){
            throw new BusinessException(ResultCodeEnum.REPEAT_FASE);
        }

        UserInfo userInfo = userInfoRepo.selectByOpenId(openId);
        UserInfo friendUserInfo = userInfoRepo.selectByOpenId(friendId);
        Activity activity = activityRepo.getOne(activityId);

        CutRecord cutRecord = new CutRecord();
        cutRecord.setUserinfo(userInfo);
        cutRecord.setFriend(friendUserInfo);
        cutRecord.setActivity(activity);

        cutRecordRepo.save(cutRecord);
    }

    @Override
    public List<CutRecord> findFriend(String openId, String activity) {
        return cutRecordRepo.selectByOpenId(openId);
    }

}
