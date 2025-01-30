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
@Table(name = "ils_app_function", schema = "v4")
public class IlsAppFunction {
    @Id
    @Column(name = "app_func_id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "app_func_key", nullable = false, length = 50)
    private String appFuncKey;

    @Size(max = 50)
    @NotNull
    @Column(name = "app_func_name", nullable = false, length = 50)
    private String appFuncName;

    @Size(max = 50)
    @NotNull
    @Column(name = "use_flag", nullable = false, length = 50)
    private String useFlag;

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