package com.hae.has.common.controller;

import com.hae.has.common.dto.LockInfo;
import com.hae.has.common.service.UserAccessService;
import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("api/lock-info")
@RestController
@Tag(name = "사용자 잠금 관련 API", description = "사용자 잠금 관련 API")
public class UserAccessController {
    @Autowired
    private UserAccessService userAccessService;

    @GetMapping
    public ResponseEntity<List<LockInfo>> getLokInfo(){
        List<LockInfo> lockInfo = userAccessService.getLockInfo();
        return ResponseEntity.ok(lockInfo);
    }
}
