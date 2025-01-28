package com.hae.has.ils.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ILS_DEPT")
public class IlsDept {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ilsDeptSeqGen")
    @SequenceGenerator(name = "ilsDeptSeqGen", sequenceName = "v4.sq_ils_dept_id", allocationSize = 1)
    @Column(name = "ILS_DEPT_ID")
    private Long ilsDeptId;

    @Column(name = "SITE_ID")
    private Long siteId;

    @Column(name = "ILS_DEPT_CODE")
    private String ilsDeptCode;

    @Column(name = "ILS_DEPT_NAME")
    private String ilsDeptName;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "SORT_ORD")
    private Integer sortOrder;

    @Column(name = "USE_FLAG")
    private Boolean useFlag;

    @Column(name = "REG_ID")
    private String regId;

    @Column(name = "REG_DT")
    private LocalDateTime regDate;

    @Column(name = "MOD_ID")
    private String modId;

    @Column(name = "MOD_DT")
    private LocalDateTime modDate;
}