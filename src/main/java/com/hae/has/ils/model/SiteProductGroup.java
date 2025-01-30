package com.hae.has.ils.model;

import com.vladmihalcea.hibernate.type.array.LongArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "site_product_group", schema = "v4")
public class SiteProductGroup {
    @Id
    @Column(name = "site_product_group_id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Size(max = 100)
    @NotNull
    @Column(name = "site_product_group_name", nullable = false, length = 100)
    private String siteProductGroupName;

    @Column(name = "site_product_ids")
    @Type(LongArrayType.class)
    private long[] siteProductIds;

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