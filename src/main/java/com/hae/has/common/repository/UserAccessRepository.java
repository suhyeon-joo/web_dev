package com.hae.has.common.repository;

import com.hae.has.common.dto.LockInfo;
import com.hae.has.common.model.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, String> {

    @Query(value = "SELECT new com.hae.has.common.dto.LockInfo(" +
            "a.accDisableDt as startDt," +
            "a.accDisableNotifyDt as beforeLock," +
            "a.accDisableCd as period" +
            "FROM UserAccess a)")
    List<LockInfo> getLockInfo();
}
