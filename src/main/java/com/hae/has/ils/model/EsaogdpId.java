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
public class EsaogdpId implements java.io.Serializable {
    private static final long serialVersionUID = 1838669771071675483L;
    @Size(max = 18)
    @NotNull
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Size(max = 18)
    @NotNull
    @Column(name = "org_typ_cd", nullable = false, length = 18)
    private String orgTypCd;

    @Size(max = 18)
    @NotNull
    @Column(name = "org_cd", nullable = false, length = 18)
    private String orgCd;

    @Size(max = 30)
    @NotNull
    @Column(name = "dept_cd", nullable = false, length = 30)
    private String deptCd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EsaogdpId entity = (EsaogdpId) o;
        return Objects.equals(this.orgCd, entity.orgCd) &&
                Objects.equals(this.sysId, entity.sysId) &&
                Objects.equals(this.orgTypCd, entity.orgTypCd) &&
                Objects.equals(this.deptCd, entity.deptCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgCd, sysId, orgTypCd, deptCd);
    }

}