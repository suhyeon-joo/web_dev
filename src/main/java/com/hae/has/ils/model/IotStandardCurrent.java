package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "iot_standard_current", schema = "v4")
public class IotStandardCurrent {
    @Id
    @Column(name = "created_dt")
    private Instant createdDt;

    @Column(name = "site_id")
    private Long siteId;

    @Column(name = "node_seq")
    private Long nodeSeq;

    @Size(max = 50)
    @Column(name = "node_serial_no", length = 50)
    private String nodeSerialNo;

    @Column(name = "rssi")
    private Integer rssi;

    @Size(max = 50)
    @Column(name = "power", length = 50)
    private String power;

    @Size(max = 50)
    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "battery")
    private Integer battery;

    @Column(name = "measurements")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> measurements;

}