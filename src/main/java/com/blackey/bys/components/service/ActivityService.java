package com.blackey.bys.components.service;

import com.blackey.bys.components.model.Activity;
import com.blackey.bys.dto.ActivityForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ActivityService {

    Page<Activity> page(Pageable pageable);

    Optional detail(String id);

    void save(ActivityForm form);
}
