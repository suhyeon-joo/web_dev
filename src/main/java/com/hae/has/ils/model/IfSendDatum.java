package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "if_send_data", schema = "v4")
public class IfSendDatum {
    @Id
    @Column(name = "send_seq", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Size(max = 50)
    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "send_data")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> sendData;

    @Column(name = "result", length = Integer.MAX_VALUE)
    private String result;

    @Column(name = "created_dt")
    private Instant createdDt;

    @Column(name = "updated_dt")
    private Instant updatedDt;

}