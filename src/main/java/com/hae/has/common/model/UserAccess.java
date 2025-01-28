package com.hae.has.common.model;


import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "esaaccn", schema = "emro")
public class UserAccess extends BaseVO implements Serializable {

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Column(name = "pw_min_len")
    private Integer pwMinLen;

    @Column(name = "pw_max_len")
    private Integer pwMaxLen;

    @Column(name = "pw_alpha_rule")
    private Integer pwAlphaRule;

    @Column(name = "pw_digit_rule")
    private Integer pwDigitRule;

    @Column(name = "pw_sequence_rule")
    private Integer pwSequenceRule;

    @Column(name = "pw_repeat_rule")
    private Integer pwRepeatRule;

    @Column(name = "pw_special_rule")
    private Integer pwSpecialRule;

    @Column(name = "pw_login_invalid_count")
    private Integer pwLoginInvalidCount;

    @Column(name = "pw_expired_period")
    private Integer pwExpiredPeriod;

    @Column(name = "acc_disable_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime accDisableDt;

    @Column(name = "acc_disable_notify_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime accDisableNotifyDt;

    @Column(name = "acc_disable_use_yn")
    private Boolean accDisableUseYn;

    @Column(name = "acc_disable_by_last_login_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime accDisableByLastLoginDt;

    @Column(name = "acc_disable_cd", length = 18)
    private String accDisableCd;

    @Column(name = "acc_disable_user_notify_cd", length = 18)
    private String accDisableUserNotifyCd;

    @Column(name = "admin_add_authentication")
    private Boolean adminAddAuthentication;

    @Column(name = "rem", length = 2000)
    private String rem;

    @Column(name = "reg_id", length = 18)
    private String regId;

    @Column(name = "reg_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 18)
    private String modId;

    @Column(name = "mod_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime modDt;

}
