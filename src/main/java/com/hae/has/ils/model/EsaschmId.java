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
public class EsaschmId implements java.io.Serializable {
    private static final long serialVersionUID = -2311865188147768407L;
    @Size(max = 18)
    @NotNull
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Size(max = 50)
    @NotNull
    @Column(name = "sche_id", nullable = false, length = 50)
    private String scheId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EsaschmId entity = (EsaschmId) o;
        return Objects.equals(this.sysId, entity.sysId) &&
                Objects.equals(this.scheId, entity.scheId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysId, scheId);
    }

}