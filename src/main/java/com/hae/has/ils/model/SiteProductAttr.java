package com.hae.has.ils.model;

import jakarta.persistence.*;
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
@Table(name = "site_product_attr", schema = "v4")
public class SiteProductAttr {
    @Id
    @Column(name = "site_product_attr_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_product_id")
    private SiteProduct siteProduct;

    @Size(max = 18)
    @Column(name = "attr_code", length = 18)
    private String attrCode;

    @Size(max = 50)
    @Column(name = "attr_name", length = 50)
    private String attrName;

    @Column(name = "attr_val")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> attrVal;

    @ColumnDefault("'Y'")
    @Column(name = "use_flag", length = Integer.MAX_VALUE)
    private String useFlag;

    @Size(max = 50)
    @Column(name = "create_id", length = 50)
    private String createId;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "create_dt")
    private Instant createDt;

    @Size(max = 50)
    @Column(name = "update_id", length = 50)
    private String updateId;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "update_dt")
    private Instant updateDt;

}