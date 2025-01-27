package com.hae.has.common.controller;

import com.hae.global.dto.ResponseData;
import com.hae.has.common.model.User;
import com.hae.has.common.model.UserFcm;
import com.hae.has.common.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {

    @Autowired
    private UserService userService;

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
