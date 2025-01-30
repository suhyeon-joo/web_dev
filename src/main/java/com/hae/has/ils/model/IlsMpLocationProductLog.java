package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ils_mp_location_product_log", schema = "v4")
public class IlsMpLocationProductLog {
    @Id
    @Column(name = "mp_location_product_log_id", nullable = false)
    private Long id;

    @Column(name = "site_id")
    private Long siteId;

    @Size(max = 50)
    @Column(name = "location_id", length = 50)
    private String locationId;

    @Column(name = "site_product_id")
    private Long siteProductId;

    @Size(max = 50)
    @Column(name = "reg_id", length = 50)
    private String regId;

    @Column(name = "reg_dt")
    private Instant regDt;

    @Size(max = 50)
    @Column(name = "mod_id", length = 50)
    private String modId;

    @Column(name = "mod_dt")
    private Instant modDt;

}