package com.hae.has.common.service;

import com.hae.global.dto.Header;
import com.hae.global.dto.ResponseData;
import com.hae.global.enums.HeaderCode;
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
                    .message("Invalid credentials")
                    .messageCd(null).build(), null);
        }
        return new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode())
                .message("successfully validateUserCredentials")
                .messageCd(null).build(), result);
    }

    public ResponseData<String> updateUserToken(String userId, String fcmToken, String userToken, String mobileModel, String mobileOs, String osVersion, String appVersion, String writerId) {
        String result = userRepository.upsertUserToken(userId, fcmToken, userToken, mobileModel, mobileOs, osVersion, appVersion, writerId);
        if (result == null) {
            return new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode())
                    .message("Failed to update token")
                    .messageCd(null).build(), null);
        }
        return new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode())
                .message("Token updated successfully")
                .messageCd(null).build(), result);
    }

    public ResponseData<User> getUserById(Long userId) {
        return userRepository.findById(userId)
                .map(user -> new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode())
                        .message("User found")
                        .messageCd(null).build(), user))
                .orElse(new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode()).message("User not found").messageCd(null).build() , null));
    }

    public ResponseData<User> selectUserById(String userId) {
        User user = userRepository.selectUserById(userId);
        if (user == null)
            return new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode())
                .message("Failed to find User")
                .messageCd(null).build(), null);
        return new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode()).message("find User successfully").messageCd(null).build(), user);
    }

    public ResponseData<String> deleteUserToken(String userToken) {
        String result = userRepository.deleteUserToken(userToken);
        if (result == null) {
            return new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode())
                    .message("Failed to delete token")
                    .messageCd(null).build(), null);
        }
        return new ResponseData<>(Header.builder().code(HeaderCode.OK.getCode())
                .message("Token deleted successfully")
                .messageCd(null).build(), result);

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
