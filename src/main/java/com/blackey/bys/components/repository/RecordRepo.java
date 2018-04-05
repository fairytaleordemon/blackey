package com.blackey.bys.components.repository;

import com.blackey.bys.components.model.Record;
import com.blackey.bys.components.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepo extends JpaRepository<Record,String>{


}
