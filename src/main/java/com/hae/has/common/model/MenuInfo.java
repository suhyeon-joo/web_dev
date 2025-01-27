package com.hae.has.common.model;

import com.hae.global.model.BaseVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="esaaumm", schema = "emro")
public class MenuInfo extends BaseVO implements Serializable {
    @Id
    @Column(name="sys_id", nullable = false, length = 18)
    private String sysId;

    @Column(name="menu_cd", nullable = false, length = 18)
    private String menuCd;

    @Column(name="up_menu_cd", length = 18)
    private String upMenuCd;
    @Column(name="link_url", length = 128)
    private String linkUrl;
    @Column(name="usr_cls", length = 18)
    private String userClass;
    @Column(name="menu_typ", length = 18)
    private String menuType;
    @Column(name="md_cls", length = 18)
    private String moduleClass;
    @Column(name="sort_ord")
    private int sortOrder;
    @Column(name="use_yn", length = 1)
    private String useYn;

    @Column(name="rem", length = 2000)
    private String menuDescription;

    @Column(name="sts", length = 1)
    private String status;
    @Column(name = "reg_id", length = 18)
    private String regId;

    @Column(name = "reg_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 18)
    private String modId;

    @Column(name = "mod_dt", columnDefinition = "timestamp DEFAULT now()")
    private LocalDateTime modDt;

    @Column(name="site_id")
    private int siteId;





}
