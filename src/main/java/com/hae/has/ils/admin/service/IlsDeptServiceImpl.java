package com.hae.has.ils.admin.service;


import com.hae.global.dto.Header;
import com.hae.global.dto.ResponseData;
import com.hae.global.enums.HeaderCode;
import com.hae.global.enums.HeaderMsg;
import com.hae.global.exception.CommonException;
import com.hae.has.ils.admin.model.IlsDept;
import com.hae.has.ils.admin.repository.IlsDeptRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.jdbc.Expectation;
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

    public ResponseData<List<IlsDept>> getDeptList(Long siteId, String deptName) {
        List<IlsDept> ilsDepts;
        if (deptName != null && !deptName.isEmpty()) {
            ilsDepts = ilsDeptRepository.findBySiteIdAndIlsDeptNameContainingIgnoreCase(siteId, deptName);
            return new ResponseData<>(
                    Header.builder()
                            .code(HeaderCode.OK.getCode())
                            .message(HeaderMsg.ILS_DEPT_LIST_FOUND.getMsg())
                            .build(),
                    ilsDepts
            );

        }
        ilsDepts = ilsDeptRepository.findBySiteId(siteId);
        return new ResponseData<>(
                Header.builder()
                        .code(HeaderCode.OK.getCode())
                        .message(HeaderMsg.ILS_DEPT_LIST_FOUND.getMsg())
                        .build(),
                ilsDepts
        );
    }

    public ResponseData<IlsDept> getDept(Long siteId, Long deptId) {
        IlsDept ilsDept = ilsDeptRepository.findBySiteIdAndIlsDeptId(siteId, deptId);

        return new ResponseData<>(
                Header.builder()
                        .code(HeaderCode.OK.getCode())
                        .message("get dept.")
                        .build(),
                ilsDept
        );
    }

    public ResponseData<IlsDept> saveDept(IlsDept ilsDept) {
        ilsDeptRepository.save(ilsDept);

        return new ResponseData<>(
                Header.builder()
                        .code(HeaderCode.OK.getCode())
                        .message("save dept")
                        .build(),
                ilsDept
        );
    }

    public ResponseData<Void> deleteDept(Long siteId, Long deptId) {
        ResponseData<IlsDept> ilsDept = getDept(siteId, deptId);
        ilsDeptRepository.delete(ilsDept.getBody());

        return new ResponseData<>(
                Header.builder()
                        .code(HeaderCode.OK.getCode())
                        .message("delete Dept")
                        .build(),
                null
        );
    }
}