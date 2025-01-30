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

import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "meta", schema = "v4")
public class Meta {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "site_id")
    private Long siteId;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 100)
    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "numb")
    private Integer numb;

    @Column(name = "data", length = Integer.MAX_VALUE)
    private String data;

    @Column(name = "data_json")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> dataJson;

}