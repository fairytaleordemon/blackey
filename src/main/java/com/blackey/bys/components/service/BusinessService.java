package com.blackey.bys.components.service;


import com.blackey.bys.components.model.Business;
import com.blackey.bys.dto.BusinessForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BusinessService {

    void save(BusinessForm form);

    Page<Business> page(Pageable pageable);

    List<Business> list();
}
