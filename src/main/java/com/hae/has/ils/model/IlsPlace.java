package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ils_place", schema = "v4")
public class IlsPlace {
    @EmbeddedId
    private IlsPlaceId id;

    @Size(max = 50)
    @Column(name = "place_code", length = 50)
    private String placeCode;

    @Size(max = 100)
    @Column(name = "place_name", length = 100)
    private String placeName;

    @Size(max = 1000)
    @Column(name = "note", length = 1000)
    private String note;

    @Size(max = 50)
    @Column(name = "reg_id", length = 50)
    private String regId;

    @Column(name = "reg_dt")
    private Instant regDt;

    @Size(max = 50)
    @Column(name = "mod_id", length = 50)
    private String modId;

    @Column(name = "mod_dt")
    private Instant modDt;

    @Column(name = "sort_ord")
    private Long sortOrd;

    @Column(name = "use_flag", length = Integer.MAX_VALUE)
    private String useFlag;

    @Size(max = 50)
    @Column(name = "grp_cd", length = 50)
    private String grpCd;

    @Column(name = "place_type", length = Integer.MAX_VALUE)
    private String placeType;

}