package com.hae.has.common.service;

import com.hae.has.common.dto.LockInfo;
import com.hae.has.common.repository.UserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccessServiceImpl implements UserAccessService{
    @Autowired
    private UserAccessRepository userAccessRepository;

    public List<LockInfo> getLockInfo(){
        return userAccessRepository.getLockInfo();
    }

}
