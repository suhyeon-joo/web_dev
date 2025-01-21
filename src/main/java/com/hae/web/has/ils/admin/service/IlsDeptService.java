package com.hae.web.has.ils.admin.service;

import com.hae.web.global.dto.ResponseData;
import com.hae.web.has.ils.admin.model.IlsDept;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface IlsDeptService {
    public ResponseData<List<IlsDept>> getDeptList(Long siteId, String deptName);
    public ResponseData<IlsDept> getDept(Long siteId, Long deptId);
    public ResponseData<IlsDept> saveDept(IlsDept ilsDept);
    public ResponseData<Void> deleteDept(Long siteId, Long deptId);
}
