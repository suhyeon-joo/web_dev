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
@Table(name = "ils_auth_transfer", schema = "v4")
public class IlsAuthTransfer {
    @EmbeddedId
    private IlsAuthTransferId id;

    @Size(max = 50)
    @Column(name = "wrk_id", length = 50)
    private String wrkId;

    @Size(max = 50)
    @NotNull
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @Size(max = 50)
    @NotNull
    @Column(name = "trans_user_id", nullable = false, length = 50)
    private String transUserId;

    @Size(max = 50)
    @NotNull
    @Column(name = "location_id", nullable = false, length = 50)
    private String locationId;

    @Size(max = 50)
    @Column(name = "wrk_code", length = 50)
    private String wrkCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "rq_status_code", nullable = false, length = 50)
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