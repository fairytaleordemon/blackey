package com.blackey.bys.components.service;


import com.blackey.bys.common.exception.BusinessException;
import com.blackey.bys.components.model.Record;
import com.blackey.bys.dto.RecordForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecordService {

    /**
     * 生成订单
     * @param form
     */
    void save(RecordForm form);

    /**
     * 输入核销码进行核销
     * @param id 订单
     * @param code 核销码
     * @throws BusinessException
     */
    void update(String id,String code) throws BusinessException;

    Page<Record> pagelist(Pageable pageable);
}
