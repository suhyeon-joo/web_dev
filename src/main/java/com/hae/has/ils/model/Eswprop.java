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
@Table(name = "eswprop", schema = "emro")
public class Eswprop {
    @EmbeddedId
    private EswpropId id;

    @Column(name = "attr", length = Integer.MAX_VALUE)
    private String attr;

    @Size(max = 50)
    @Column(name = "reg_id", length = 50)
    private String regId;

    @ColumnDefault("now()")
    @Column(name = "reg_dt")
    private Instant regDt;

    @Size(max = 50)
    @Column(name = "mod_id", length = 50)
    private String modId;

    @ColumnDefault("now()")
    @Column(name = "mod_dt")
    private Instant modDt;

}