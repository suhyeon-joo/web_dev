package com.hae.has.ils.controller;

import com.hae.global.dto.ResponseData;
import com.hae.global.enums.HeaderCode;
import com.hae.has.ils.model.IlsDept;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hae.has.ils.service.IlsDeptService;
import java.util.List;

/**
 * ILS 부서 관리 API 컨트롤러
 */
@Log4j2
@RestController
@RequestMapping("/api/ils/dept")
@Tag(name = "ILS 부서 관리", description = "ILS 부서 관리 API")
public class IlsDeptController {

    @Autowired
    private IlsDeptService ilsDeptService;

    @Operation(summary = "ILS 부서 목록 조회", description = "특정 사이트의 부서 목록을 조회합니다.")
    @GetMapping("/list")
    public ResponseEntity<ResponseData<List<IlsDept>>> getDeptList(
            @RequestParam Long siteId,
            @RequestParam(required = false) String deptName) {
        ResponseData<List<IlsDept>>responseData= ilsDeptService.getDeptList(siteId, deptName);
        if(responseData.getHeader().getCode() == HeaderCode.OK.getCode())
            return ResponseEntity.status(HttpStatus.OK).body(responseData);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    @Operation(summary = "ILS 부서 단건 조회", description = "특정 부서 정보를 조회합니다.")
    @GetMapping("/{deptId}")
    public ResponseEntity<ResponseData<IlsDept>> getDept(
            @RequestParam Long siteId,
            @PathVariable Long deptId) {

        ResponseData<IlsDept> responseData= ilsDeptService.getDept(siteId, deptId);
        if(responseData.getHeader().getCode() == HeaderCode.OK.getCode())
            return ResponseEntity.status(HttpStatus.OK).body(responseData);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    @Operation(summary = "ILS 부서 저장", description = "새로운 부서를 저장합니다.")
    @PostMapping("/save")
    public ResponseEntity<ResponseData<IlsDept>> saveDept(@RequestBody IlsDept ilsDept) {

        ResponseData<IlsDept> responseData = ilsDeptService.saveDept(ilsDept);
        if(responseData.getHeader().getCode() == HeaderCode.OK.getCode())
            return ResponseEntity.status(HttpStatus.OK).body(responseData);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    @Operation(summary = "ILS 부서 삭제", description = "특정 부서를 삭제합니다.")
    @DeleteMapping("/delete/{deptId}")
    public ResponseEntity<ResponseData<Void>> deleteDept(
            @RequestParam Long siteId,
            @PathVariable Long deptId) {

        ResponseData<Void> responseData = ilsDeptService.deleteDept(siteId, deptId);

        if(responseData.getHeader().getCode() == HeaderCode.OK.getCode())
            return ResponseEntity.status(HttpStatus.OK).body(responseData);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
}