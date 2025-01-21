package com.hae.web.has.ils.admin.service;

import com.hae.web.global.dto.ResponseData;
import com.hae.web.has.ils.admin.model.IlsDept;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface IlsDeptService {
    public List<IlsDept> getDeptList(Long siteId, String deptName);
    public IlsDept getDept(Long siteId, Long deptId);
    public IlsDept saveDept(IlsDept ilsDept);
    public void deleteDept(Long siteId, Long deptId);
}
