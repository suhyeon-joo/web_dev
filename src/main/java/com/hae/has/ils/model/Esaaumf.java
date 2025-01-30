package com.hae.has.ils.model;

import com.hae.has.common.model.MenuInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "esaaumf", schema = "emro")
public class Esaaumf {
    @EmbeddedId
    private EsaaumfId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_cd", referencedColumnName = "menu_cd")
    private MenuInfo esaaumm;

    @Size(max = 60)
    @Column(name = "func_nm", length = 60)
    private String funcNm;

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