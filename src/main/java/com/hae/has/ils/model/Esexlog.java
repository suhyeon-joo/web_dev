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
@Table(name = "esexlog", schema = "emro")
public class Esexlog {
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

    @Size(max = 18)
    @Column(name = "comp_cd", length = 18)
    private String compCd;

    @Size(max = 200)
    @Column(name = "controller_clss", length = 200)
    private String controllerClss;

    @Size(max = 100)
    @Column(name = "method_name", length = 100)
    private String methodName;

    @Size(max = 18)
    @Column(name = "menu_cd", length = 18)
    private String menuCd;

    @ColumnDefault("now()")
    @Column(name = "access_time")
    private Instant accessTime;

    @Size(max = 20)
    @Column(name = "remote_address", length = 20)
    private String remoteAddress;

    @Size(max = 20)
    @Column(name = "remote_host", length = 20)
    private String remoteHost;

    @Size(max = 200)
    @Column(name = "att_nm", length = 200)
    private String attNm;

}