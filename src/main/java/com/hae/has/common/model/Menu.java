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
@Table(name = "esaauml", schema = "emro")
@Data
public class Menu extends BaseVO implements Serializable {

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sydId;

    @Id
    @Column(name = "menu_cd", length = 18, nullable = false)
    private String menuCode;

    @Column(name = "menu_nm", length = 60)
    private String menuName;

    @Column(name = "rem", length = 2000)
    private String menuDescription;

    @Column(name = "sts", length = 1)
    private String status;

    @Column(name = "reg_id", length = 18)
    private String regId;

    @Column(name = "reg_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 18)
    private String modId;

    @Column(name = "mod_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime modDt;
}