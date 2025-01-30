package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "esaschl", schema = "emro")
public class Esaschl {
    @Id
    @Size(max = 18)
    @Column(name = "sys_id", length = 18)
    private String sysId;

    @Size(max = 100)
    @Column(name = "job_nm", length = 100)
    private String jobNm;

    @ColumnDefault("now()")
    @Column(name = "sche_start_dt")
    private Instant scheStartDt;

    @ColumnDefault("now()")
    @Column(name = "sche_end_dt")
    private Instant scheEndDt;

    @Size(max = 10)
    @Column(name = "exc_time", length = 10)
    private String excTime;

    @Column(name = "res_msg", length = Integer.MAX_VALUE)
    private String resMsg;

    @Column(name = "res_sts")
    private Boolean resSts;

    @ColumnDefault("now()")
    @Column(name = "reg_dt")
    private Instant regDt;

    @Size(max = 18)
    @Column(name = "executor_id", length = 18)
    private String executorId;

    @ColumnDefault("false")
    @Column(name = "is_manual")
    private Boolean isManual;

    @Size(max = 50)
    @Column(name = "sche_id", length = 50)
    private String scheId;

    @Size(max = 50)
    @Column(name = "log_id", length = 50)
    private String logId;

    @Size(max = 100)
    @Column(name = "etc", length = 100)
    private String etc;

}