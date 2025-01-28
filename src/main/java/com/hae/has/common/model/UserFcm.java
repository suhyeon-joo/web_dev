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
@Table(name="user_fcm", schema="v4")
public class UserFcm extends BaseVO implements Serializable {

    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "fcm_token")
    private String fcmToken;

    @Id
    @Column(name = "user_token")
    private String userToken;

    @Column(name = "mobile_model")
    private String mobileModel;

    @Column(name = "mobile_os")
    private String mobileOs;

    @Column(name = "os_version")
    private String osVersion;
    @Column(name = "app_version")
    private String app_version;
    @Column(name = "writer_id")
    private String writerId;
    @Column(name = "created_dt")
    private LocalDateTime createdDt;
    @Column(name = "updated_dt")
    private LocalDateTime updatedDt;
}
