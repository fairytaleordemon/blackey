package com.blackey.bys.components.repository;

import com.blackey.bys.components.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ActivityRepo extends JpaRepository<Activity,String> {
}
