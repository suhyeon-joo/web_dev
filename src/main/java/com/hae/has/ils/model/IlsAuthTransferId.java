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
public class IlsAuthTransferId implements java.io.Serializable {
    private static final long serialVersionUID = 8345606481852745410L;
    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @NotNull
    @Column(name = "trans_id", nullable = false)
    private Long transId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IlsAuthTransferId entity = (IlsAuthTransferId) o;
        return Objects.equals(this.transId, entity.transId) &&
                Objects.equals(this.siteId, entity.siteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transId, siteId);
    }

}