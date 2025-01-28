package com.hae.has.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LockInfo {
    private LocalDateTime startDt;
    private String beforeLock;
    private String  period;
}

