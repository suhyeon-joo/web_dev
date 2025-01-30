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
public class IlsUserSignalId implements java.io.Serializable {
    private static final long serialVersionUID = 405207443262314586L;
    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Size(max = 50)
    @NotNull
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @Size(max = 50)
    @NotNull
    @Column(name = "location_id", nullable = false, length = 50)
    private String locationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IlsUserSignalId entity = (IlsUserSignalId) o;
        return Objects.equals(this.locationId, entity.locationId) &&
                Objects.equals(this.siteId, entity.siteId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, siteId, userId);
    }

}