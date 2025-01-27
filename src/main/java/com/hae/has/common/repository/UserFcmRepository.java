package com.hae.has.common.repository;
import com.hae.has.common.model.UserFcm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFcmRepository {
    List<UserFcm> findByUserIdAndFcmTokenIsNotNull(String userId);
}
