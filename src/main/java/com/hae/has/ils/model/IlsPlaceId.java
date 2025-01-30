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
public class IlsPlaceId implements java.io.Serializable {
    private static final long serialVersionUID = 3207140740076440708L;
    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @NotNull
    @Column(name = "place_id", nullable = false)
    private Long placeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IlsPlaceId entity = (IlsPlaceId) o;
        return Objects.equals(this.placeId, entity.placeId) &&
                Objects.equals(this.siteId, entity.siteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, siteId);
    }

}