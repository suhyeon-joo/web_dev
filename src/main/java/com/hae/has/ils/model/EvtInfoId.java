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
public class EvtInfoId implements java.io.Serializable {
    private static final long serialVersionUID = -536092462732725794L;
    @NotNull
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Size(max = 50)
    @NotNull
    @Column(name = "evt_id", nullable = false, length = 50)
    private String evtId;

    @Size(max = 50)
    @NotNull
    @Column(name = "evt_grade", nullable = false, length = 50)
    private String evtGrade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EvtInfoId entity = (EvtInfoId) o;
        return Objects.equals(this.evtGrade, entity.evtGrade) &&
                Objects.equals(this.evtId, entity.evtId) &&
                Objects.equals(this.siteId, entity.siteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evtGrade, evtId, siteId);
    }

}