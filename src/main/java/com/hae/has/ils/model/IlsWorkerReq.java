package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ils_worker_req", schema = "v4")
public class IlsWorkerReq {
    @EmbeddedId
    private IlsWorkerReqId id;

    @Size(max = 100)
    @Column(name = "comp_name", length = 100)
    private String compName;

    @Size(max = 20)
    @Column(name = "rq_status_code", length = 20)
    private String rqStatusCode;

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

}