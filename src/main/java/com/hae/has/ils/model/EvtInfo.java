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
@Table(name = "evt_info", schema = "v4")
public class EvtInfo {
    @EmbeddedId
    private EvtInfoId id;

    @Size(max = 50)
    @Column(name = "evt_name", length = 50)
    private String evtName;

    @Column(name = "noti_system_user", length = Integer.MAX_VALUE)
    private String notiSystemUser;

    @Column(name = "noti_company_user", length = Integer.MAX_VALUE)
    private String notiCompanyUser;

    @Column(name = "noti_site_user", length = Integer.MAX_VALUE)
    private String notiSiteUser;

    @Column(name = "noti_none_user", length = Integer.MAX_VALUE)
    private String notiNoneUser;

    @Column(name = "writer", length = Integer.MAX_VALUE)
    private String writer;

    @Column(name = "created_dt")
    private Instant createdDt;

    @Column(name = "updated_dt")
    private Instant updatedDt;

    @Column(name = "noti_worker", length = Integer.MAX_VALUE)
    private String notiWorker;

    @Column(name = "evt_grade_order")
    private Integer evtGradeOrder;

    @Size(max = 18)
    @Column(name = "menu_code", length = 18)
    private String menuCode;

    @Size(max = 255)
    @Column(name = "url")
    private String url;

    @ColumnDefault("'N'")
    @Column(name = "normal_flag", length = Integer.MAX_VALUE)
    private String normalFlag;

    @Size(max = 500)
    @Column(name = "evt_msg", length = 500)
    private String evtMsg;

}