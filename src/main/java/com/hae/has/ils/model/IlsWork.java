package com.hae.has.ils.model;

import com.vladmihalcea.hibernate.type.array.LongArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ils_work", schema = "v4")
public class IlsWork {
    @EmbeddedId
    private IlsWorkId id;

    @Size(max = 50)
    @Column(name = "location_id", length = 50)
    private String locationId;

    @Size(max = 50)
    @Column(name = "user_id", length = 50)
    private String userId;

    @Size(max = 12)
    @Column(name = "wrk_code", length = 12)
    private String wrkCode;

    @Size(max = 100)
    @Column(name = "wrk_name", length = 100)
    private String wrkName;

    @Column(name = "ils_dept_ids")
    @Type(LongArrayType.class)
    private long[] ilsDeptIds;

    @Column(name = "wrk_st_dt")
    private Instant wrkStDt;

    @Size(max = 2)
    @Column(name = "wrk_st_hr", length = 2)
    private String wrkStHr;

    @Size(max = 2)
    @Column(name = "wrk_st_mi", length = 2)
    private String wrkStMi;

    @Column(name = "wrk_ed_dt")
    private Instant wrkEdDt;

    @Size(max = 2)
    @Column(name = "wrk_ed_hr", length = 2)
    private String wrkEdHr;

    @Size(max = 2)
    @Column(name = "wrk_ed_mi", length = 2)
    private String wrkEdMi;

    @Size(max = 4000)
    @Column(name = "wrk_cont", length = 4000)
    private String wrkCont;

    @Column(name = "wrk_cplt_flag", length = Integer.MAX_VALUE)
    private String wrkCpltFlag;

    @Size(max = 50)
    @Column(name = "reg_id", length = 50)
    private String regId;

    @Column(name = "reg_dt")
    private Instant regDt;

    @Size(max = 50)
    @Column(name = "mod_id", length = 50)
    private String modId;

    @Column(name = "mod_dt")
    private Instant modDt;

    @Column(name = "wrk_lvl")
    private Long wrkLvl;

}