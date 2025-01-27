package com.hae.has.common.service;

import com.hae.global.dto.ResponseData;
import com.hae.has.common.model.User;
import com.hae.has.common.model.UserFcm;

import java.util.List;

public interface UserService {
    public ResponseData<String> validateUserCredentials(String accountId, String password);
    public ResponseData<String> updateUserToken(String userId, String fcmToken, String userToken, String mobileModel, String mobileOs, String osVersion, String appVersion, String writerId);
    public ResponseData<String> deleteUserToken(String userToken);
    public ResponseData<User> getUserById(Long userId);
    public User craeteUser(User user);
    public List<UserFcm> getFcmListByUserId(String userId);
}
