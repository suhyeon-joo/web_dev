package com.hae.web.has.ils.admin.controller;

import com.hae.web.global.dto.ResponseData;
import com.hae.web.global.dto.Header;
import com.hae.web.has.ils.admin.model.IlsDept;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hae.web.global.exception.CommonException;
import com.hae.web.has.ils.admin.service.IlsDeptService;
import java.util.List;
import java.util.Map;

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
    public ResponseData<List<IlsDept>> getDeptList(
            @RequestParam Long siteId,
            @RequestParam(required = false) String deptName) {

        List<IlsDept> deptList = ilsDeptService.getDeptList(siteId, deptName);
        return new ResponseData<>(new Header(200, "Success", "ILS_DEPT_LIST_SUCCESS"), deptList);
    }

    @Operation(summary = "ILS 부서 단건 조회", description = "특정 부서 정보를 조회합니다.")
    @GetMapping("/{deptId}")
    public ResponseData<IlsDept> getDept(
            @RequestParam Long siteId,
            @PathVariable Long deptId) {

        IlsDept dept = ilsDeptService.getDept(siteId, deptId);
        return new ResponseData<>(new Header(200, "Success", "ILS_DEPT_GET_SUCCESS"), dept);
    }

    @Operation(summary = "ILS 부서 저장", description = "새로운 부서를 저장합니다.")
    @PostMapping("/save")
    public ResponseData<IlsDept> saveDept(@RequestBody IlsDept ilsDept) {

        IlsDept savedDept = ilsDeptService.saveDept(ilsDept);
        return new ResponseData<>(new Header(201, "Created", "ILS_DEPT_SAVE_SUCCESS"), savedDept);
    }

    @Operation(summary = "ILS 부서 삭제", description = "특정 부서를 삭제합니다.")
    @DeleteMapping("/delete/{deptId}")
    public ResponseData<Void> deleteDept(
            @RequestParam Long siteId,
            @PathVariable Long deptId) {

        ilsDeptService.deleteDept(siteId, deptId);
        return new ResponseData<>(new Header(200, "Success", "ILS_DEPT_DELETE_SUCCESS"));
    }
}