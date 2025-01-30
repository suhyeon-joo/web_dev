package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ils_mp_location_product", schema = "v4")
public class IlsMpLocationProduct {
    @EmbeddedId
    private IlsMpLocationProductId id;

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