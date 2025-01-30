package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class IlsWorkerReqId implements java.io.Serializable {
    private static final long serialVersionUID = -4692159102798242967L;
    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Size(max = 50)
    @NotNull
    @Column(name = "wrk_id", nullable = false, length = 50)
    private String wrkId;

    @Size(max = 50)
    @NotNull
    @Column(name = "wrkr_name", nullable = false, length = 50)
    private String wrkrName;

    @Size(max = 20)
    @NotNull
    @Column(name = "wrkr_mobile_no", nullable = false, length = 20)
    private String wrkrMobileNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IlsWorkerReqId entity = (IlsWorkerReqId) o;
        return Objects.equals(this.siteId, entity.siteId) &&
                Objects.equals(this.wrkId, entity.wrkId) &&
                Objects.equals(this.wrkrName, entity.wrkrName) &&
                Objects.equals(this.wrkrMobileNo, entity.wrkrMobileNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteId, wrkId, wrkrName, wrkrMobileNo);
    }

}