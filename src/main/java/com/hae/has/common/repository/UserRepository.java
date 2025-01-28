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

    @Procedure(name="User.spDeleteUserFcmByNotLogin")
    void deleteUserFcmByNotLogin();

    @Procedure(name="User.spSelectUsersSiteListByPvk")
    String selectUsersSiteListByPvk(String pvk, String includeNotUse);

    @Procedure(name="User.spSelectUsersCompanyListByPvk")
    String selectUsersCompanyListByPvk(String pvk, String includeNotUse);

    @Procedure(name="User.spSelectUsersListByPvk")
    String selectUsersListByPvk(String pvk);

    @Procedure(name="User.spCheckAccessCompany")
    String checkAccessCompany(String userToken, String companyId);
    @Procedure(name="User.spCheckAccessSite")
    String checkAccessSite(String userToken, String siteId);
    @Procedure(name="User.spSelectAllUserByUserToken")
    String selectAllUserByUserToken(String userToken);
    @Procedure(name="User.spSelectUserByPvk")
    String selectUserByPvk(String userToken);
    @Procedure(name="User.spSelectUserDetailById")
    String selectUserDetailById(String id);
    @Procedure(name="User.spSelectUserListBySiteId")
    String selectUserListBySiteId(String siteId);

    @Procedure(name="User.spSelectUserById")
    User selectUserById(String userId);
    User findByUserId(String userId);
}