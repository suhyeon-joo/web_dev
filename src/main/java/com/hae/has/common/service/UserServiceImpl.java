package com.hae.has.common.service;

import com.hae.global.dto.Header;
import com.hae.global.dto.ResponseData;
import com.hae.global.enums.HeaderCode;
import com.hae.global.enums.HeaderCodeMsg;
import com.hae.has.common.model.User;
import com.hae.has.common.model.UserFcm;
import com.hae.has.common.repository.UserFcmRepository;
import com.hae.has.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFcmRepository userFcmRepository;

    public ResponseData<String> validateUserCredentials(String accountId, String password) {
        String result = userRepository.checkIdAndPassword(accountId, password);
        if (result == null) {
            return  new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode())
                    .message(HeaderCodeMsg.ERR_SERVER_DB_QUERY_NOT_WORK.getMsg())
                    .messageCd(HeaderCodeMsg.ERR_SERVER_DB_QUERY_NOT_WORK.getCode()).build(), null);
        }
        return new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode())
                .message(HeaderCodeMsg.AUTH_SUCCESS.getMsg())
                .messageCd(HeaderCodeMsg.AUTH_SUCCESS.getCode()).build(), result);
    }

    public ResponseData<String> updateUserToken(String userId, String fcmToken, String userToken, String mobileModel, String mobileOs, String osVersion, String appVersion, String writerId) {
        String result = userRepository.upsertUserToken(userId, fcmToken, userToken, mobileModel, mobileOs, osVersion, appVersion, writerId);
        if (result == null) {
            return new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode())
                    .message(HeaderCodeMsg.ERR_SERVER_DB_QUERY_NOT_WORK.getMsg())
                    .messageCd(HeaderCodeMsg.ERR_SERVER_DB_QUERY_NOT_WORK.getCode()).build(), null);
        }
        return new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode())
                .message(HeaderCodeMsg.AUTH_TOKEN_UPDATE_SUCCESS.getMsg())
                .messageCd(HeaderCodeMsg.AUTH_TOKEN_UPDATE_SUCCESS.getCode()).build(), result);
    }

    public ResponseData<User> getUserById(Long userId) {
        return userRepository.findById(userId)
                .map(user -> new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode())
                        .message("User found")
                        .messageCd(200).build(), user))
                .orElse(new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode()).message("User not found").messageCd(500).build() , null));
    }

    public ResponseData<User> selectUserById(String userId) {
        User user = userRepository.selectUserById(userId);
        if (user == null)
            return new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode())
                .message("Failed to find User")
                .messageCd(500).build(), null);
        return new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode()).message("find User successfully").messageCd(200).build(), user);
    }

    public ResponseData<String> deleteUserToken(String userToken) {
        String result = userRepository.deleteUserToken(userToken);
        if (result == null) {
            return new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode())
                    .message("Failed to delete token")
                    .messageCd(500).build(), null);
        }
        return new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode())
                .message("Token deleted successfully")
                .messageCd(200).build(), result);

    }

    public User craeteUser(User user){
        user.setBaseUserId(user.getUsrId().toUpperCase());
        user.setSysId("EMRO");
        user.setCompCd("C100");
        if(user.getPwModRequireYn() == null || !"N".equals(user.getPwModRequireYn())){
            user.setPwModRequireYn("Y");
        }
        return userRepository.save(user);
    }

    public List<UserFcm> getFcmListByUserId(String userId){
        return userFcmRepository.findByUserIdAndFcmTokenIsNotNull(userId);
    }
}
