package com.hae.has.common.service;

import com.hae.global.dto.ResponseData;
import com.hae.global.exception.CommonException;
import com.hae.has.common.model.User;
import com.hae.has.common.model.UserFcm;

import java.util.List;

public interface UserService {
    public ResponseData<String> validateUserCredentials(String accountId, String password) throws CommonException;
    public ResponseData<String> updateUserToken(String userId, String fcmToken, String userToken, String mobileModel, String mobileOs, String osVersion, String appVersion, String writerId) throws CommonException;
    public ResponseData<String> deleteUserToken(String userToken) throws CommonException;
    public ResponseData<User> getUserById(Long userId) throws CommonException;
    public User craeteUser(User user) throws CommonException;
    public List<UserFcm> getFcmListByUserId(String userId) throws CommonException;

    public ResponseData<User> selectUserById(String userId) throws CommonException;
}
