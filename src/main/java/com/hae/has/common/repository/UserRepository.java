package com.hae.has.common.repository;

import com.hae.has.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Procedure(name = "User.spCheckIdPwd")
    String checkIdAndPassword(String accountId, String pwd);

    @Procedure(name = "User.spUpsertUserToken")
    String upsertUserToken(String userId, String fcmToken, String userToken, String mobileModel, String mobileOs, String osVersion, String appVersion, String writerId);

    @Procedure(name = "User.spDeleteUserToken")
    String deleteUserToken(String userToken);

    User findByUserId(String userId);
}