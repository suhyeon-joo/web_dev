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

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "product", schema = "v4")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "product_name", length = 100)
    private String productName;

    @Column(name = "up_product_id")
    private Long upProductId;

    @Size(max = 50)
    @NotNull
    @Column(name = "model_no", nullable = false, length = 50)
    private String modelNo;

    @Size(max = 18)
    @Column(name = "product_type", length = 18)
    private String productType;

    @Size(max = 50)
    @Column(name = "sw_ver", length = 50)
    private String swVer;

    @Size(max = 18)
    @Column(name = "power_type", length = 18)
    private String powerType;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Size(max = 18)
    @Column(name = "com_type", length = 18)
    private String comType;

    @ColumnDefault("'Y'")
    @Column(name = "has_app_key", length = Integer.MAX_VALUE)
    private String hasAppKey;

    @ColumnDefault("'Y'")
    @Column(name = "support_standard", length = Integer.MAX_VALUE)
    private String supportStandard;

    @Size(max = 500)
    @Column(name = "ref_product", length = 500)
    private String refProduct;

    @Size(max = 2000)
    @Column(name = "note", length = 2000)
    private String note;

    @Size(max = 50)
    @Column(name = "att_grp_code", length = 50)
    private String attGrpCode;

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