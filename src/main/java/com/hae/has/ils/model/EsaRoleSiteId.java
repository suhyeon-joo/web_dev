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
public class EsaRoleSiteId implements java.io.Serializable {
    private static final long serialVersionUID = 1508611609799296862L;
    @Size(max = 18)
    @NotNull
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Size(max = 18)
    @NotNull
    @Column(name = "role_cd", nullable = false, length = 18)
    private String roleCd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EsaRoleSiteId entity = (EsaRoleSiteId) o;
        return Objects.equals(this.roleCd, entity.roleCd) &&
                Objects.equals(this.sysId, entity.sysId) &&
                Objects.equals(this.siteId, entity.siteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleCd, sysId, siteId);
    }

}