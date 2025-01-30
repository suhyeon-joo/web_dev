package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ils_worker_unlock_abandon_log", schema = "v4")
public class IlsWorkerUnlockAbandonLog {
    @Id
    @Column(name = "ils_worker_unlock_abandon_log_id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Size(max = 50)
    @NotNull
    @Column(name = "wrk_id", nullable = false, length = 50)
    private String wrkId;

    @Size(max = 50)
    @NotNull
    @Column(name = "location_id", nullable = false, length = 50)
    private String locationId;

    @NotNull
    @Column(name = "site_product_id", nullable = false)
    private Long siteProductId;

    @Size(max = 50)
    @Column(name = "wrkr_name", length = 50)
    private String wrkrName;

    @Size(max = 11)
    @Column(name = "wrkr_mobile_no", length = 11)
    private String wrkrMobileNo;

    @Column(name = "abnd_dt")
    private Instant abndDt;

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