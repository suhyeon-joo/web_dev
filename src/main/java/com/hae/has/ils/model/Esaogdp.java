package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "esaogdp", schema = "emro")
public class Esaogdp {
    @EmbeddedId
    private EsaogdpId id;

    @Size(max = 100)
    @Column(name = "dept_nm", length = 100)
    private String deptNm;

    @Size(max = 100)
    @Column(name = "dept_en_nm", length = 100)
    private String deptEnNm;

    @Size(max = 30)
    @Column(name = "up_dept_cd", length = 30)
    private String upDeptCd;

    @Column(name = "use_yn", length = Integer.MAX_VALUE)
    private String useYn;

    @Size(max = 2000)
    @Column(name = "rem", length = 2000)
    private String rem;

    @ColumnDefault("'C'")
    @Column(name = "sts", length = Integer.MAX_VALUE)
    private String sts;

    @Size(max = 18)
    @Column(name = "reg_id", length = 18)
    private String regId;

    @ColumnDefault("now()")
    @Column(name = "reg_dt")
    private Instant regDt;

    @Size(max = 18)
    @Column(name = "mod_id", length = 18)
    private String modId;

    @ColumnDefault("now()")
    @Column(name = "mod_dt")
    private Instant modDt;

}