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
@Table(name = "ils_location", schema = "v4")
public class IlsLocation {
    @EmbeddedId
    private IlsLocationId id;

    @Size(max = 50)
    @Column(name = "up_location_id", length = 50)
    private String upLocationId;

    @Size(max = 10)
    @Column(name = "ils_type_code", length = 10)
    private String ilsTypeCode;

    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "itm_id")
    private Long itmId;

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

    @Column(name = "fiexd_ils_use_flag", length = Integer.MAX_VALUE)
    private String fiexdIlsUseFlag;

}