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
@Table(name = "iot_node_log", schema = "v4")
public class IotNodeLog {
    @Id
    @Column(name = "seq", nullable = false)
    private Long id;

    @Column(name = "created_dt")
    private Instant createdDt;

    @Column(name = "site_id")
    private Long siteId;

    @Size(max = 50)
    @Column(name = "edge_serial_no", length = 50)
    private String edgeSerialNo;

    @Size(max = 50)
    @Column(name = "ap_serial_no", length = 50)
    private String apSerialNo;

    @Size(max = 50)
    @Column(name = "node_serial_no", length = 50)
    private String nodeSerialNo;

    @Column(name = "payload")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> payload;

    @Size(max = 50)
    @Column(name = "method", length = 50)
    private String method;

}