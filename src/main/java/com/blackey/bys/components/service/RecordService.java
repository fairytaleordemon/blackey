package com.blackey.bys.components.service;


import com.blackey.bys.components.model.Record;
import com.blackey.bys.dto.RecordForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecordService {

    void save(RecordForm form);

    void update(String id, String score, String confirm);

    Page<Record> pagelist(Pageable pageable);
}
