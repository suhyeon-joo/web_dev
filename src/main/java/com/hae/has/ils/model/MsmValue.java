package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "msm_value", schema = "v4")
public class MsmValue {
    @Id
    @Column(name = "seq")
    private Long seq;

    @Column(name = "device_seq")
    private Long deviceSeq;

    @Column(name = "site_id")
    private Long siteId;

    @Size(max = 100)
    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "v1")
    private Double v1;

    @Column(name = "v2")
    private Double v2;

    @Column(name = "v3")
    private Double v3;

    @Size(max = 500)
    @Column(name = "mark", length = 500)
    private String mark;

    @Size(max = 1000)
    @Column(name = "reserved", length = 1000)
    private String reserved;

    @Column(name = "location_seq")
    private Long locationSeq;

    @Column(name = "updated_dt")
    private Instant updatedDt;

    @Column(name = "v4")
    private Double v4;

}