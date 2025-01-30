package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "supplier", schema = "v4")
public class Supplier {
    @Id
    @Column(name = "supplier_id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "supplier_name", length = 100)
    private String supplierName;

    @Size(max = 18)
    @Column(name = "biz_no", length = 18)
    private String bizNo;

    @Size(max = 100)
    @Column(name = "supplier_charge", length = 100)
    private String supplierCharge;

    @Size(max = 50)
    @Column(name = "charge_tel", length = 50)
    private String chargeTel;

    @Size(max = 100)
    @Column(name = "supplier_addr", length = 100)
    private String supplierAddr;

    @Size(max = 500)
    @Column(name = "main_product", length = 500)
    private String mainProduct;

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