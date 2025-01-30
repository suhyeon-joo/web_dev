package com.hae.has.ils.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "esaogmg", schema = "emro")
public class Esaogmg {
    @EmbeddedId
    private EsaogmgId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Esaogtp esaogtp;

    @Size(max = 18)
    @Column(name = "comp_cd", length = 18)
    private String compCd;

    @Size(max = 60)
    @Column(name = "org_nm", length = 60)
    private String orgNm;

    @Size(max = 60)
    @Column(name = "org_en_nm", length = 60)
    private String orgEnNm;

    @Size(max = 18)
    @Column(name = "corp_reg_no", length = 18)
    private String corpRegNo;

    @Size(max = 12)
    @Column(name = "biz_reg_no", length = 12)
    private String bizRegNo;

    @Size(max = 18)
    @Column(name = "nat_cd", length = 18)
    private String natCd;

    @Size(max = 18)
    @Column(name = "city_cd", length = 18)
    private String cityCd;

    @Size(max = 256)
    @Column(name = "addr", length = 256)
    private String addr;

    @Size(max = 256)
    @Column(name = "addr_en", length = 256)
    private String addrEn;

    @Size(max = 128)
    @Column(name = "rep_nm", length = 128)
    private String repNm;

    @Size(max = 128)
    @Column(name = "rep_en_nm", length = 128)
    private String repEnNm;

    @Size(max = 60)
    @Column(name = "phone_no", length = 60)
    private String phoneNo;

    @Size(max = 18)
    @Column(name = "cur", length = 18)
    private String cur;

    @Size(max = 18)
    @Column(name = "lang", length = 18)
    private String lang;

    @Column(name = "use_yn", length = Integer.MAX_VALUE)
    private String useYn;

    @ColumnDefault("'C'")
    @Column(name = "sts", length = Integer.MAX_VALUE)
    private String sts;

    @Size(max = 2000)
    @Column(name = "rem", length = 2000)
    private String rem;

    @Size(max = 18)
    @Column(name = "if_cd", length = 18)
    private String ifCd;

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