package com.hae.web.has.ils.admin.service;


import com.hae.web.global.exception.CommonException;
import com.hae.web.has.ils.admin.model.IlsDept;
import com.hae.web.has.ils.admin.repository.IlsDeptRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
@Transactional
public class IlsDeptServiceImpl implements IlsDeptService {

    @Autowired
    private IlsDeptRepository ilsDeptRepository;

    public List<IlsDept> getDeptList(Long siteId, String deptName) {
        if (deptName != null && !deptName.isEmpty()) {
            return ilsDeptRepository.findBySiteIdAndIlsDeptNameContainingIgnoreCase(siteId, deptName);
        }
        return ilsDeptRepository.findBySiteId(siteId);
    }

    public IlsDept getDept(Long siteId, Long deptId) {
        return ilsDeptRepository.findBySiteIdAndIlsDeptId(siteId, deptId);
    }

    public IlsDept saveDept(IlsDept ilsDept) {
        return ilsDeptRepository.save(ilsDept);
    }

    public void deleteDept(Long siteId, Long deptId) {
        IlsDept dept = getDept(siteId, deptId);
        ilsDeptRepository.delete(dept);
    }
}