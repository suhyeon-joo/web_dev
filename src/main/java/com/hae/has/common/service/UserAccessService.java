package com.hae.has.common.service;

import com.hae.global.exception.CommonException;
import com.hae.has.common.dto.LockInfo;

import java.util.List;

public interface UserAccessService {
    public List<LockInfo> getLockInfo() throws CommonException;
}
