package com.blackey.bys.components.service;

import com.blackey.bys.components.model.CutRecord;

import java.util.List;

public interface CutRecordService {


    void saveRelation(String openId, String firendId,String activity);

    List<CutRecord> findFirend(String openId,String activity);
}
