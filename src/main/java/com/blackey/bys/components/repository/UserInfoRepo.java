package com.blackey.bys.components.repository;

import com.blackey.bys.components.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserInfoRepo extends JpaRepository<UserInfo,String>{

    @Query("select  u from UserInfo  u where u.openId = ?1")
    UserInfo selectByOpenId(String OpenId);
}
