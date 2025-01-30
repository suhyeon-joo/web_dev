package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class IlsItemId implements java.io.Serializable {
    private static final long serialVersionUID = 484226457585865615L;
    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @NotNull
    @Column(name = "itm_id", nullable = false)
    private Long itmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IlsItemId entity = (IlsItemId) o;
        return Objects.equals(this.itmId, entity.itmId) &&
                Objects.equals(this.siteId, entity.siteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itmId, siteId);
    }

}