package com.hae.has.ils.service;

import com.hae.global.dto.ResponseData;
import com.hae.has.ils.model.IlsDept;

import java.util.List;

public interface IlsDeptService {
    public ResponseData<List<IlsDept>> getDeptList(Long siteId, String deptName);
    public ResponseData<IlsDept> getDept(Long siteId, Long deptId);
    public ResponseData<IlsDept> saveDept(IlsDept ilsDept);
    public ResponseData<Void> deleteDept(Long siteId, Long deptId);
}
