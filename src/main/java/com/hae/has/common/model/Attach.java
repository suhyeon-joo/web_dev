package com.hae.has.common.model;

import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="esaatth", schema = "emro")
public class Attach extends BaseVO implements Serializable{

    @Id
    @Column(name="sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name="att_id", nullable = false, length = 50)
    private String attId;


    @Column(name="grp_cd", length = 50)
    private String grpCd;
    @Column(name="orgn_file_nm", length = 256)
    private String originalFileName;
    @Column(name="att_file_nm",  length = 256)
    private String attachFileName;
    @Column(name="att_file_path",  length = 500)
    private String attachFilePath;

    @Column(name="att_file_siz")
    private int attachFileSize;

    @Lob
    @Column(name = "file_cont")
    private byte[] fileCont;

    @Column(name = "sort_ord")
    private Integer sortOrd;

    @Column(name = "rem", length = 2000)
    private String rem;

    @Column(name = "sts", length = 1)
    private String sts;

    @Column(name = "reg_id", length = 18)
    private String regId;

    @Column(name = "reg_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 18)
    private String modId;

    @Column(name = "mod_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime modDt;

    @Column(name = "property", columnDefinition = "json")
    private String property;


}
