package com.hae.has.common.model;


import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
        import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "esaaurh", schema = "emro")
@Data
public class Role extends BaseVO implements Serializable {

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name = "role_cd", nullable = false, length = 18)
    private String roleCd;

    @Column(name = "role_nm", length = 60)
    private String roleNm;

    @Column(name = "role_en_nm", length = 60)
    private String roleEnNm;

    @Column(name = "use_yn", length = 1)
    private String useYn;

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

    @Column(name = "api_flag", length = 1, columnDefinition = "character (1) DEFAULT 'N'")
    private String apiFlag;
}

