package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "esaerrlog", schema = "emro")
public class Esaerrlog {
    @Id
    @Size(max = 36)
    @NotNull
    @Column(name = "err_id", nullable = false, length = 36)
    private String errId;

    @Size(max = 18)
    @Column(name = "sys_id", length = 18)
    private String sysId;

    @Size(max = 36)
    @Column(name = "menu_cd", length = 36)
    private String menuCd;

    @Size(max = 60)
    @Column(name = "server_ip", length = 60)
    private String serverIp;

    @Size(max = 36)
    @Column(name = "sess_id", length = 36)
    private String sessId;

    @Size(max = 36)
    @Column(name = "exec_id", length = 36)
    private String execId;

    @Size(max = 36)
    @Column(name = "err_cls", length = 36)
    private String errCls;

    @Size(max = 1000)
    @Column(name = "src_path", length = 1000)
    private String srcPath;

    @Size(max = 50)
    @Column(name = "col_no", length = 50)
    private String colNo;

    @Size(max = 50)
    @Column(name = "row_no", length = 50)
    private String rowNo;

    @Size(max = 300)
    @Column(name = "err_msg", length = 300)
    private String errMsg;

    @Column(name = "stacktrace", length = Integer.MAX_VALUE)
    private String stacktrace;

    @Size(max = 36)
    @Column(name = "img_att_file_id", length = 36)
    private String imgAttFileId;

    @Column(name = "err_occur_dt")
    private Instant errOccurDt;

    @Size(max = 30)
    @Column(name = "usr_id", length = 30)
    private String usrId;

    @Size(max = 300)
    @Column(name = "usr_agent", length = 300)
    private String usrAgent;

    @Size(max = 500)
    @Column(name = "usr_msg", length = 500)
    private String usrMsg;

    @Column(name = "usr_exec_his", length = Integer.MAX_VALUE)
    private String usrExecHis;

    @ColumnDefault("now()")
    @Column(name = "reg_dt")
    private Instant regDt;

}