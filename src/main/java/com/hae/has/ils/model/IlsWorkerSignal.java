package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ils_worker_signal", schema = "v4")
public class IlsWorkerSignal {

    @EmbeddedId
    private IlsWorkerSignalId id;

    @Size(max = 50)
    @NotNull
    @Column(name = "wrkr_name", nullable = false, length = 50)
    private String wrkrName;

    @Size(max = 11)
    @NotNull
    @Column(name = "wrkr_mobile_no", nullable = false, length = 11)
    private String wrkrMobileNo;

    @NotNull
    @Column(name = "site_product_id", nullable = false)
    private Long siteProductId;

    @Size(max = 20)
    @NotNull
    @Column(name = "ils_status_code", nullable = false, length = 20)
    private String ilsStatusCode;

    @Column(name = "lock_dt")
    private Instant lockDt;

    @Column(name = "unlock_dt")
    private Instant unlockDt;

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

    @Column(name = "battery")
    private Long battery;

}