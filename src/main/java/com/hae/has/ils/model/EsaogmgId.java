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
public class EsaogmgId implements java.io.Serializable {
    private static final long serialVersionUID = 8199415714559089835L;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EsaogmgId entity = (EsaogmgId) o;
        return Objects.equals(this.orgCd, entity.orgCd) &&
                Objects.equals(this.sysId, entity.sysId) &&
                Objects.equals(this.orgTypCd, entity.orgTypCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgCd, sysId, orgTypCd);
    }

}