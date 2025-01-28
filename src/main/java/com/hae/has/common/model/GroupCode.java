package com.hae.has.common.model;


import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "esacdgp", schema = "emro")
@Data
public class GroupCode extends BaseVO implements Serializable {

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name = "grp_cd", nullable = false, length = 18)
    private String grpCd;

    @Column(name = "grp_cd_nm", length = 60)
    private String grpCdNm;

    @Column(name = "grp_cd_en_nm", length = 60)
    private String grpCdEnNm;

    @Column(name = "use_yn", length = 1)
    private String useYn;

    @Column(name = "rem", length = 2000)
    private String rem;

    @Column(name = "sts", length = 1, columnDefinition = "character(1) DEFAULT 'C'")
    private String sts;

    @Column(name = "reg_id", length = 18)
    private String regId;

    @Column(name = "reg_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 18)
    private String modId;

    @Column(name = "mod_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime modDt;

    @Column(name = "cd_typ", length = 18)
    private String cdTyp;
}