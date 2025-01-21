package com.hae.web.has.user.model;

import com.hae.web.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Entity
@Table(name="esauser", schema="emro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EsaUser extends BaseVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1705604107508467237L;

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name = "usr_id", nullable = false, length = 50)
    private String usrId;

    @Column(name = "comp_cd", length = 18)
    private String compCd;

    @Column(name = "usr_nm", length = 100)
    private String usrNm;

    @Column(name = "usr_en_nm", length = 100)
    private String usrEnNm;

    @Column(name = "usr_cls", length = 18)
    private String usrCls;

    @Column(name = "job_role", length = 18)
    private String jobRole;

    @Column(name = "job_cd", length = 18)
    private String jobCd;

    @Column(name = "pos_cd", length = 18)
    private String posCd;

    @Column(name = "emp_no", length = 60)
    private String empNo;

    @Column(name = "dept_cd", length = 30)
    private String deptCd;

    @Column(name = "vd_cd", length = 50)
    private String vdCd;

    @Column(name = "use_yn", length = 1)
    private String useYn;

    @Column(name = "mobile_no", length = 60)
    private String mobileNo;

    @Column(name = "phone_no", length = 60)
    private String phoneNo;

    @Column(name = "fax_no", length = 60)
    private String faxNo;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "pw", length = 200)
    private String pw;

    @Column(name = "pw_mod_dt")
    private LocalDateTime pwModDt;

    @Column(name = "rem", length = 128)
    private String rem;

    @Column(name = "portal_cls", length = 18)
    private String portalCls;

    @Column(name = "mail_received_yn", length = 1)
    private String mailReceivedYn;

    @Column(name = "sms_received_yn", length = 1)
    private String smsReceivedYn;

    @Column(name = "pw_miss_cnt")
    private Integer pwMissCnt;

    @Column(name = "pw_init_yn", length = 1)
    private String pwInitYn;

    @Column(name = "last_login_dt")
    private LocalDateTime lastLoginDt;

    @Column(name = "last_login_ip", length = 100)
    private String lastLoginIp;

    @Column(name = "acc_expire_yn", length = 1)
    private String accExpireYn;

    @Column(name = "acc_lock_yn", length = 1)
    private String accLockYn;

    @Column(name = "pw_mod_require_yn", length = 1)
    private String pwModRequireYn;

    @Column(name = "pre_login_dt")
    private LocalDateTime preLoginDt;

    @Column(name = "pre_login_ip", length = 20)
    private String preLoginIp;

    @Column(name = "timezone_cd", length = 18)
    private String timezoneCd;

    @Column(name = "sts", length = 1)
    private String sts;

    @Column(name = "reg_id", length = 18)
    private String regId;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 50)
    private String modId;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @Column(name = "property", columnDefinition = "json")
    private Map<String, Object> property;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "site_id")
    private Long siteId;

    @Column(name = "access_level", length = 30)
    private String accessLevel;

    @Column(name = "site_ids", columnDefinition = "bigint[]")
    private List<Long> siteIds;

    @Column(name = "home_typ", length = 20)
    private String homeTyp;

    @Column(name = "auth_type", length = 18)
    private String authType;


}
