package com.hae.has.common.model;

import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.*;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="esauser", schema="emro")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "User.spCheckIdPwd",
                procedureName = "v4.sp_check_id_pwd",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pwd", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spUpsertUserToken",
                procedureName = "v4.sp_upsert_user_token",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcmToken", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userToken", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "mobileModel", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "mobileOs", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "osVersion", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "appVersion", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "writerId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spDeleteUserToken",
                procedureName = "v4.sp_delete_user_token",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userToken", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spDeleteUserTokenByID",
                procedureName = "v4.sp_delete_user_token_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spDeleteUserFcmByNotLogin",
                procedureName = "v4.sp_delete_user_fcm_by_not_login",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spSelectUsersSiteListByPvk",
                procedureName = "v4.sp_select_users_site_list_by_pvk",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pvk", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "includeNotUse", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spSelectUsersCompanyListByPvk",
                procedureName = "v4.sp_select_users_company_list_by_pvk",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pvk", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "includeNotUse", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spSelectUsersListByPvk",
                procedureName = "v4.sp_select_users_list_by_pvk",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pvk", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spCheckAccessCompany",
                procedureName = "v4.sp_check_access_company",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userToken", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "companyId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spCheckAccessSite",
                procedureName = "v4.sp_check_access_site",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userToken", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "siteId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spSelectAllUserByUserToken",
                procedureName = "v4.sp_select_all_user_by_user_token",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userToken", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spSelectUserByPvk",
                procedureName = "v4.sp_select_user_by_pvk",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pvk", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spSelectUserDetailById",
                procedureName = "v4.sp_select_user_detail_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "User.spSelectUserListBySiteId",
                procedureName = "v4.sp_select_user_list_by_site_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "siteId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
                }
        )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User extends BaseVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1705604107508467237L;

    @Id
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Id
    @Column(name = "usr_id", nullable = false, length = 50, unique = true)
    private String usrId;

    @Column(name = "comp_cd", length = 18, nullable = false)
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


    @Type(JsonType.class)
    @Column(columnDefinition = "json")
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
