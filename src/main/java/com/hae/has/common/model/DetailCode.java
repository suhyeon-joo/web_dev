package com.hae.has.common.model;

import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "esacddt", schema = "emro")
@Data
public class DetailCode extends BaseVO implements Serializable {

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name = "grp_cd", nullable = false, length = 18)
    private String grpCd;

    @Id
    @Column(name = "dtl_cd", nullable = false, length = 20)
    private String dtlCd;

    @Column(name = "sort_ord")
    private Integer sortOrd;

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

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sys_id", referencedColumnName = "sys_id", insertable = false, updatable = false),
            @JoinColumn(name = "grp_cd", referencedColumnName = "grp_cd", insertable = false, updatable = false)
    })
    private GroupCode groupCode;
}
