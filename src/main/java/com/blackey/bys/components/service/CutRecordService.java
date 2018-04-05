package com.blackey.bys.components.service;

import com.blackey.bys.common.exception.BusinessException;
import com.blackey.bys.components.model.CutRecord;

import java.util.List;

public interface CutRecordService {


    void saveRelation(String openId, String friendId,String activity) throws BusinessException;

    List<CutRecord> findFriend(String openId,String activity);
}
