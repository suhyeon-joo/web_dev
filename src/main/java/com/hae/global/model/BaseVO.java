package com.hae.global.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
public class BaseVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6866471681676874409L;

    private int rnum;
    private int totalsize;
    private String baseUserId;
    private String rowStatus;
}
