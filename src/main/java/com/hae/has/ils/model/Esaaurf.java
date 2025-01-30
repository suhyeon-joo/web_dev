package com.hae.has.ils.model;

import com.hae.has.common.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "esaaurf", schema = "emro")
public class Esaaurf {
    @EmbeddedId
    private EsaaurfId id;


    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "sys_id", referencedColumnName = "sys_id", nullable = false),
            @JoinColumn(name = "role_cd", referencedColumnName = "role_cd", nullable = false)
    })
    private Role esaaurh;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Esaaumf esaaumf;

    @Size(max = 18)
    @Column(name = "reg_id", length = 18)
    private String regId;

    @ColumnDefault("now()")
    @Column(name = "reg_dt")
    private Instant regDt;

}