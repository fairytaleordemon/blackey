package com.blackey.bys.components.repository;

import com.blackey.bys.components.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepo extends JpaRepository<Business,String>{


}
