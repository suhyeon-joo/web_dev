package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "msm_current", schema = "v4")
public class MsmCurrent {
    @Id
    @Column(name = "device_seq", nullable = false)
    private Long id;

    @Column(name = "site_id")
    private Long siteId;

    @Column(name = "data")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> data;

    @Column(name = "updated_dt")
    private Instant updatedDt;

}