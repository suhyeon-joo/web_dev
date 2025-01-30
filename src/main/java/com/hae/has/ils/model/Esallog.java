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
@Table(name = "esallog", schema = "emro")
public class Esallog {
    @Id
    @Size(max = 18)
    @Column(name = "sys_id", length = 18)
    private String sysId;

    @Size(max = 50)
    @Column(name = "log_id", length = 50)
    private String logId;

    @Size(max = 30)
    @Column(name = "usr_id", length = 30)
    private String usrId;

    @Size(max = 18)
    @Column(name = "usr_cls", length = 18)
    private String usrCls;

    @Size(max = 20)
    @Column(name = "login_ip", length = 20)
    private String loginIp;

    @ColumnDefault("now()")
    @Column(name = "login_dt")
    private Instant loginDt;

}