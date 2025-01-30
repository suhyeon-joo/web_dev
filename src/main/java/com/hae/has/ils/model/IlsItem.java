package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ils_item", schema = "v4")
public class IlsItem {
    @EmbeddedId
    private IlsItemId id;

    @Size(max = 50)
    @Column(name = "itm_code", length = 50)
    private String itmCode;

    @Size(max = 100)
    @Column(name = "itm_name", length = 100)
    private String itmName;

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

    @Column(name = "xcoord")
    private BigDecimal xcoord;

    @Column(name = "ycoord")
    private BigDecimal ycoord;

    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "itm_type", length = Integer.MAX_VALUE)
    private String itmType;

    @Column(name = "mv_place_id")
    private Long mvPlaceId;

}