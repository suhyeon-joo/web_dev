package com.hae.has.common.model;

import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "esaaurp", schema = "emro")
@Data
public class UserRole extends BaseVO implements Serializable {

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name = "comp_cd", nullable = false, length = 18)
    private String compCd;

    @Id
    @Column(name = "usr_id", nullable = false, length = 50)
    private String usrId;

    @Id
    @Column(name = "role_cd", nullable = false, length = 18)
    private String roleCd;

    @Column(name = "rem", length = 2000)
    private String rem;

    @Column(name = "sts", length = 1, columnDefinition = "character (1) DEFAULT 'C'")
    private String sts;

    @Column(name = "reg_id", length = 18)
    private String regId;

    @Column(name = "reg_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 18)
    private String modId;

    @Column(name = "mod_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime modDt;
}
