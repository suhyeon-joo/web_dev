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
public class IlsWorkId implements java.io.Serializable {
    private static final long serialVersionUID = -3677157262825915602L;
    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Size(max = 50)
    @NotNull
    @Column(name = "wrk_id", nullable = false, length = 50)
    private String wrkId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IlsWorkId entity = (IlsWorkId) o;
        return Objects.equals(this.siteId, entity.siteId) &&
                Objects.equals(this.wrkId, entity.wrkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteId, wrkId);
    }

}