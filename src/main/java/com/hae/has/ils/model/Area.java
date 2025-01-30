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
@Table(name = "area", schema = "v4")
public class Area {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Column(name = "publish_id")
    private Long publishId;

    @Column(name = "area_linked_id")
    private Long areaLinkedId;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 50)
    @Column(name = "type", length = 50)
    private String type;

    @Size(max = 500)
    @Column(name = "path", length = 500)
    private String path;

    @Column(name = "pid")
    private Long pid;

    @Column(name = "level")
    private Integer level;

    @ColumnDefault("0")
    @Column(name = "level_order")
    private Integer levelOrder;

    @Column(name = "view_3d")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> view3d;

    @Column(name = "adjunction")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> adjunction;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

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

/*
 TODO [Reverse Engineering] create field to map the 'pin_info' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "pin_info", columnDefinition = "circle")
    private Object pinInfo;
*/
}