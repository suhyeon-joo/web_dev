package com.hae.has.ils.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "site_product", schema = "v4")
public class SiteProduct {
    @Id
    @Column(name = "site_product_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_product_auth_id")
    private ProductSiteAuth siteProductAuth;

    @Column(name = "company_id")
    private Long companyId;

    @Size(max = 50)
    @Column(name = "company_name", length = 50)
    private String companyName;

    @Column(name = "site_id")
    private Long siteId;

    @Size(max = 50)
    @Column(name = "site_name", length = 50)
    private String siteName;

    @Column(name = "product_id")
    private Long productId;

    @Size(max = 100)
    @Column(name = "product_name", length = 100)
    private String productName;

    @Size(max = 50)
    @NotNull
    @Column(name = "serial_no", nullable = false, length = 50)
    private String serialNo;

    @Size(max = 2000)
    @Column(name = "note", length = 2000)
    private String note;

    @Size(max = 18)
    @Column(name = "install_type", length = 18)
    private String installType;

    @Column(name = "xcoord")
    private Short xcoord;

    @Column(name = "ycoord")
    private Short ycoord;

    @Column(name = "zcoord")
    private Short zcoord;

    @Size(max = 50)
    @Column(name = "display_name1", length = 50)
    private String displayName1;

    @Size(max = 50)
    @Column(name = "display_name2", length = 50)
    private String displayName2;

    @Size(max = 50)
    @Column(name = "display_name3", length = 50)
    private String displayName3;

    @Size(max = 100)
    @Column(name = "app_key", length = 100)
    private String appKey;

    @Column(name = "status_check_cycle")
    private Integer statusCheckCycle;

    @NotNull
    @ColumnDefault("'Y'")
    @Column(name = "use_flag", nullable = false, length = Integer.MAX_VALUE)
    private String useFlag;

    @Size(max = 50)
    @Column(name = "create_id", length = 50)
    private String createId;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "create_dt")
    private Instant createDt;

    @Size(max = 50)
    @Column(name = "update_id", length = 50)
    private String updateId;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "update_dt")
    private Instant updateDt;

    @Size(max = 50)
    @Column(name = "icon_img", length = 50)
    private String iconImg;

}