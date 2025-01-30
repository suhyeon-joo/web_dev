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
public class IlsMpLocationProductId implements java.io.Serializable {
    private static final long serialVersionUID = -2966272614810079598L;
    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Size(max = 50)
    @NotNull
    @Column(name = "location_id", nullable = false, length = 50)
    private String locationId;

    @NotNull
    @Column(name = "site_product_id", nullable = false)
    private Long siteProductId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IlsMpLocationProductId entity = (IlsMpLocationProductId) o;
        return Objects.equals(this.siteProductId, entity.siteProductId) &&
                Objects.equals(this.locationId, entity.locationId) &&
                Objects.equals(this.siteId, entity.siteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteProductId, locationId, siteId);
    }

}