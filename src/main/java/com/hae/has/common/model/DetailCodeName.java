package com.hae.has.common.model;

import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "esacddl", schema = "emro")
@Data
public class DetailCodeName extends BaseVO implements Serializable {
    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name = "lang_cd", nullable = false, length = 18)
    private String langCd;

    @Id
    @Column(name = "grp_cd", nullable = false, length = 18)
    private String grpCd;

    @Id
    @Column(name = "dtl_cd", nullable = false, length = 20)
    private String dtlCd;

    @Column(name = "dtl_cd_nm", length = 60)
    private String dtlCdNm;

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

    @Column(name = "dtl_cd_use1", length = 60)
    private String dtlCdUse1;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sys_id", referencedColumnName = "sys_id", insertable = false, updatable = false),
            @JoinColumn(name = "grp_cd", referencedColumnName = "grp_cd", insertable = false, updatable = false),
            @JoinColumn(name = "dtl_cd", referencedColumnName = "dtl_cd", insertable = false, updatable = false)
    })
    private DetailCode detailCode;
}
