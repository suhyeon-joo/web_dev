package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "esaaufm", schema = "emro")
public class Esaaufm {
    @EmbeddedId
    private EsaaufmId id;

    @Size(max = 18)
    @Column(name = "reg_id", length = 18)
    private String regId;

    @ColumnDefault("now()")
    @Column(name = "reg_dt")
    private Instant regDt;

    @Column(name = "sort_ord")
    private Integer sortOrd;

}