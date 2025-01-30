package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "site", schema = "v4")
public class Site {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 500)
    @Column(name = "address", length = 500)
    private String address;

    @Size(max = 50)
    @Column(name = "office_number", length = 50)
    private String officeNumber;

    @Size(max = 500)
    @Column(name = "air_view", length = 500)
    private String airView;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Size(max = 100)
    @ColumnDefault("'AsiaSeoul'::character(1)")
    @Column(name = "current_time_zone", length = 100)
    private String currentTimeZone;

    @Column(name = "start_dt")
    private Instant startDt;

    @Column(name = "end_dt")
    private Instant endDt;

    @Column(name = "start_seq_no")
    private Long startSeqNo;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "adjunction")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> adjunction;

    @ColumnDefault("'Y'")
    @Column(name = "use_flag", length = Integer.MAX_VALUE)
    private String useFlag;

    @Size(max = 50)
    @Column(name = "writer_id", length = 50)
    private String writerId;

    @ColumnDefault("now()")
    @Column(name = "created_dt")
    private Instant createdDt;

    @ColumnDefault("now()")
    @Column(name = "updated_dt")
    private Instant updatedDt;

    @Column(name = "site_type", length = Integer.MAX_VALUE)
    private String siteType;
    @Size(max = 50)
    @Column(name = "biz_class", length = 50)
    private String bizClass;

/*
 TODO [Reverse Engineering] create field to map the 'pin_info' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "pin_info", columnDefinition = "point")
    private Object pinInfo;
*/
}