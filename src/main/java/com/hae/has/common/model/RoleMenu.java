package com.hae.has.common.model;

import com.hae.global.model.BaseVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "esaaurm", schema = "emro")
@Data
public class RoleMenu extends BaseVO implements Serializable {

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name = "role_cd", nullable = false, length = 18)
    private String roleCd;

    @Id
    @Column(name = "menu_cd", nullable = false, length = 18)
    private String menuCd;

    @Column(name = "reg_id", length = 18)
    private String regId;

    @Column(name = "reg_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 18)
    private String modId;

    @Column(name = "mod_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime modDt;
}