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
@Table(name = "ils_user", schema = "v4")
public class IlsUser {
    @EmbeddedId
    private IlsUserId id;

    @Column(name = "ils_dept_id")
    private Long ilsDeptId;

    @Size(max = 20)
    @Column(name = "user_auth", length = 20)
    private String userAuth;

    @Size(max = 10)
    @Column(name = "color_code", length = 10)
    private String colorCode;

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