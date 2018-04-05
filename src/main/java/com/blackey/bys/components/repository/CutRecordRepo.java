package com.blackey.bys.components.repository;

import com.blackey.bys.components.model.CutRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CutRecordRepo extends JpaRepository<CutRecord,String> {


    @Query("select c from CutRecord c where c.userinfo.openId = ?1")
    List<CutRecord> selectByOpenId(String openId);
}
