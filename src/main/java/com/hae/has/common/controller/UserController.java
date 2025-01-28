package com.hae.has.common.controller;

import com.hae.global.dto.BaseController;
import com.hae.global.dto.Header;
import com.hae.global.dto.ResponseData;
import com.hae.global.enums.HeaderCode;
import com.hae.global.enums.HeaderMsg;
import com.hae.has.common.dto.ReqUserLogin;
import com.hae.has.common.model.User;
import com.hae.has.common.model.UserFcm;
import com.hae.has.common.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hae.global.dto.NetHeader;
import java.util.List;
import java.util.UUID;

import static com.hae.global.util.StringUtil.marskingName;

@Log4j2
@RestController
@RequestMapping("/external/api/v1.5")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @PostMapping("/users/loginbyform")
    public ResponseEntity<User> loginByForm(@RequestBody ReqUserLogin reqUserLogin, HttpServletRequest request){
        NetHeader h = getHeader(request, "loginByForm");
        // 로그인시에는 헤더 정보를 체크하지 않는다.
        String upperUsrId = reqUserLogin.userId.toString().toUpperCase();


        try {
            ResponseData<String> ret = userService.validateUserCredentials(upperUsrId, reqUserLogin.password);
            if (ret.getHeader().getCode() != HeaderCode.OK.getCode())
            {

                log.error("error with find vaildateUserCrendintial");
                ResponseData<User> result = new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode()).message(HeaderMsg.AUTH_PASSWORD_NOT_MATCH.getMsg()).messageCd(null).build(), null);
                return ResponseEntity.ok(result.getBody());
            }

            UserFcm ut = new UserFcm();
            ut.setUserToken(UUID.randomUUID().toString());
            ResponseData<String> rspHd2 = userService.updateUserToken(upperUsrId, h.fcmToken, ut.getUserToken(),
                    h.deviceModelName, h.osKind, h.osVersion, h.appVersion, upperUsrId);

            if (rspHd2.getHeader().getCode() != HeaderCode.OK.getCode()) {
                log.error("error with find update User Token");
                ResponseData<User> result = new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode()).message("사용자 토큰 업데이트 중 실패하였습니다.").messageCd(null).build(), null);
                return ResponseEntity.ok(result.getBody());
            }

            ResponseData<User> user = userService.selectUserById(upperUsrId);
            user.getBody().setUsrNm(marskingName(user.getBody().getUsrNm()));
            user.getBody().setUserToken(ut.getUserToken());

            return ResponseEntity.ok(user.getBody());
        }
        catch (Exception e)
        {
            log.error("error", e);
            ResponseData<User> result = new ResponseData<>(Header.builder().code(HeaderCode.SERVER_ERROR.getCode()).message(e.toString()).messageCd(null).build(), null);
            return ResponseEntity.ok(result.getBody());
        }
    }


    @PostMapping("/validate")
    @Operation(summary = "Validate user credentials", description = "Validates a user's accountId and password.")
    public ResponseEntity<ResponseData<String>> validateUser(@RequestParam String accountId, @RequestParam String password) {
        ResponseData<String> result = userService.validateUserCredentials(accountId, password);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/token")
    @Operation(summary = "Update user token", description = "Updates the user's FCM token and other details.")
    public ResponseEntity<ResponseData<String>> upsertUserToken(@RequestParam String userId, @RequestParam String fcmToken, @RequestParam String userToken,
                                                                @RequestParam String mobileModel, @RequestParam String mobileOs,
                                                                @RequestParam String osVersion, @RequestParam String appVersion,
                                                                @RequestParam String writerId) {
        ResponseData<String> result = userService.updateUserToken(userId, fcmToken, userToken, mobileModel, mobileOs, osVersion, appVersion, writerId);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/token")
    @Operation(summary = "Delete user token", description = "Deletes the user's token.")
    public ResponseEntity<ResponseData<String>> deleteUserToken(@RequestParam String userToken) {
        ResponseData<String> result = userService.deleteUserToken(userToken);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Fetch a user by their ID.")
    public ResponseEntity<ResponseData<User>> getUserById(@PathVariable Long id) {
        ResponseData<User> result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @Operation(summary = "create user ", description = "유저 생성")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.craeteUser(user));
    }

    @GetMapping("/{userId}/fcm")
    @Operation(summary = "사용자 FCM 정보 조회", description = "특정 사용자 FCM 정보 조회")
    public ResponseEntity<List<UserFcm>> getFcmListByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getFcmListByUserId(userId));
    }
}
