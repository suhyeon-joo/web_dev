package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "esaschm", schema = "emro")
public class Esaschm {
    @EmbeddedId
    private EsaschmId id;

    @Size(max = 200)
    @Column(name = "sche_nm", length = 200)
    private String scheNm;

    @Size(max = 20)
    @Column(name = "cron_exp", length = 20)
    private String cronExp;

    @Size(max = 100)
    @Column(name = "trg_nm", length = 100)
    private String trgNm;

    @Size(max = 100)
    @Column(name = "trg_grp", length = 100)
    private String trgGrp;

    @Size(max = 100)
    @Column(name = "job_nm", length = 100)
    private String jobNm;

    @Size(max = 100)
    @Column(name = "job_grp", length = 100)
    private String jobGrp;

    @Size(max = 100)
    @Column(name = "clss_nm", length = 100)
    private String clssNm;

    @Size(max = 50)
    @Column(name = "method_nm", length = 50)
    private String methodNm;

    @Size(max = 1000)
    @Column(name = "sche_desc", length = 1000)
    private String scheDesc;

    @Column(name = "stateful_yn", length = Integer.MAX_VALUE)
    private String statefulYn;

    @Column(name = "use_yn", length = Integer.MAX_VALUE)
    private String useYn;

    @Size(max = 18)
    @Column(name = "reg_id", length = 18)
    private String regId;

    @ColumnDefault("now()")
    @Column(name = "reg_dt")
    private Instant regDt;

    @Size(max = 18)
    @Column(name = "mod_id", length = 18)
    private String modId;

    @ColumnDefault("now()")
    @Column(name = "mod_dt")
    private Instant modDt;

    @Column(name = "requestrecovery", length = Integer.MAX_VALUE)
    private String requestrecovery;

}