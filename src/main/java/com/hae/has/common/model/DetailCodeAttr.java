package com.hae.has.common.model;

import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "esadtat", schema = "emro")
@Data
public class DetailCodeAttr extends BaseVO implements Serializable {

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name = "grp_cd", nullable = false, length = 18)
    private String grpCd;

    @Id
    @Column(name = "dtl_cd", nullable = false, length = 20)
    private String dtlCd;

    @Id
    @Column(name = "attr_cd", nullable = false, length = 18)
    private String attrCd;

    @Column(name = "dtl_cd_attr_val", length = 50)
    private String dtlCdAttrVal;

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
            @JoinColumn(name = "grp_cd", referencedColumnName = "grp_cd", insertable = false, updatable = false),
            @JoinColumn(name = "attr_cd", referencedColumnName = "attr_cd", insertable = false, updatable = false)
    })
    private GroupCodeAttr groupCodeAttr;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sys_id", referencedColumnName = "sys_id", insertable = false, updatable = false),
            @JoinColumn(name = "grp_cd", referencedColumnName = "grp_cd", insertable = false, updatable = false),
            @JoinColumn(name = "dtl_cd", referencedColumnName = "dtl_cd", insertable = false, updatable = false)
    })
    private DetailCode detailCode;
}
